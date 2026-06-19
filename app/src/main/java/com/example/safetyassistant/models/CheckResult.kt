package com.example.safetyassistant.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "check_results")
data class CheckResult(
    @PrimaryKey
    val id: String,
    val content: String,
    val riskLevel: RiskLevel,
    val riskKeywords: List<String> = emptyList(),
    val safetyTips: String = "",
    val timestamp: Long = System.currentTimeMillis()
)

enum class RiskLevel(val level: Int, val text: String) {
    SAFE(0, "安全"),
    SUSPICIOUS(1, "可疑"),
    HIGH_RISK(2, "高风险")
}
