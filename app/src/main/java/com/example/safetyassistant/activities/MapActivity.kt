package com.example.safetyassistant.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityMapBinding
import com.example.safetyassistant.utils.LocationService

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding
    private var locationService: LocationService? = null
    private var currentLatitude = 39.9042
    private var currentLongitude = 116.4074
    private var currentAddress = "北京市"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        setupLocation()
        setupSearch()
    }

    private fun setupLocation() {
        locationService = LocationService(this)

        binding.btnLocate.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
                return@setOnClickListener
            }

            Toast.makeText(this, "正在定位...", Toast.LENGTH_SHORT).show()
            locationService?.startLocation { locationData ->
                if (locationData != null) {
                    currentLatitude = locationData.latitude
                    currentLongitude = locationData.longitude
                    currentAddress = locationData.address ?: ""
                    Toast.makeText(this, "已定位: $currentAddress", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "定位失败，请检查权限", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupSearch() {
        binding.chipPolice.setOnClickListener {
            openMapSearch("派出所")
        }

        binding.chipBank.setOnClickListener {
            openMapSearch("银行")
        }

        binding.chipOperator.setOnClickListener {
            openMapSearch("营业厅")
        }

        binding.btnSearch.setOnClickListener {
            val keyword = binding.etSearch.text.toString().trim()
            if (keyword.isNotEmpty()) {
                openMapSearch(keyword)
            } else {
                Toast.makeText(this, "请输入搜索关键词", Toast.LENGTH_SHORT).show()
            }
        }

        binding.etSearch.setOnEditorActionListener { _, _, _ ->
            val keyword = binding.etSearch.text.toString().trim()
            if (keyword.isNotEmpty()) {
                openMapSearch(keyword)
            }
            true
        }
    }

    private fun openMapSearch(keyword: String) {
        val uri = Uri.parse("geo:$currentLatitude,$currentLongitude?q=${Uri.encode(keyword)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "未安装地图应用", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openCurrentLocation() {
        val uri = Uri.parse("geo:$currentLatitude,$currentLongitude?q=${Uri.encode(currentAddress)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "未安装地图应用", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            binding.btnLocate.performClick()
        } else {
            Toast.makeText(this, "需要定位权限才能获取当前位置", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        locationService?.destroy()
        super.onDestroy()
    }
}
