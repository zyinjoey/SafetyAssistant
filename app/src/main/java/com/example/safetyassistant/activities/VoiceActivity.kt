package com.example.safetyassistant.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityVoiceBinding
import com.example.safetyassistant.utils.BaiduSpeechManager
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.PermissionUtils
import com.example.safetyassistant.utils.TextCheckUtils

class VoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVoiceBinding
    private var isListening = false
    private lateinit var speechManager: BaiduSpeechManager

    companion object {
        private const val TAG = "VoiceActivity"
        private const val MICROPHONE_PERMISSION_REQUEST = 3001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initSpeechManager()
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
            if (text.isEmpty() || text == "正在聆听，请说话..." || text == "未能识别，请重试" || text == "尚未识别") {
                Toast.makeText(this, "请先进行语音识别", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            detectScam(text)
        }

        binding.tvStatus.text = "点击按钮开始语音识别"
    }

    private fun initSpeechManager() {
        speechManager = BaiduSpeechManager(this)
        speechManager.setListener(object : BaiduSpeechManager.SpeechResultListener {
            override fun onRecognizing(text: String) {
                runOnUiThread {
                    binding.tvResult.text = "识别中：$text"
                }
                Log.d(TAG, "正在识别: $text")
            }

            override fun onResult(text: String) {
                runOnUiThread {
                    binding.tvResult.text = "识别结果：$text"
                }
                Log.d(TAG, "识别成功: $text")
                processVoiceCommand(text)
            }

            override fun onError(error: String) {
                runOnUiThread {
                    binding.tvResult.text = error
                    isListening = false
                    binding.tvStatus.text = "点击按钮开始语音识别"
                    binding.ivMic.setColorFilter(getColor(R.color.module_voice))
                    binding.btnStartListen.text = "开始识别"
                    binding.btnDetect.isEnabled = true
                    binding.progressVolume.progress = 0
                }
                Log.e(TAG, "识别错误: $error")
                Toast.makeText(this@VoiceActivity, error, Toast.LENGTH_SHORT).show()
            }

            override fun onStarted() {
                runOnUiThread {
                    binding.tvStatus.text = "正在聆听..."
                }
                Log.d(TAG, "语音识别已启动")
            }

            override fun onFinished() {
                runOnUiThread {
                    isListening = false
                    binding.tvStatus.text = "点击按钮开始语音识别"
                    binding.ivMic.setColorFilter(getColor(R.color.module_voice))
                    binding.btnStartListen.text = "开始识别"
                    binding.btnDetect.isEnabled = true
                    binding.progressVolume.progress = 0
                }
                Log.d(TAG, "语音识别已结束")
            }
        })
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

        isListening = true
        binding.tvStatus.text = "正在启动语音识别..."
        binding.tvResult.text = "正在聆听，请说话..."
        binding.ivMic.setColorFilter(getColor(R.color.danger_red))
        binding.btnStartListen.text = "停止"
        binding.btnDetect.isEnabled = false

        Log.d(TAG, "启动百度语音识别")
        speechManager.startListening()
    }

    private fun stopListening() {
        isListening = false
        speechManager.stopListening()
    }

    private fun processVoiceCommand(text: String) {
        val command = text.lowercase(java.util.Locale.CHINA)

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
                    try {
                        val intent = Intent(this, target)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    } catch (e: Exception) {
                        Log.e(TAG, "启动Activity失败: ${e.message}")
                        Toast.makeText(this, "启动失败: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
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

        val (title, _, icon) = when (result.riskLevel) {
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
            .setMessage("使用方法：\n1. 点击「开始识别」按钮\n2. 对着麦克风说出指令\n3. 系统会自动识别您的语音\n\n支持的语音指令包括：\n• 打开二维码扫描\n• 诈骗短信检测\n• 联系紧急联系人\n• 查找附近派出所\n• 开启安全模式\n• 播放安全课程\n• 查看历史记录\n• 打开反诈游戏\n\n点击「诈骗检测」按钮可以对识别到的语音内容进行诈骗检测。\n\n注意：\n• 语音识别需要网络连接\n• 建议在安静环境下使用")
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
        speechManager.release()
        Log.d(TAG, "VoiceActivity销毁")
    }
}