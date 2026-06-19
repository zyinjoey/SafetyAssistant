package com.example.safetyassistant

import android.app.Application

class SafetyAssistantApp : Application() {

    companion object {
        lateinit var instance: SafetyAssistantApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
        // 清理资源
    }
}
