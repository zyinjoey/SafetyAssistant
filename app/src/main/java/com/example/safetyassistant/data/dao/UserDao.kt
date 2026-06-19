package com.example.safetyassistant.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.safetyassistant.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getUser(): User?

    @Query("DELETE FROM users")
    suspend fun deleteAll()
}
