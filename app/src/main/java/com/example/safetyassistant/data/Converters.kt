package com.example.safetyassistant.data

import androidx.room.TypeConverter
import com.example.safetyassistant.models.EmergencyContact
import com.example.safetyassistant.models.RiskLevel
import com.example.safetyassistant.models.SOSType
import com.example.safetyassistant.models.StudyType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromRiskLevel(value: RiskLevel): Int = value.level

    @TypeConverter
    fun toRiskLevel(level: Int): RiskLevel =
        RiskLevel.values().firstOrNull { it.level == level } ?: RiskLevel.SAFE

    @TypeConverter
    fun fromSOSType(value: SOSType): String = value.name

    @TypeConverter
    fun toSOSType(name: String): SOSType =
        SOSType.values().firstOrNull { it.name == name } ?: SOSType.CALL

    @TypeConverter
    fun fromStudyType(value: StudyType): String = value.name

    @TypeConverter
    fun toStudyType(name: String): StudyType =
        StudyType.values().firstOrNull { it.name == name } ?: StudyType.LIVE

    @TypeConverter
    fun fromStringList(value: List<String>): String = gson.toJson(value)

    @TypeConverter
    fun toStringList(json: String): List<String> {
        return if (json.isBlank()) {
            emptyList()
        } else {
            try {
                val type = object : TypeToken<List<String>>() {}.type
                gson.fromJson(json, type) ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    @TypeConverter
    fun fromEmergencyContactList(value: List<EmergencyContact>): String = gson.toJson(value)

    @TypeConverter
    fun toEmergencyContactList(json: String): List<EmergencyContact> {
        return if (json.isBlank()) {
            emptyList()
        } else {
            try {
                val type = object : TypeToken<List<EmergencyContact>>() {}.type
                gson.fromJson(json, type) ?: emptyList()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
}
