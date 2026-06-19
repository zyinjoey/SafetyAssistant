package com.example.safetyassistant.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val id: String,
    var nickname: String,
    var phoneNumber: String,
    var securityLevel: Int, // 1-低 2-中 3-高
    var emergencyContacts: List<EmergencyContact> = emptyList(),
    var avatarUrl: String? = null
) {
    fun getMaskedPhoneNumber(): String {
        return if (phoneNumber.length >= 7) {
            phoneNumber.substring(0, 3) + "****" + phoneNumber.substring(phoneNumber.length - 4)
        } else {
            phoneNumber
        }
    }

    fun getSecurityLevelText(): String {
        return when (securityLevel) {
            1 -> "低"
            2 -> "中"
            3 -> "高"
            else -> "未知"
        }
    }
}

data class EmergencyContact(
    val id: String,
    var name: String,
    var phoneNumber: String,
    var relationship: String // 关系：父母、配偶、朋友等
)
