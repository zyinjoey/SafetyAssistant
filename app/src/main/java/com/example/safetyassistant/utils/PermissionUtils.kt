package com.example.safetyassistant.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionUtils {

    const val REQUEST_CODE_PERMISSIONS = 1001

    // 需要申请的权限列表
    val REQUIRED_PERMISSIONS = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.CALL_PHONE,
        Manifest.permission.SEND_SMS,
        Manifest.permission.READ_SMS
    )

    /**
     * 检查权限是否已授权
     */
    fun hasPermission(context: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * 检查所有权限是否已授权
     */
    fun hasAllPermissions(context: Context): Boolean {
        return REQUIRED_PERMISSIONS.all {
            hasPermission(context, it)
        }
    }

    /**
     * 请求权限
     */
    fun requestPermissions(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            REQUIRED_PERMISSIONS,
            REQUEST_CODE_PERMISSIONS
        )
    }

    /**
     * 请求单个权限
     */
    fun requestPermission(activity: Activity, permission: String, requestCode: Int) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(permission),
            requestCode
        )
    }

    /**
     * 检查权限是否被永久拒绝
     */
    fun isPermissionDeniedForever(activity: Activity, permission: String): Boolean {
        return !hasPermission(activity, permission) &&
                !ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    }
}
