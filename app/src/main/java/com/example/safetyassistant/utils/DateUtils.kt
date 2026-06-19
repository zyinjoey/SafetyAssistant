package com.example.safetyassistant.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    private val dateFormatShort = SimpleDateFormat("MM-dd HH:mm", Locale.getDefault())
    private val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

    /**
     * 格式化时间戳为完整日期时间
     */
    fun formatDateTime(timestamp: Long): String {
        return dateFormat.format(Date(timestamp))
    }

    /**
     * 格式化时间戳为短日期时间
     */
    fun formatDateTimeShort(timestamp: Long): String {
        return dateFormatShort.format(Date(timestamp))
    }

    /**
     * 格式化时间戳为时间
     */
    fun formatTime(timestamp: Long): String {
        return timeFormat.format(Date(timestamp))
    }

    /**
     * 获取相对时间描述
     */
    fun getRelativeTime(timestamp: Long): String {
        val now = System.currentTimeMillis()
        val diff = now - timestamp

        return when {
            diff < 60 * 1000 -> "刚刚"
            diff < 60 * 60 * 1000 -> "${diff / (60 * 1000)}分钟前"
            diff < 24 * 60 * 60 * 1000 -> "${diff / (60 * 60 * 1000)}小时前"
            diff < 7 * 24 * 60 * 60 * 1000 -> "${diff / (24 * 60 * 60 * 1000)}天前"
            else -> formatDateTimeShort(timestamp)
        }
    }

    /**
     * 格式化时长（秒）
     */
    fun formatDuration(seconds: Long): String {
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val secs = seconds % 60

        return when {
            hours > 0 -> String.format("%d:%02d:%02d", hours, minutes, secs)
            else -> String.format("%02d:%02d", minutes, secs)
        }
    }
}
