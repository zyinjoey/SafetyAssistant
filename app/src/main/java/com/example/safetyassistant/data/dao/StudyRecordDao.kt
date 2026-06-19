package com.example.safetyassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safetyassistant.models.StudyRecord

@Dao
interface StudyRecordDao {
    @Insert
    suspend fun insert(record: StudyRecord)

    @Query("SELECT * FROM study_records ORDER BY timestamp DESC LIMIT 100")
    suspend fun getAll(): List<StudyRecord>

    @Query("DELETE FROM study_records")
    suspend fun deleteAll()
}
