package com.example.safetyassistant.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityVoiceBinding
import com.example.safetyassistant.models.CheckResult
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.PermissionUtils
import com.example.safetyassistant.utils.TextCheckUtils
import java.util.Locale

class VoiceActivity : AppCompatActivity(), RecognitionListener {

    private lateinit var binding: ActivityVoiceBinding
    private var isListening = false
    private var speechRecognizer: SpeechRecognizer? = null

    companion object {
        private const val MICROPHONE_PERMISSION_REQUEST = 3001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        checkMicrophonePermission()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnStartListen.setOnClickListener {
            if (isListening) {
                stopListening()
            } else {
                startListening()
            }
        }

        binding.btnWakeWord.setOnClickListener {
            showWakeWordTip()
        }

        binding.btnDetect.setOnClickListener {
            val text = binding.tvResult.text.toString().replace("识别结果：", "")
            if (text.isEmpty() || text == "正在聆听，请说话..." || text == "未能识别，请重试") {
                Toast.makeText(this, "请先进行语音识别", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            detectScam(text)
        }

        if (!SpeechRecognizer.isRecognitionAvailable(this)) {
            binding.btnStartListen.isEnabled = false
            binding.tvStatus.text = "当前设备不支持语音识别"
            Toast.makeText(this, "当前设备不支持语音识别", Toast.LENGTH_LONG).show()
        } else {
            binding.tvStatus.text = "点击按钮开始语音识别"
        }
    }

    private fun checkMicrophonePermission() {
        if (!PermissionUtils.hasPermission(this, Manifest.permission.RECORD_AUDIO)) {
            PermissionUtils.requestPermission(this, Manifest.permission.RECORD_AUDIO, MICROPHONE_PERMISSION_REQUEST)
        }
    }

    private fun startListening() {
        if (!PermissionUtils.hasPermission(this, Manifest.permission.RECORD_AUDIO)) {
            Toast.makeText(this, R.string.permission_microphone, Toast.LENGTH_SHORT).show()
            PermissionUtils.requestPermission(this, Manifest.permission.RECORD_AUDIO, MICROPHONE_PERMISSION_REQUEST)
            return
        }

        if (!SpeechRecognizer.isRecognitionAvailable(this)) {
            Toast.makeText(this, "当前设备不支持语音识别", Toast.LENGTH_SHORT).show()
            return
        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this).apply {
            setRecognitionListener(this@VoiceActivity)
        }

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.CHINESE)
            putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1)
            putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
        }

        isListening = true
        binding.tvStatus.text = getString(R.string.voice_listening)
        binding.ivMic.setColorFilter(getColor(R.color.danger_red))
        binding.btnStartListen.text = "停止"
        binding.tvResult.text = "正在聆听，请说话..."
        binding.btnDetect.isEnabled = false

