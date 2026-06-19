package com.example.safetyassistant.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scan_records")
data class ScanRecord(
    @PrimaryKey
    val id: String,
    val content: String,
    val result: String,
    val isSafe: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
