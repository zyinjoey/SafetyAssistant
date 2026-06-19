package com.example.safetyassistant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.safetyassistant.data.dao.CheckResultDao
import com.example.safetyassistant.data.dao.GameScoreDao
import com.example.safetyassistant.data.dao.SOSRecordDao
import com.example.safetyassistant.data.dao.ScanRecordDao
import com.example.safetyassistant.data.dao.StudyRecordDao
import com.example.safetyassistant.data.dao.UserDao
import com.example.safetyassistant.models.CheckResult
import com.example.safetyassistant.models.GameScore
import com.example.safetyassistant.models.SOSRecord
import com.example.safetyassistant.models.ScanRecord
import com.example.safetyassistant.models.StudyRecord
import com.example.safetyassistant.models.User

@Database(
    entities = [
        CheckResult::class,
        ScanRecord::class,
        SOSRecord::class,
        StudyRecord::class,
        User::class,
        GameScore::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun checkResultDao(): CheckResultDao
    abstract fun scanRecordDao(): ScanRecordDao
    abstract fun sosRecordDao(): SOSRecordDao
    abstract fun studyRecordDao(): StudyRecordDao
    abstract fun userDao(): UserDao
    abstract fun gameScoreDao(): GameScoreDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "safety_assistant_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
