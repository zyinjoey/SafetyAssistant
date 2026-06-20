package com.example.safetyassistant.activities

import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.databinding.ActivityLivePlayerBinding

class LivePlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLivePlayerBinding
    private var timer: CountDownTimer? = null

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
        val courseDesc = intent.getStringExtra("course_desc") ?: ""
        val courseType = intent.getStringExtra("course_type") ?: "VIDEO"
        val lecturer = intent.getStringExtra("lecturer") ?: ""
        val duration = intent.getLongExtra("duration", 15)
        val courseId = intent.getStringExtra("course_id") ?: "1"

        binding.tvCourseTitle.text = courseTitle

        // 根据课程ID决定是否播放真实视频
        if (courseId == "1") {
            // 第一个课程：播放真实视频
            playRealVideo(courseTitle, courseDesc, lecturer)
        } else if (courseId == "2") {
            // 第二个课程：模拟视频播放
            startVideoSimulation(courseTitle, courseDesc, lecturer, duration)
        } else {
            // 其他课程：显示课程信息
            startLiveSimulation(courseTitle, courseDesc, lecturer)
        }
    }

    private fun playRealVideo(title: String, desc: String, lecturer: String) {
        binding.progressBar.visibility = View.GONE
        
        // 设置视频播放器
        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController)
        
        // 从raw资源播放视频
        val videoUri = Uri.parse("android.resource://com.example.safetyassistant/raw/video_fraud_prevention")
        binding.videoView.setVideoURI(videoUri)
        
        binding.videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = false
            binding.tvCourseDesc.text = """
                ▶️ $title (视频课程)
                
                讲师：$lecturer
                
                $desc
                
                ────────────────────
                🎬 正在播放视频...
            """.trimIndent()
            binding.videoView.start()
        }
        
        binding.videoView.setOnCompletionListener {
            binding.tvCourseDesc.text = """
                ✅ $title (播放完成)
                
                讲师：$lecturer
                
                $desc
                
                ────────────────────
                🎉 恭喜你完成学习！
                
                学习要点：
                • 识别诈骗特征
                • 保护个人信息
                • 遇到可疑情况及时报警
            """.trimIndent()
        }
        
        binding.videoView.setOnErrorListener { _, _, _ ->
            binding.videoView.visibility = View.GONE
            binding.tvCourseDesc.text = """
                ⚠️ 视频加载失败
                
                课程：$title
                讲师：$lecturer
                
                $desc
            """.trimIndent()
            true
        }
    }

    private fun startLiveSimulation(title: String, desc: String, lecturer: String) {
        binding.videoView.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
        
        binding.tvCourseDesc.text = """
            📺 $title (直播课程)
            
            讲师：$lecturer
            
            $desc
            
            ────────────────────
            课程内容预告：
            • 常见诈骗手法解析
            • 防范技巧分享
            • 真实案例分析
            
            💡 提示：完整课程内容请观看视频版课程
        """.trimIndent()
    }

    private fun startVideoSimulation(title: String, desc: String, lecturer: String, duration: Long) {
        binding.videoView.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
        binding.progressBar.isIndeterminate = false
        binding.progressBar.max = duration.toInt()
        binding.progressBar.progress = 0

        binding.tvCourseDesc.text = """
            ▶️ $title (视频课程)
            
            讲师：$lecturer
            时长：${duration}秒
            
            $desc
            
            ────────────────────
            00:00 / ${String.format("%02d:%02d", duration / 60, duration % 60)}
        """.trimIndent()

        var currentTime = 0L

        timer = object : CountDownTimer(duration * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                currentTime = duration - (millisUntilFinished / 1000)
                binding.progressBar.progress = currentTime.toInt()

                val currentMin = currentTime / 60
                val currentSec = currentTime % 60
                val totalMin = duration / 60
                val totalSec = duration % 60

                binding.tvCourseDesc.text = """
                    ▶️ $title (视频课程)
                    
                    讲师：$lecturer
                    时长：${duration}秒
                    
                    $desc
                    
                    ────────────────────
                    ${String.format("%02d:%02d", currentMin, currentSec)} / ${String.format("%02d:%02d", totalMin, totalSec)}
                    
                    📊 学习进度：${(currentTime * 100 / duration)}%
                """.trimIndent()
            }

            override fun onFinish() {
                binding.progressBar.progress = duration.toInt()
                binding.progressBar.visibility = View.GONE
                binding.tvCourseDesc.text = """
                    ✅ $title (播放完成)
                    
                    讲师：$lecturer
                    时长：${duration}秒
                    
                    $desc
                    
                    ────────────────────
                    🎉 恭喜你完成学习！
                    
                    学习要点：
                    • 识别诈骗特征
                    • 保护个人信息
                    • 遇到可疑情况及时报警
                """.trimIndent()
            }
        }.start()
    }

    override fun onPause() {
        super.onPause()
        binding.videoView.pause()
    }

    override fun onResume() {
        super.onResume()
        binding.videoView.resume()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
        binding.videoView.stopPlayback()
    }
}