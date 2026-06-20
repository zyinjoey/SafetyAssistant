package com.example.safetyassistant.utils

import android.content.Context
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.util.Log
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.ByteArrayOutputStream
import java.util.concurrent.TimeUnit

class BaiduSpeechManager(private val context: Context) {

    private lateinit var audioRecord: AudioRecord
    private var isRecording = false
    private var listener: SpeechResultListener? = null
    private var accessToken: String? = null
    private var tokenExpireTime: Long = 0

    companion object {
        private const val TAG = "BaiduSpeechManager"
        private const val APP_ID = ""
        private const val API_KEY = "5V7CHbD0XP18JIRdwBpZBdLY"
        private const val SECRET_KEY = "xOrdhaLCqBt242cy4RzEwrAhfD9s4ZPN"
        
        private const val TOKEN_URL = "https://aip.baidubce.com/oauth/2.0/token"
        private const val ASR_URL = "https://vop.baidu.com/server_api"
        
        private const val SAMPLE_RATE = 16000
        private const val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO
        private const val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
    }

    interface SpeechResultListener {
        fun onRecognizing(text: String)
        fun onResult(text: String)
        fun onError(error: String)
        fun onStarted()
        fun onFinished()
    }

    fun setListener(listener: SpeechResultListener) {
        this.listener = listener
    }

    fun startListening() {
        if (isRecording) return
        
        Thread {
            try {
                if (accessToken == null || System.currentTimeMillis() > tokenExpireTime) {
                    getAccessToken()
                }
                
                if (accessToken == null) {
                    listener?.onError("获取访问令牌失败，请检查网络和API配置")
                    return@Thread
                }
                
                startRecording()
            } catch (e: Exception) {
                Log.e(TAG, "启动识别失败: ${e.message}")
                listener?.onError("启动失败: ${e.message}")
            }
        }.start()
    }

    fun stopListening() {
        isRecording = false
    }

    fun cancel() {
        isRecording = false
        stopRecording()
    }

    fun release() {
        cancel()
    }

    private fun getAccessToken() {
        try {
            val client = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()

            val url = "$TOKEN_URL?grant_type=client_credentials&client_id=$API_KEY&client_secret=$SECRET_KEY"
            val request = Request.Builder().url(url).get().build()
            
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val json = response.body?.string() ?: ""
                val result = Gson().fromJson(json, TokenResult::class.java)
                accessToken = result.access_token
                tokenExpireTime = System.currentTimeMillis() + (result.expires_in * 1000)
                Log.d(TAG, "获取令牌成功: ${result.access_token?.substring(0, 10)}...")
            } else {
                Log.e(TAG, "获取令牌失败: ${response.code}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "获取令牌异常: ${e.message}")
        }
    }

    private fun startRecording() {
        val bufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, CHANNEL_CONFIG, AUDIO_FORMAT)
        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            SAMPLE_RATE,
            CHANNEL_CONFIG,
            AUDIO_FORMAT,
            bufferSize
        )

        if (audioRecord.state != AudioRecord.STATE_INITIALIZED) {
            listener?.onError("麦克风初始化失败")
            return
        }

        isRecording = true
        listener?.onStarted()
        
        val outputStream = ByteArrayOutputStream()
        audioRecord.startRecording()

        val buffer = ByteArray(bufferSize)
        var silenceCount = 0
        val maxSilenceFrames = (2.0 * SAMPLE_RATE / bufferSize).toInt()

        Thread {
            try {
                while (isRecording) {
                    val read = audioRecord.read(buffer, 0, buffer.size)
                    if (read > 0) {
                        outputStream.write(buffer, 0, read)
                        
                        val hasVoice = buffer.any { Math.abs(it.toInt()) > 50 }
                        if (hasVoice) {
                            silenceCount = 0
                        } else {
                            silenceCount++
                            if (silenceCount > maxSilenceFrames && outputStream.size() > 0) {
                                Log.d(TAG, "检测到静音，停止录音")
                                break
                            }
                        }
                    }
                }
                
                audioRecord.stop()
                audioRecord.release()
                
                if (outputStream.size() > 0) {
                    val pcmData = outputStream.toByteArray()
                    sendToBaidu(pcmData)
                } else {
                    listener?.onError("未检测到语音")
                }
                
                listener?.onFinished()
            } catch (e: Exception) {
                Log.e(TAG, "录音异常: ${e.message}")
                listener?.onError("录音异常: ${e.message}")
                listener?.onFinished()
            }
        }.start()
    }

    private fun stopRecording() {
        try {
            if (audioRecord.state == AudioRecord.STATE_INITIALIZED) {
                audioRecord.stop()
                audioRecord.release()
            }
        } catch (e: Exception) {
            Log.e(TAG, "停止录音异常: ${e.message}")
        }
        isRecording = false
    }

    private fun sendToBaidu(pcmData: ByteArray) {
        try {
            val base64Data = android.util.Base64.encodeToString(pcmData, android.util.Base64.NO_WRAP)
            
            val jsonBody = """
                {
                    "format": "pcm",
                    "rate": $SAMPLE_RATE,
                    "channel": 1,
                    "len": ${pcmData.size},
                    "speech": "$base64Data",
                    "cuid": "SafetyAssistant",
                    "token": "$accessToken"
                }
            """.trimIndent()

            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            val request = Request.Builder()
                .url(ASR_URL)
                .addHeader("Content-Type", "application/json")
                .post(jsonBody.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull()))
                .build()

            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                val json = response.body?.string() ?: ""
                Log.d(TAG, "百度返回: $json")
                parseResult(json)
            } else {
                Log.e(TAG, "请求失败: ${response.code}")
                listener?.onError("识别失败，错误码: ${response.code}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "请求异常: ${e.message}")
            listener?.onError("识别异常: ${e.message}")
        }
    }

    private fun parseResult(json: String) {
        try {
            val result = Gson().fromJson(json, AsrResult::class.java)
            
            if (result.err_no == 0) {
                val text = result.result?.joinToString("") ?: ""
                listener?.onResult(text)
            } else {
                val errorMsg = when (result.err_no) {
                    3301 -> "输入音频为空"
                    3302 -> "音频格式错误"
                    3303 -> "语音过长"
                    3304 -> "音频数据问题"
                    3305 -> "采样率不支持"
                    3307 -> "识别结果为空"
                    3308 -> "语音质量太差"
                    3309 -> "输入参数错误"
                    3310 -> "服务繁忙"
                    3311 -> "内部错误"
                    3312 -> "未找到可用的语音识别服务"
                    3313 -> "token无效或过期"
                    else -> "识别失败: ${result.err_msg}"
                }
                listener?.onError(errorMsg)
            }
        } catch (e: Exception) {
            Log.e(TAG, "解析结果异常: ${e.message}")
            listener?.onError("解析失败")
        }
    }

    data class TokenResult(
        val access_token: String?,
        val expires_in: Int,
        val refresh_token: String?,
        val scope: String?,
        val session_key: String?,
        val session_secret: String?
    )

    data class AsrResult(
        val err_no: Int,
        val err_msg: String?,
        val result: List<String>?,
        val sn: String?
    )
}