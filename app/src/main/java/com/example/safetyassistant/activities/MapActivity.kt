package com.example.safetyassistant.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.safetyassistant.databinding.ActivityMapBinding
import com.example.safetyassistant.utils.LocationService

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding
    private var locationService: LocationService? = null
    private var currentLatitude = 39.9042
    private var currentLongitude = 116.4074
    private var currentAddress = "北京市"

    // Web端(JS API) Key和安全密钥
    private val amapKey = "544ad7b04d55963d4410afe163fe3526"
    private val amapSecurityCode = "8306a5457d2150ed52fcd99c21991d4e"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        setupWebView()

        binding.btnLocate.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
                return@setOnClickListener
            }

            Toast.makeText(this, "正在定位...", Toast.LENGTH_SHORT).show()
            binding.layoutLoading.visibility = android.view.View.VISIBLE
            binding.layoutInfo.visibility = android.view.View.GONE

            locationService = LocationService(this)
            locationService?.startLocation { locationData ->
                if (locationData != null) {
                    currentLatitude = locationData.latitude
                    currentLongitude = locationData.longitude
                    currentAddress = locationData.address ?: "未知位置"
                    Toast.makeText(this, "定位成功", Toast.LENGTH_SHORT).show()
                    showMap()
                } else {
                    Toast.makeText(this, "定位失败，请检查权限", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnOpenAmap.setOnClickListener {
            val uri = Uri.parse("androidamap://viewMap?sourceApplication=safetyassistant&lat=$currentLatitude&lon=$currentLongitude&zoom=15&dev=0")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.autonavi.minimap")
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "请先安装高德地图APP", Toast.LENGTH_SHORT).show()
                val storeUri = Uri.parse("market://details?id=com.autonavi.minimap")
                val storeIntent = Intent(Intent.ACTION_VIEW, storeUri)
                startActivity(storeIntent)
            }
        }
    }

    private fun setupWebView() {
        val webSettings: WebSettings = binding.webviewMap.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false
        
        binding.webviewMap.webViewClient = WebViewClient()
        binding.webviewMap.webChromeClient = WebChromeClient()
    }

    private fun showMap() {
        binding.layoutLoading.visibility = android.view.View.GONE
        binding.layoutInfo.visibility = android.view.View.VISIBLE

        binding.tvCoordinate.text = "坐标：$currentLatitude, $currentLongitude"
        binding.tvAddress.text = "地址：$currentAddress"

        // 使用高德地图JS API加载地图
        val htmlContent = """
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <style>
        * { margin: 0; padding: 0; }
        html, body, #container { width: 100%; height: 100%; }
    </style>
</head>
<body>
    <div id="container"></div>
    <script>
        window._AMapSecurityConfig = {
            securityJsCode: '$amapSecurityCode'
        }
    </script>
    <script src="https://webapi.amap.com/maps?v=2.0&key=$amapKey"></script>
    <script>
        var map = new AMap.Map('container', {
            zoom: 16,
            center: [$currentLongitude, $currentLatitude]
        });
        
        var marker = new AMap.Marker({
            position: [$currentLongitude, $currentLatitude],
            title: '$currentAddress'
        });
        
        marker.setMap(map);
        
        var infoWindow = new AMap.InfoWindow({
            content: '<div style="padding:10px;">$currentAddress</div>',
            offset: new AMap.Pixel(0, -30)
        });
        
        infoWindow.open(map, marker.getPosition());
    </script>
</body>
</html>
        """.trimIndent()

        binding.webviewMap.loadDataWithBaseURL("https://webapi.amap.com", htmlContent, "text/html", "UTF-8", null)
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