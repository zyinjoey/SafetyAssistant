package com.example.safetyassistant.activities

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivitySafeModeBinding
import com.example.safetyassistant.models.EmergencyContact
import com.example.safetyassistant.models.SOSRecord
import com.example.safetyassistant.models.SOSType
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.LocationService
import com.example.safetyassistant.utils.PermissionUtils
import com.example.safetyassistant.utils.TextCheckUtils

class SafeModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySafeModeBinding
    private lateinit var locationService: LocationService
    private var currentLatitude: Double = 0.0
    private var currentLongitude: Double = 0.0
    private var currentAddress: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySafeModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        enterSafeMode()
        initLocation()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            exitSafeMode()
        }

        // 一键呼叫紧急联系人
        binding.btnCall.setOnClickListener {
            callEmergencyContact()
        }

        // 发送求助短信
        binding.btnSms.setOnClickListener {
            sendSOSMessage()
        }

        // 位置共享
        binding.btnLocation.setOnClickListener {
            shareLocation()
        }

        // 查找附近派出所
        binding.btnPolice.setOnClickListener {
            findNearbyPolice()
        }

        // 退出安全模式
        binding.btnExit.setOnClickListener {
            exitSafeMode()
        }
    }

    private fun enterSafeMode() {
        // 震动提示
        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE))

        Toast.makeText(this, R.string.safe_mode_active, Toast.LENGTH_LONG).show()

        // 如果是从高风险检测进入的，执行文本检测
        val textToCheck = intent.getStringExtra("text_to_check")
        textToCheck?.let {
            val result = TextCheckUtils.checkText(it)
            if (result.riskLevel == com.example.safetyassistant.models.RiskLevel.HIGH_RISK) {
                AlertDialog.Builder(this)
                    .setTitle("风险提示")
                    .setMessage("检测到高风险内容：${result.riskKeywords.joinToString("、")}\n\n${result.safetyTips}")
                    .setPositiveButton(R.string.confirm, null)
                    .show()
            }
        }
    }

    private fun initLocation() {
        if (!PermissionUtils.hasPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            PermissionUtils.requestPermission(this, Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_PERMISSION_REQUEST)
            return
        }

        locationService = LocationService(this)
        locationService.init()
        locationService.startLocation { location ->
            location?.let {
                currentLatitude = it.latitude
                currentLongitude = it.longitude
                currentAddress = it.address ?: ""
            }
        }
    }

    private fun callEmergencyContact() {
        val user = DataManager.getUser()
        val contacts = user?.emergencyContacts ?: emptyList()

        if (contacts.isEmpty()) {
            Toast.makeText(this, "请先添加紧急联系人", Toast.LENGTH_SHORT).show()
            return
        }

        // 选择联系人
        val contactNames = contacts.map { "${it.name} (${it.phoneNumber})" }.toTypedArray()
        AlertDialog.Builder(this)
            .setTitle("选择紧急联系人")
            .setItems(contactNames) { _, which ->
                val contact = contacts[which]
                makeCall(contact)

                // 保存记录
                saveSOSRecord(SOSType.CALL, contact)
            }
            .show()
    }

    private fun makeCall(contact: EmergencyContact) {
        if (!PermissionUtils.hasPermission(this, Manifest.permission.CALL_PHONE)) {
            // 使用 ACTION_DIAL 不需要权限
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${contact.phoneNumber}")
            }
            startActivity(intent)
        } else {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:${contact.phoneNumber}")
            }
            startActivity(intent)
        }
    }

    private fun sendSOSMessage() {
        val user = DataManager.getUser()
        val contacts = user?.emergencyContacts ?: emptyList()

        if (contacts.isEmpty()) {
            Toast.makeText(this, "请先添加紧急联系人", Toast.LENGTH_SHORT).show()
            return
        }

        // 选择联系人
        val contactNames = contacts.map { "${it.name} (${it.phoneNumber})" }.toTypedArray()
        AlertDialog.Builder(this)
            .setTitle("选择接收人")
            .setItems(contactNames) { _, which ->
                val contact = contacts[which]
                sendSMS(contact)
            }
            .show()
    }

    private fun sendSMS(contact: EmergencyContact) {
        if (!PermissionUtils.hasPermission(this, Manifest.permission.SEND_SMS)) {
            PermissionUtils.requestPermission(this, Manifest.permission.SEND_SMS, SMS_PERMISSION_REQUEST)
            return
        }

        val message = "【安全助手紧急求助】\n我遇到了紧急情况，需要帮助！\n当前位置：$currentAddress\n经纬度：$currentLatitude, $currentLongitude"

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:${contact.phoneNumber}")
            putExtra("sms_body", message)
        }
        startActivity(intent)

        // 保存记录
        saveSOSRecord(SOSType.SMS, contact)
    }

    private fun shareLocation() {
        if (currentLatitude == 0.0 && currentLongitude == 0.0) {
            Toast.makeText(this, "正在获取位置...", Toast.LENGTH_SHORT).show()
            return
        }

        val locationUrl = "https://maps.google.com/?q=$currentLatitude,$currentLongitude"
        val shareText = "【安全助手位置共享】\n我现在的位置：$currentAddress\n点击查看：$locationUrl"

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        startActivity(Intent.createChooser(intent, "分享位置"))

        // 保存记录
        val user = DataManager.getUser()
        user?.emergencyContacts?.firstOrNull()?.let {
            saveSOSRecord(SOSType.LOCATION_SHARE, it)
        }
    }

    private fun findNearbyPolice() {
        // 简化版本：直接拨打110或打开地图应用
        AlertDialog.Builder(this)
            .setTitle("紧急求助")
            .setMessage("您可以选择：\n1. 直接拨打110报警电话\n2. 打开地图应用查找附近派出所")
            .setPositiveButton("拨打110") { _, _ ->
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:110")
                }
                startActivity(intent)
            }
            .setNegativeButton("打开地图") { _, _ ->
                // 打开地图应用
                val gmmIntentUri = Uri.parse("geo:0,0?q=派出所")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                
                if (mapIntent.resolveActivity(packageManager) != null) {
                    startActivity(mapIntent)
                } else {
                    // 如果没有Google Maps，尝试其他地图应用
                    val genericIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    startActivity(genericIntent)
                }
            }
            .setNeutralButton("取消", null)
            .show()
    }

    private fun saveSOSRecord(type: SOSType, contact: EmergencyContact) {
        val record = SOSRecord(
            id = java.util.UUID.randomUUID().toString(),
            type = type,
            contactName = contact.name,
            contactPhone = contact.phoneNumber,
            latitude = currentLatitude,
            longitude = currentLongitude,
            message = "紧急求助"
        )
        DataManager.saveSOSRecord(record)
        Toast.makeText(this, "已记录求助信息", Toast.LENGTH_SHORT).show()
    }

    private fun exitSafeMode() {
        AlertDialog.Builder(this)
            .setTitle("退出安全模式")
            .setMessage("确定要退出安全模式吗？")
            .setPositiveButton(R.string.confirm) { _, _ ->
                finish()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    initLocation()
                } else {
                    Toast.makeText(this, R.string.permission_location, Toast.LENGTH_SHORT).show()
                }
            }
            SMS_PERMISSION_REQUEST -> {
                if (grantResults.isNotEmpty() && grantResults[0] == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    sendSOSMessage()
                } else {
                    Toast.makeText(this, R.string.permission_sms, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::locationService.isInitialized) {
            locationService.destroy()
        }
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST = 2001
        private const val SMS_PERMISSION_REQUEST = 2002
    }
}