        speechRecognizer?.startListening(intent)
    }

    private fun stopListening() {
        isListening = false
        speechRecognizer?.stopListening()
        speechRecognizer?.cancel()

        binding.tvStatus.text = "点击按钮开始语音识别"
        binding.ivMic.setColorFilter(getColor(R.color.module_voice))
        binding.btnStartListen.text = "开始识别"
        binding.btnDetect.isEnabled = true
    }

    override fun onReadyForSpeech(params: Bundle?) {
        binding.tvStatus.text = "正在聆听..."
    }

    override fun onBeginningOfSpeech() {
        binding.tvStatus.text = "正在录音..."
        binding.tvResult.text = ""
    }

    override fun onRmsChanged(rmsdB: Float) {
        val volume = (rmsdB / 10).coerceIn(0f, 1f)
        binding.progressVolume.progress = (volume * 100).toInt()
    }

    override fun onBufferReceived(buffer: ByteArray?) {
    }

    override fun onEndOfSpeech() {
        binding.tvStatus.text = "正在识别..."
        binding.progressVolume.progress = 0
    }

    override fun onError(error: Int) {
        isListening = false
        binding.tvStatus.text = "点击按钮开始语音识别"
        binding.ivMic.setColorFilter(getColor(R.color.module_voice))
        binding.btnStartListen.text = "开始识别"
        binding.progressVolume.progress = 0
        binding.btnDetect.isEnabled = true

        val errorMsg = when (error) {
            SpeechRecognizer.ERROR_NETWORK -> "网络错误，请检查网络连接"
            SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "网络超时"
            SpeechRecognizer.ERROR_AUDIO -> "音频错误"
            SpeechRecognizer.ERROR_CLIENT -> "客户端错误"
            SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "缺少麦克风权限"
            SpeechRecognizer.ERROR_SERVER -> "服务端错误"
            SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "识别器正忙"
            SpeechRecognizer.ERROR_NO_MATCH -> "未识别到语音，请重试"
            else -> "识别错误: $error"
        }

        binding.tvResult.text = errorMsg
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }

    override fun onResults(results: Bundle?) {
        isListening = false
        binding.tvStatus.text = "识别完成"
        binding.ivMic.setColorFilter(getColor(R.color.module_voice))
        binding.btnStartListen.text = "开始识别"
        binding.progressVolume.progress = 0
        binding.btnDetect.isEnabled = true

        results?.let {
            val resultList = it.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            if (!resultList.isNullOrEmpty()) {
                val recognizedText = resultList[0]
                binding.tvResult.text = "识别结果：$recognizedText"
                processVoiceCommand(recognizedText)
            } else {
                binding.tvResult.text = "未能识别，请重试"
            }
        } ?: run {
            binding.tvResult.text = "未能识别，请重试"
        }
    }

    override fun onPartialResults(partialResults: Bundle?) {
        partialResults?.let {
            val resultList = it.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
            if (!resultList.isNullOrEmpty()) {
                binding.tvResult.text = "识别中：${resultList[0]}"
            }
        }
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
    }

    private fun processVoiceCommand(text: String) {
        val command = text.lowercase(Locale.CHINESE)

        val (action, target) = when {
            command.contains("二维码") || command.contains("扫描") || command.contains("扫码") -> {
                Pair("打开二维码扫描", QRScanActivity::class.java)
            }
            command.contains("文本检测") || command.contains("诈骗检测") || command.contains("检测诈骗") || command.contains("短信检测") -> {
                Pair("打开文本检测", TextCheckActivity::class.java)
            }
            command.contains("用户") || command.contains("个人") || command.contains("联系人") -> {
                Pair("打开用户界面", UserActivity::class.java)
            }
            command.contains("地图") || command.contains("派出所") || command.contains("附近") || command.contains("导航") -> {
                Pair("打开地图导航", MapActivity::class.java)
            }
            command.contains("安全模式") || command.contains("紧急求助") || command.contains("求助") -> {
                Pair("进入安全模式", SafeModeActivity::class.java)
            }
            command.contains("课程") || command.contains("直播") || command.contains("学习") -> {
                Pair("打开直播课程", LiveActivity::class.java)
            }
            command.contains("历史") || command.contains("记录") -> {
                Pair("打开历史记录", HistoryActivity::class.java)
            }
            command.contains("反诈") || command.contains("游戏") -> {
                Pair("打开反诈游戏", GameActivity::class.java)
            }
            command.contains("检测") || command.contains("识别") || command.contains("分析") -> {
                detectScam(text)
                return
            }
            else -> Pair(null, null)
        }

        if (action != null && target != null) {
            AlertDialog.Builder(this)
                .setTitle("语音指令")
                .setMessage("识别到指令：$action\n\n是否执行？")
                .setPositiveButton("执行") { _, _ ->
                    startActivity(Intent(this, target))
                    finish()
                }
                .setNegativeButton("取消") { _, _ ->
                    binding.tvResult.text = "已取消"
                }
                .setNeutralButton("重试") { _, _ ->
                    startListening()
                }
                .show()
        } else if (action != null) {
            binding.tvResult.text = "已识别：$action，当前页面无需跳转"
            Toast.makeText(this, "已识别指令：$action", Toast.LENGTH_SHORT).show()
        }
    }

    private fun detectScam(text: String) {
        val result = TextCheckUtils.checkText(text)
        DataManager.saveCheckRecord(result)

        val (title, color, icon) = when (result.riskLevel) {
            com.example.safetyassistant.models.RiskLevel.SAFE -> Triple(
                getString(R.string.text_result_safe),
                getColor(R.color.safe_green),
                android.R.drawable.ic_delete
            )
            com.example.safetyassistant.models.RiskLevel.SUSPICIOUS -> Triple(
                getString(R.string.text_result_suspicious),
                getColor(R.color.warning_yellow),
                android.R.drawable.ic_dialog_alert
            )
            com.example.safetyassistant.models.RiskLevel.HIGH_RISK -> Triple(
                getString(R.string.text_result_high_risk),
                getColor(R.color.danger_red),
                android.R.drawable.ic_dialog_alert
            )
        }

        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(result.safetyTips)
            .setIcon(icon)
            .setPositiveButton(R.string.confirm, null)
            .show()
    }

    private fun showWakeWordTip() {
        AlertDialog.Builder(this)
            .setTitle("语音助手使用说明")
            .setMessage("使用方法：\n1. 点击「开始识别」按钮\n2. 对着麦克风说出指令\n3. 系统会实时识别您的语音\n\n支持的语音指令包括：\n• 打开二维码扫描\n• 诈骗短信检测\n• 联系紧急联系人\n• 查找附近派出所\n• 开启安全模式\n• 播放安全课程\n• 查看历史记录\n• 打开反诈游戏\n\n点击「诈骗检测」按钮可以对识别到的语音内容进行诈骗检测。\n\n注意：语音识别需要网络连接才能正常工作。")
            .setPositiveButton(R.string.confirm, null)
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MICROPHONE_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "已获得麦克风权限", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.permission_microphone, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopListening()
        speechRecognizer?.destroy()
    }
}
