package com.example.safetyassistant.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityTextCheckBinding
import com.example.safetyassistant.models.CheckResult
import com.example.safetyassistant.models.RiskLevel
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.TextCheckUtils

class TextCheckActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnCheck.setOnClickListener {
            val text = binding.etInput.text.toString().trim()
            if (text.isEmpty()) {
                binding.tilInput.error = "请输入要检测的文本"
                return@setOnClickListener
            }

            binding.tilInput.error = null
            performCheck(text)
        }

        binding.btnClear.setOnClickListener {
            binding.etInput.text?.clear()
            binding.layoutResult.visibility = android.view.View.GONE
        }

        binding.btnSafeMode.setOnClickListener {
            // 进入安全模式
            startActivity(Intent(this, SafeModeActivity::class.java))
        }
    }

    private fun performCheck(text: String) {
        val result = TextCheckUtils.checkText(text)

        // 保存记录
        DataManager.saveCheckRecord(result)

        // 显示结果
        showResultDialog(result)
    }

    private fun showResultDialog(result: CheckResult) {
        val (title, color, icon) = when (result.riskLevel) {
            RiskLevel.SAFE -> Triple(
                getString(R.string.text_result_safe),
                getColor(R.color.safe_green),
                android.R.drawable.ic_delete
            )
            RiskLevel.SUSPICIOUS -> Triple(
                getString(R.string.text_result_suspicious),
                getColor(R.color.warning_yellow),
                android.R.drawable.ic_dialog_alert
            )
            RiskLevel.HIGH_RISK -> Triple(
                getString(R.string.text_result_high_risk),
                getColor(R.color.danger_red),
                android.R.drawable.ic_dialog_alert
            )
        }

        val keywords = if (result.riskKeywords.isNotEmpty()) {
            "\n\n检测到关键词：${result.riskKeywords.joinToString("、")}"
        } else ""

        val message = "${result.safetyTips}$keywords"

        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.confirm) { _, _ ->
                if (result.riskLevel == RiskLevel.HIGH_RISK) {
                    showSafeModeOption()
                }
            }
            .setNeutralButton("复制结果") { _, _ ->
                val clipboard = getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
                val clip = android.content.ClipData.newPlainText("检测结果", message)
                clipboard.setPrimaryClip(clip)
            }
            .show()
    }

    private fun showSafeModeOption() {
        AlertDialog.Builder(this)
            .setTitle("是否进入安全模式？")
            .setMessage("检测到高风险内容，建议进入安全模式获取帮助")
            .setPositiveButton("进入安全模式") { _, _ ->
                startActivity(Intent(this, SafeModeActivity::class.java))
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }
}
