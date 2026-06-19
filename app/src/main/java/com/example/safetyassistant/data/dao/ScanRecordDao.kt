package com.example.safetyassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safetyassistant.models.ScanRecord

@Dao
interface ScanRecordDao {
    @Insert
    suspend fun insert(record: ScanRecord)

    @Query("SELECT * FROM scan_records ORDER BY timestamp DESC LIMIT 100")
    suspend fun getAll(): List<ScanRecord>

    @Query("DELETE FROM scan_records")
    suspend fun deleteAll()
}
