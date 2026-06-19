package com.example.safetyassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safetyassistant.models.SOSRecord

@Dao
interface SOSRecordDao {
    @Insert
    suspend fun insert(record: SOSRecord)

    @Query("SELECT * FROM sos_records ORDER BY timestamp DESC LIMIT 50")
    suspend fun getAll(): List<SOSRecord>

    @Query("DELETE FROM sos_records")
    suspend fun deleteAll()
}
