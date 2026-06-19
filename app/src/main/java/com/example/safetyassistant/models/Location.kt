package com.example.safetyassistant.models

data class Location(
    val id: String,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val type: LocationType,
    val distance: Float? = null // 距离（米）
)

enum class LocationType {
    POLICE_STATION,  // 派出所
    BANK,            // 银行
    OPERATOR          // 营业厅
}
