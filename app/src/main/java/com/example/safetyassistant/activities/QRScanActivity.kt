package com.example.safetyassistant.activities

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityQrScanBinding
import com.example.safetyassistant.models.ScanRecord
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.PermissionUtils
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions

class QRScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQrScanBinding
    private var currentCameraId = 0  // 0=后置, 1=前置

    private val scanLauncher = registerForActivityResult(ScanContract()) { result: ScanIntentResult ->
        if (result.contents != null) {
            handleScanResult(result.contents)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnScan.setOnClickListener {
            checkCameraPermissionAndScan()
        }

        binding.btnSwitchCamera.setOnClickListener {
            currentCameraId = if (currentCameraId == 0) 1 else 0
            Toast.makeText(this, if (currentCameraId == 0) "已切换到后置摄像头" else "已切换到前置摄像头", Toast.LENGTH_SHORT).show()
        }

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java).apply {
                putExtra("tab", "scan")
            })
        }

        binding.btnScan.setOnLongClickListener {
            showTestModeDialog()
            true
        }
    }

    private fun checkCameraPermissionAndScan() {
        if (PermissionUtils.hasPermission(this, Manifest.permission.CAMERA)) {
            startScan()
        } else {
            PermissionUtils.requestPermission(this, Manifest.permission.CAMERA, CAMERA_PERMISSION_REQUEST)
        }
    }

    private fun showTestModeDialog() {
        AlertDialog.Builder(this)
            .setTitle("测试模式")
            .setMessage("选择测试内容：")
            .setItems(arrayOf(
                "✅ 安全链接 (https://www.baidu.com)",
                "⚠️ 风险内容 (中奖信息)",
                "⚠️ 风险链接 (短链接)",
                "⚠️ 风险关键词 (钓鱼网站)",
                "✅ 普通文本"
            )) { _, which ->
                val testContent = when (which) {
                    0 -> "https://www.baidu.com"
                    1 -> "恭喜您中奖了！请点击领取红包，需要输入您的银行账号和密码"
                    2 -> "https://t.cn/xxxxxx"
                    3 -> "http://phishing-scam.com/login?user=test&password=123456"
                    else -> "这是普通的文本内容"
                }
                handleScanResult(testContent)
            }
            .show()
    }

    private fun startScan() {
        val options = ScanOptions().apply {
            setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES)
            setPrompt("将二维码放入扫描框内")
            setCameraId(currentCameraId)  // 使用当前选择的摄像头
            setBeepEnabled(true)
            setBarcodeImageEnabled(false)
            setOrientationLocked(false)
        }
        scanLauncher.launch(options)
    }

    private fun handleScanResult(content: String) {
        // 保存扫描记录
        val record = ScanRecord(
            id = java.util.UUID.randomUUID().toString(),
            content = content,
            result = "二维码内容",
            isSafe = analyzeContent(content)
        )
        DataManager.saveScanRecord(record)

        // 显示结果
        showResultDialog(content)
    }

    private fun analyzeContent(content: String): Boolean {
        val lowerContent = content.lowercase()

        val suspiciousKeywords = listOf(
            "钓鱼", "诈骗", "转账", "银行", "密码", "验证码",
            "中奖", "领奖", "免费", "红包", "返利", "投资",
            "理财", "股票", "基金", "刷单", "赌博", "色情",
            "毒品", "枪支", "违法", "黑客", "木马", "病毒",
            "盗号", "窃取", "泄露", "隐私", "身份", "身份证",
            "银行卡", "支付", "收款", "退款", "理赔", "保险",
            "中奖号码", "验证码请回复", "点击领取", "立即注册",
            "内部通道", "独家优惠", "限时特惠", "紧急通知",
            "系统升级", "账户异常", "安全警告", "验证身份"
        )

        val suspiciousDomains = listOf(
            "phishing", "fish", "scam", "fraud", "hack", "malware",
            "virus", "trojan", "spyware", "ransomware", "adware",
            "win32", "exe", "dll", "apk", "zip", "rar"
        )

        val isShortUrl = content.startsWith("http://t.cn") || 
                         content.startsWith("https://t.cn") ||
                         content.startsWith("http://bit.ly") ||
                         content.startsWith("https://bit.ly") ||
                         content.startsWith("http://tinyurl.com") ||
                         content.startsWith("https://tinyurl.com")

        val hasSuspiciousKeyword = suspiciousKeywords.any { lowerContent.contains(it) }
        val hasSuspiciousDomain = suspiciousDomains.any { lowerContent.contains(it) }

        return !(hasSuspiciousKeyword || hasSuspiciousDomain || isShortUrl)
    }

    private fun showResultDialog(content: String) {
        val isSafe = analyzeContent(content)

        val (title, message) = if (isSafe) {
            Pair("✅ 扫描成功", "该二维码内容暂无明显风险。\n\n内容：$content")
        } else {
            Pair("⚠️ 风险警告", "该二维码可能存在安全风险，请谨慎处理！\n\n内容：$content")
        }

        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("复制内容") { _, _ ->
                val clipboard = getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
                val clip = android.content.ClipData.newPlainText("二维码内容", content)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(this, "已复制", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("关闭", null)
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST) {
            if (grantResults.isNotEmpty() && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                startScan()
            } else {
                Toast.makeText(this, R.string.permission_camera, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val CAMERA_PERMISSION_REQUEST = 1001
    }
}
