package com.example.safetyassistant.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sos_records")
data class SOSRecord(
    @PrimaryKey
    val id: String,
    val type: SOSType,
    val contactName: String,
    val contactPhone: String,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val message: String = ""
)

enum class SOSType {
    CALL,
    SMS,
    LOCATION_SHARE,
    NEARBY_POLICE
}
