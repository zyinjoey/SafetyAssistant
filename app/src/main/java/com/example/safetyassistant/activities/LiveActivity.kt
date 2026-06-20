package com.example.safetyassistant.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.safetyassistant.databinding.ActivityLiveBinding
import com.example.safetyassistant.databinding.ItemCourseBinding
import com.example.safetyassistant.models.Course
import com.example.safetyassistant.models.CourseType
import com.example.safetyassistant.models.StudyRecord
import com.example.safetyassistant.models.StudyType
import com.example.safetyassistant.utils.DataManager

class LiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveBinding
    private lateinit var courseAdapter: CourseAdapter

    private val courses = mutableListOf<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        loadData()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        courseAdapter = CourseAdapter { course ->
            val record = StudyRecord(
                id = java.util.UUID.randomUUID().toString(),
                courseId = course.id,
                courseName = course.title,
                type = if (course.type == CourseType.LIVE) StudyType.LIVE else StudyType.VIDEO
            )
            DataManager.saveStudyRecord(record)

            startActivity(Intent(this, LivePlayerActivity::class.java).apply {
                putExtra("course_id", course.id)
                putExtra("course_title", course.title)
                putExtra("course_desc", course.description)
                putExtra("course_type", course.type.name)
                putExtra("lecturer", course.lecturer)
                putExtra("duration", course.duration)
            })
        }

        binding.rvCourses.layoutManager = LinearLayoutManager(this)
        binding.rvCourses.adapter = courseAdapter
    }

    private fun loadData() {
        courses.addAll(
            listOf(
                Course(
                    id = "1",
                    title = "防范电信诈骗",
                    description = "学习如何识别和防范电信诈骗，包括常见的诈骗手段和防范方法",
                    type = CourseType.LIVE,
                    lecturer = "王警官",
                    viewerCount = 1256
                ),
                Course(
                    id = "2",
                    title = "识别钓鱼链接",
                    description = "教你识别各种钓鱼网站和恶意链接，保护个人信息安全",
                    type = CourseType.VIDEO,
                    lecturer = "李老师",
                    duration = 15
                ),
                Course(
                    id = "3",
                    title = "二维码安全知识",
                    description = "了解二维码的潜在风险和安全使用方法",
                    type = CourseType.LIVE,
                    lecturer = "张专家",
                    viewerCount = 890
                ),
                Course(
                    id = "4",
                    title = "个人隐私保护",
                    description = "保护个人信息和隐私安全的基本方法",
                    type = CourseType.LIVE,
                    lecturer = "刘教授",
                    viewerCount = 756
                ),
                Course(
                    id = "5",
                    title = "银行卡安全",
                    description = "如何保护银行卡和个人账户信息安全",
                    type = CourseType.LIVE,
                    lecturer = "陈老师",
                    viewerCount = 623
                ),
                Course(
                    id = "6",
                    title = "网络购物防骗",
                    description = "网购时如何识别和防范各类诈骗陷阱",
                    type = CourseType.LIVE,
                    lecturer = "赵警官",
                    viewerCount = 542
                )
            )
        )

        courseAdapter.setCourses(courses)
        binding.tvLiveCount.text = courses.count { it.type == CourseType.LIVE }.toString()
        binding.tvVideoCount.text = courses.count { it.type == CourseType.VIDEO }.toString()
    }

    inner class CourseAdapter(
        private val onItemClick: (Course) -> Unit
    ) : androidx.recyclerview.widget.RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

        private var list: List<Course> = emptyList()

        fun setCourses(newList: List<Course>) {
            list = newList
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size

        inner class ViewHolder(
            private val binding: ItemCourseBinding
        ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

            fun bind(course: Course) {
                binding.tvTitle.text = course.title
                binding.tvDescription.text = course.description
                binding.tvLecturer.text = course.lecturer

                if (course.type == CourseType.LIVE) {
                    binding.tvViewerCount.text = "${course.viewerCount}人在看"
                    binding.chipType.text = "直播"
                    binding.chipType.setBackgroundColor(getColor(com.example.safetyassistant.R.color.danger_red))
                } else {
                    binding.tvViewerCount.text = "${course.duration}秒"
                    binding.chipType.text = "视频"
                    binding.chipType.setBackgroundColor(getColor(com.example.safetyassistant.R.color.primary))
                }

                binding.btnWatch.setOnClickListener {
                    onItemClick(course)
                }
            }
        }
    }
}