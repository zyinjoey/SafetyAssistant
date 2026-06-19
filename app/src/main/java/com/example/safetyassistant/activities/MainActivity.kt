package com.example.safetyassistant.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.databinding.ActivityMainBinding
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.PermissionUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 初始化数据管理器
        DataManager.init(this)

        // 初始化默认用户
        if (DataManager.getUser() == null) {
            DataManager.createDefaultUser()
        }

        // 检查权限
        if (!PermissionUtils.hasAllPermissions(this)) {
            PermissionUtils.requestPermissions(this)
        }

        initView()
        initData()
    }

    private fun initView() {
        // 数字安全直播
        binding.cardLive.setOnClickListener {
            startActivity(Intent(this, LiveActivity::class.java))
        }

        // 反诈文本检测
        binding.cardTextCheck.setOnClickListener {
            startActivity(Intent(this, TextCheckActivity::class.java))
        }

        // 二维码扫描
        binding.cardQrScan.setOnClickListener {
            startActivity(Intent(this, QRScanActivity::class.java))
        }

        // 地图导航
        binding.cardMap.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        // 安全模式
        binding.cardSafeMode.setOnClickListener {
            startActivity(Intent(this, SafeModeActivity::class.java))
        }

        // 语音助手
        binding.cardVoice.setOnClickListener {
            startActivity(Intent(this, VoiceActivity::class.java))
        }

        // 历史记录
        binding.cardHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        // 反诈游戏
        binding.cardGame.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        // 用户中心
        binding.layoutUser.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun initData() {
        // 更新用户信息显示
        updateUserInfo()
    }

    override fun onResume() {
        super.onResume()
        updateUserInfo()
    }

    private fun updateUserInfo() {
        val user = DataManager.getUser()
        user?.let {
            binding.tvUserName.text = it.nickname
            binding.tvSecurityLevel.text = "安全等级: ${it.getSecurityLevelText()}"
        }
    }
}
