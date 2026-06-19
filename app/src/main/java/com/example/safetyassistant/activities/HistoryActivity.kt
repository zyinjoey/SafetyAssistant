package com.example.safetyassistant.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityHistoryBinding
import com.example.safetyassistant.databinding.ItemCheckRecordBinding
import com.example.safetyassistant.databinding.ItemScanRecordBinding
import com.example.safetyassistant.databinding.ItemSosRecordBinding
import com.example.safetyassistant.databinding.ItemStudyRecordBinding
import com.example.safetyassistant.models.CheckResult
import com.example.safetyassistant.models.RiskLevel
import com.example.safetyassistant.models.SOSRecord
import com.example.safetyassistant.models.ScanRecord
import com.example.safetyassistant.models.StudyRecord
import com.example.safetyassistant.utils.DataManager
import com.example.safetyassistant.utils.DateUtils

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    private var currentTab = "check"

    private val tabViews by lazy {
        listOf(binding.tabCheck, binding.tabScan, binding.tabSos, binding.tabStudy)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentTab = intent.getStringExtra("tab") ?: "check"

        initView()
        loadData()
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Tab 切换
        binding.tabCheck.setOnClickListener { switchTab("check") }
        binding.tabScan.setOnClickListener { switchTab("scan") }
        binding.tabSos.setOnClickListener { switchTab("sos") }
        binding.tabStudy.setOnClickListener { switchTab("study") }

        // 默认选中
        updateTabSelection(currentTab)
    }

    private fun switchTab(tab: String) {
        currentTab = tab
        updateTabSelection(tab)
        loadData()
    }

    private fun updateTabSelection(selectedTab: String) {
        val selectedColor = getColor(R.color.module_history)
        val unselectedColor = getColor(R.color.card_background)

        binding.tabCheck.setBackgroundColor(if (selectedTab == "check") selectedColor else unselectedColor)
        binding.tabScan.setBackgroundColor(if (selectedTab == "scan") selectedColor else unselectedColor)
        binding.tabSos.setBackgroundColor(if (selectedTab == "sos") selectedColor else unselectedColor)
        binding.tabStudy.setBackgroundColor(if (selectedTab == "study") selectedColor else unselectedColor)
    }

    private fun loadData() {
        when (currentTab) {
            "check" -> loadCheckRecords()
            "scan" -> loadScanRecords()
            "sos" -> loadSOSRecords()
            "study" -> loadStudyRecords()
        }
    }

    private fun loadCheckRecords() {
        val records = DataManager.getCheckRecords()

        if (records.isEmpty()) {
            binding.tvEmpty.visibility = View.VISIBLE
            binding.rvRecords.visibility = View.GONE
            return
        }

        binding.tvEmpty.visibility = View.GONE
        binding.rvRecords.visibility = View.VISIBLE

        val adapter = CheckRecordAdapter(records)
        binding.rvRecords.layoutManager = LinearLayoutManager(this)
        binding.rvRecords.adapter = adapter
    }

    private fun loadScanRecords() {
        val records = DataManager.getScanRecords()

        if (records.isEmpty()) {
            binding.tvEmpty.visibility = View.VISIBLE
            binding.rvRecords.visibility = View.GONE
            return
        }

        binding.tvEmpty.visibility = View.GONE
        binding.rvRecords.visibility = View.VISIBLE

        val adapter = ScanRecordAdapter(records)
        binding.rvRecords.layoutManager = LinearLayoutManager(this)
        binding.rvRecords.adapter = adapter
    }

    private fun loadSOSRecords() {
        val records = DataManager.getSOSRecords()

        if (records.isEmpty()) {
            binding.tvEmpty.visibility = View.VISIBLE
            binding.rvRecords.visibility = View.GONE
            return
        }

        binding.tvEmpty.visibility = View.GONE
        binding.rvRecords.visibility = View.VISIBLE

        val adapter = SOSRecordAdapter(records)
        binding.rvRecords.layoutManager = LinearLayoutManager(this)
        binding.rvRecords.adapter = adapter
    }

    private fun loadStudyRecords() {
        val records = DataManager.getStudyRecords()

        if (records.isEmpty()) {
            binding.tvEmpty.visibility = View.VISIBLE
            binding.rvRecords.visibility = View.GONE
            return
        }

        binding.tvEmpty.visibility = View.GONE
        binding.rvRecords.visibility = View.VISIBLE

        val adapter = StudyRecordAdapter(records)
        binding.rvRecords.layoutManager = LinearLayoutManager(this)
        binding.rvRecords.adapter = adapter
    }

    // 检测记录适配器
    inner class CheckRecordAdapter(
        private val records: List<CheckResult>
    ) : androidx.recyclerview.widget.RecyclerView.Adapter<CheckRecordAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemCheckRecordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(records[position])
        }

        override fun getItemCount() = records.size

        inner class ViewHolder(
            private val binding: ItemCheckRecordBinding
        ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

            fun bind(record: CheckResult) {
                binding.tvContent.text = record.content
                binding.tvRiskLevel.text = record.riskLevel.text
                binding.tvRiskLevel.setTextColor(
                    when (record.riskLevel) {
                        RiskLevel.SAFE -> getColor(R.color.safe_green)
                        RiskLevel.SUSPICIOUS -> getColor(R.color.warning_yellow)
                        RiskLevel.HIGH_RISK -> getColor(R.color.danger_red)
                    }
                )
                binding.tvTime.text = DateUtils.getRelativeTime(record.timestamp)

                if (record.riskKeywords.isNotEmpty()) {
                    binding.tvKeywords.visibility = View.VISIBLE
                    binding.tvKeywords.text = "关键词：${record.riskKeywords.joinToString("、")}"
                } else {
                    binding.tvKeywords.visibility = View.GONE
                }
            }
        }
    }

    // 扫码记录适配器
    inner class ScanRecordAdapter(
        private val records: List<ScanRecord>
    ) : androidx.recyclerview.widget.RecyclerView.Adapter<ScanRecordAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemScanRecordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(records[position])
        }

        override fun getItemCount() = records.size

        inner class ViewHolder(
            private val binding: ItemScanRecordBinding
        ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

            fun bind(record: ScanRecord) {
                binding.tvContent.text = record.content
                binding.tvStatus.text = if (record.isSafe) "安全" else "可疑"
                binding.tvStatus.setTextColor(
                    if (record.isSafe) getColor(R.color.safe_green) else getColor(R.color.warning_yellow)
                )
                binding.tvTime.text = DateUtils.getRelativeTime(record.timestamp)
            }
        }
    }

    // 求助记录适配器
    inner class SOSRecordAdapter(
        private val records: List<SOSRecord>
    ) : androidx.recyclerview.widget.RecyclerView.Adapter<SOSRecordAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemSosRecordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(records[position])
        }

        override fun getItemCount() = records.size

        inner class ViewHolder(
            private val binding: ItemSosRecordBinding
        ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

            fun bind(record: SOSRecord) {
                binding.tvType.text = when (record.type) {
                    com.example.safetyassistant.models.SOSType.CALL -> "呼叫"
                    com.example.safetyassistant.models.SOSType.SMS -> "短信"
                    com.example.safetyassistant.models.SOSType.LOCATION_SHARE -> "位置共享"
                    com.example.safetyassistant.models.SOSType.NEARBY_POLICE -> "查找派出所"
                }
                binding.tvContact.text = "${record.contactName} (${record.contactPhone})"
                binding.tvTime.text = DateUtils.getRelativeTime(record.timestamp)
            }
        }
    }

    // 学习记录适配器
    inner class StudyRecordAdapter(
        private val records: List<StudyRecord>
    ) : androidx.recyclerview.widget.RecyclerView.Adapter<StudyRecordAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemStudyRecordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(records[position])
        }

        override fun getItemCount() = records.size

        inner class ViewHolder(
            private val binding: ItemStudyRecordBinding
        ) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

            fun bind(record: StudyRecord) {
                binding.tvCourseName.text = record.courseName
                binding.tvType.text = when (record.type) {
                    com.example.safetyassistant.models.StudyType.LIVE -> "直播"
                    com.example.safetyassistant.models.StudyType.VIDEO -> "视频"
                }
                binding.tvDuration.text = "学习时长：${DateUtils.formatDuration(record.duration)}"
                binding.tvTime.text = DateUtils.getRelativeTime(record.timestamp)
            }
        }
    }
}