package com.example.safetyassistant.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class GameQuestion(
    val id: String,
    val description: String,
    val isScam: Boolean, // true = 诈骗信息, false = 安全信息
    val explanation: String = ""
)

@Entity(tableName = "game_scores")
data class GameScore(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val score: Int = 0,
    val totalQuestions: Int = 0,
    val correctAnswers: Int = 0,
    val timestamp: Long = System.currentTimeMillis()
) {
    fun getAccuracy(): Float {
        return if (totalQuestions > 0) {
            (correctAnswers.toFloat() / totalQuestions) * 100
        } else {
            0f
        }
    }
}
