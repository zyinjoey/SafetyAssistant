package com.example.safetyassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.safetyassistant.models.GameScore

@Dao
interface GameScoreDao {
    @Insert
    suspend fun insert(score: GameScore)

    @Query("SELECT * FROM game_scores ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatest(): GameScore?

    @Query("DELETE FROM game_scores")
    suspend fun deleteAll()
}
