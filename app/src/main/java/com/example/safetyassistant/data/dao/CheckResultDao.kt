package com.example.safetyassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safetyassistant.models.CheckResult

@Dao
interface CheckResultDao {
    @Insert
    suspend fun insert(record: CheckResult)

    @Query("SELECT * FROM check_results ORDER BY timestamp DESC LIMIT 100")
    suspend fun getAll(): List<CheckResult>

    @Query("DELETE FROM check_results")
    suspend fun deleteAll()
}
