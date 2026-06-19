package com.example.safetyassistant.utils

import android.content.Context
import com.example.safetyassistant.data.AppDatabase
import com.example.safetyassistant.models.*
import kotlinx.coroutines.*

object DataManager {

    private var database: AppDatabase? = null
    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val initDeferred = CompletableDeferred<Boolean>()

    @Volatile
    private var userCache: User? = null
    @Volatile
    private var checkRecordsCache: List<CheckResult> = emptyList()
    @Volatile
    private var scanRecordsCache: List<ScanRecord> = emptyList()
    @Volatile
    private var sosRecordsCache: List<SOSRecord> = emptyList()
    @Volatile
    private var studyRecordsCache: List<StudyRecord> = emptyList()
    @Volatile
    private var gameScoreCache: GameScore? = null

    fun init(context: Context) {
        coroutineScope.launch {
            try {
                val db = AppDatabase.getDatabase(context)
                database = db
                userCache = db.userDao().getUser()
                checkRecordsCache = db.checkResultDao().getAll()
                scanRecordsCache = db.scanRecordDao().getAll()
                sosRecordsCache = db.sosRecordDao().getAll()
                studyRecordsCache = db.studyRecordDao().getAll()
                gameScoreCache = db.gameScoreDao().getLatest()
                initDeferred.complete(true)
            } catch (e: Exception) {
                e.printStackTrace()
                initDeferred.complete(false)
            }
        }
    }

    fun saveUser(user: User) {
        userCache = user
        coroutineScope.launch {
            try {
                initDeferred.await()
                val db = database ?: return@launch
                val existing = db.userDao().getUser()
                if (existing == null) {
                    db.userDao().insert(user)
                } else {
                    db.userDao().update(user)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getUser(): User? = userCache

    fun createDefaultUser(): User {
        val user = User(
            id = java.util.UUID.randomUUID().toString(),
            nickname = "赵易",
            phoneNumber = "15105861003",
            securityLevel = 1,
            emergencyContacts = listOf(
                EmergencyContact(
                    id = java.util.UUID.randomUUID().toString(),
                    name = "爸爸",
                    phoneNumber = "18758171246",
                    relationship = "父亲"
                ),
                EmergencyContact(
                    id = java.util.UUID.randomUUID().toString(),
                    name = "妈妈",
                    phoneNumber = "13700137000",
                    relationship = "母亲"
                )
            )
        )
        saveUser(user)
        return user
    }

    fun saveCheckRecord(record: CheckResult) {
        val updated = listOf(record) + checkRecordsCache.take(99)
        checkRecordsCache = updated
        coroutineScope.launch {
            try {
                initDeferred.await()
                val db = database ?: return@launch
                db.checkResultDao().deleteAll()
                updated.forEach { db.checkResultDao().insert(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCheckRecords(): List<CheckResult> = checkRecordsCache

    fun saveScanRecord(record: ScanRecord) {
        val updated = listOf(record) + scanRecordsCache.take(99)
        scanRecordsCache = updated
        coroutineScope.launch {
            try {
                initDeferred.await()
                val db = database ?: return@launch
                db.scanRecordDao().deleteAll()
                updated.forEach { db.scanRecordDao().insert(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getScanRecords(): List<ScanRecord> = scanRecordsCache

    fun saveSOSRecord(record: SOSRecord) {
        val updated = listOf(record) + sosRecordsCache.take(49)
        sosRecordsCache = updated
        coroutineScope.launch {
            try {
                initDeferred.await()
                val db = database ?: return@launch
                db.sosRecordDao().deleteAll()
                updated.forEach { db.sosRecordDao().insert(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getSOSRecords(): List<SOSRecord> = sosRecordsCache

    fun saveStudyRecord(record: StudyRecord) {
        val updated = listOf(record) + studyRecordsCache.take(99)
        studyRecordsCache = updated
        coroutineScope.launch {
            try {
                initDeferred.await()
                val db = database ?: return@launch
                db.studyRecordDao().deleteAll()
                updated.forEach { db.studyRecordDao().insert(it) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getStudyRecords(): List<StudyRecord> = studyRecordsCache

    fun saveGameScore(score: GameScore) {
        gameScoreCache = score
        coroutineScope.launch {
            try {
                initDeferred.await()
                database?.gameScoreDao()?.insert(score)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getGameScore(): GameScore? = gameScoreCache

    fun clearAllData() {
        userCache = null
        checkRecordsCache = emptyList()
        scanRecordsCache = emptyList()
        sosRecordsCache = emptyList()
        studyRecordsCache = emptyList()
        gameScoreCache = null
        coroutineScope.launch {
            try {
                initDeferred.await()
                val db = database ?: return@launch
                db.checkResultDao().deleteAll()
                db.scanRecordDao().deleteAll()
                db.sosRecordDao().deleteAll()
                db.studyRecordDao().deleteAll()
                db.userDao().deleteAll()
                db.gameScoreDao().deleteAll()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
