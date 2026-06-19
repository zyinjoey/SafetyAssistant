package com.example.safetyassistant.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.databinding.ActivityLivePlayerBinding

class LivePlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLivePlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLivePlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val courseTitle = intent.getStringExtra("course_title") ?: "课程播放"
        binding.tvCourseTitle.text = courseTitle
        binding.tvCourseDesc.text = "正在播放：$courseTitle\n\n这是一个模拟的课程播放界面。"
    }
}