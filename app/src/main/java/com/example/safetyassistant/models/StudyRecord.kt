package com.example.safetyassistant.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study_records")
data class StudyRecord(
    @PrimaryKey
    val id: String,
    val courseId: String,
    val courseName: String,
    val type: StudyType,
    val duration: Long = 0, // 学习时长（秒）
    val timestamp: Long = System.currentTimeMillis()
)

enum class StudyType {
    LIVE,   // 直播
    VIDEO   // 视频课程
}
