package com.example.safetyassistant.models

data class Course(
    val id: String,
    val title: String,
    val description: String,
    val type: CourseType,
    val thumbnailUrl: String? = null,
    val videoUrl: String? = null,
    val duration: Long = 0,
    val lecturer: String = "",
    val viewerCount: Int = 0
)

enum class CourseType {
    LIVE,
    VIDEO
}
