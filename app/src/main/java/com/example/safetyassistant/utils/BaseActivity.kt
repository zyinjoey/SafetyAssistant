package com.example.safetyassistant.utils

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Activity 基类
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = createBinding()
        setContentView(binding.root)
        initView()
        initData()
    }

    /**
     * 创建 ViewBinding
     */
    abstract fun createBinding(): VB

    /**
     * 初始化视图
     */
    abstract fun initView()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 显示 Toast
     */
    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * 显示长 Toast
     */
    protected fun showLongToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
