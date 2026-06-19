package com.example.safetyassistant.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.safetyassistant.data.dao.CheckResultDao;
import com.example.safetyassistant.data.dao.CheckResultDao_Impl;
import com.example.safetyassistant.data.dao.GameScoreDao;
import com.example.safetyassistant.data.dao.GameScoreDao_Impl;
import com.example.safetyassistant.data.dao.SOSRecordDao;
import com.example.safetyassistant.data.dao.SOSRecordDao_Impl;
import com.example.safetyassistant.data.dao.ScanRecordDao;
import com.example.safetyassistant.data.dao.ScanRecordDao_Impl;
import com.example.safetyassistant.data.dao.StudyRecordDao;
import com.example.safetyassistant.data.dao.StudyRecordDao_Impl;
import com.example.safetyassistant.data.dao.UserDao;
import com.example.safetyassistant.data.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile CheckResultDao _checkResultDao;

  private volatile ScanRecordDao _scanRecordDao;

  private volatile SOSRecordDao _sOSRecordDao;

  private volatile StudyRecordDao _studyRecordDao;

  private volatile UserDao _userDao;

  private volatile GameScoreDao _gameScoreDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `check_results` (`id` TEXT NOT NULL, `content` TEXT NOT NULL, `riskLevel` INTEGER NOT NULL, `riskKeywords` TEXT NOT NULL, `safetyTips` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `scan_records` (`id` TEXT NOT NULL, `content` TEXT NOT NULL, `result` TEXT NOT NULL, `isSafe` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sos_records` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `contactName` TEXT NOT NULL, `contactPhone` TEXT NOT NULL, `latitude` REAL, `longitude` REAL, `timestamp` INTEGER NOT NULL, `message` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `study_records` (`id` TEXT NOT NULL, `courseId` TEXT NOT NULL, `courseName` TEXT NOT NULL, `type` TEXT NOT NULL, `duration` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` TEXT NOT NULL, `nickname` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `securityLevel` INTEGER NOT NULL, `emergencyContacts` TEXT NOT NULL, `avatarUrl` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `game_scores` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `score` INTEGER NOT NULL, `totalQuestions` INTEGER NOT NULL, `correctAnswers` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9bad4b9e12316dd5a57624e6edf83f9d')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `check_results`");
        db.execSQL("DROP TABLE IF EXISTS `scan_records`");
        db.execSQL("DROP TABLE IF EXISTS `sos_records`");
        db.execSQL("DROP TABLE IF EXISTS `study_records`");
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `game_scores`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCheckResults = new HashMap<String, TableInfo.Column>(6);
        _columnsCheckResults.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckResults.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckResults.put("riskLevel", new TableInfo.Column("riskLevel", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckResults.put("riskKeywords", new TableInfo.Column("riskKeywords", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckResults.put("safetyTips", new TableInfo.Column("safetyTips", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckResults.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCheckResults = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCheckResults = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCheckResults = new TableInfo("check_results", _columnsCheckResults, _foreignKeysCheckResults, _indicesCheckResults);
        final TableInfo _existingCheckResults = TableInfo.read(db, "check_results");
        if (!_infoCheckResults.equals(_existingCheckResults)) {
          return new RoomOpenHelper.ValidationResult(false, "check_results(com.example.safetyassistant.models.CheckResult).\n"
                  + " Expected:\n" + _infoCheckResults + "\n"
                  + " Found:\n" + _existingCheckResults);
        }
        final HashMap<String, TableInfo.Column> _columnsScanRecords = new HashMap<String, TableInfo.Column>(5);
        _columnsScanRecords.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecords.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecords.put("result", new TableInfo.Column("result", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecords.put("isSafe", new TableInfo.Column("isSafe", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanRecords.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScanRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScanRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScanRecords = new TableInfo("scan_records", _columnsScanRecords, _foreignKeysScanRecords, _indicesScanRecords);
        final TableInfo _existingScanRecords = TableInfo.read(db, "scan_records");
        if (!_infoScanRecords.equals(_existingScanRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "scan_records(com.example.safetyassistant.models.ScanRecord).\n"
                  + " Expected:\n" + _infoScanRecords + "\n"
                  + " Found:\n" + _existingScanRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsSosRecords = new HashMap<String, TableInfo.Column>(8);
        _columnsSosRecords.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("contactName", new TableInfo.Column("contactName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("contactPhone", new TableInfo.Column("contactPhone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSosRecords.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSosRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSosRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSosRecords = new TableInfo("sos_records", _columnsSosRecords, _foreignKeysSosRecords, _indicesSosRecords);
        final TableInfo _existingSosRecords = TableInfo.read(db, "sos_records");
        if (!_infoSosRecords.equals(_existingSosRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "sos_records(com.example.safetyassistant.models.SOSRecord).\n"
                  + " Expected:\n" + _infoSosRecords + "\n"
                  + " Found:\n" + _existingSosRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsStudyRecords = new HashMap<String, TableInfo.Column>(6);
        _columnsStudyRecords.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudyRecords.put("courseId", new TableInfo.Column("courseId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudyRecords.put("courseName", new TableInfo.Column("courseName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudyRecords.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudyRecords.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudyRecords.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudyRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudyRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudyRecords = new TableInfo("study_records", _columnsStudyRecords, _foreignKeysStudyRecords, _indicesStudyRecords);
        final TableInfo _existingStudyRecords = TableInfo.read(db, "study_records");
        if (!_infoStudyRecords.equals(_existingStudyRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "study_records(com.example.safetyassistant.models.StudyRecord).\n"
                  + " Expected:\n" + _infoStudyRecords + "\n"
                  + " Found:\n" + _existingStudyRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(6);
        _columnsUsers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("nickname", new TableInfo.Column("nickname", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("securityLevel", new TableInfo.Column("securityLevel", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("emergencyContacts", new TableInfo.Column("emergencyContacts", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("avatarUrl", new TableInfo.Column("avatarUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.example.safetyassistant.models.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsGameScores = new HashMap<String, TableInfo.Column>(5);
        _columnsGameScores.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameScores.put("score", new TableInfo.Column("score", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameScores.put("totalQuestions", new TableInfo.Column("totalQuestions", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameScores.put("correctAnswers", new TableInfo.Column("correctAnswers", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGameScores.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGameScores = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGameScores = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGameScores = new TableInfo("game_scores", _columnsGameScores, _foreignKeysGameScores, _indicesGameScores);
        final TableInfo _existingGameScores = TableInfo.read(db, "game_scores");
        if (!_infoGameScores.equals(_existingGameScores)) {
          return new RoomOpenHelper.ValidationResult(false, "game_scores(com.example.safetyassistant.models.GameScore).\n"
                  + " Expected:\n" + _infoGameScores + "\n"
                  + " Found:\n" + _existingGameScores);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9bad4b9e12316dd5a57624e6edf83f9d", "0963fa8d811143b56dc91a4fec266b33");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "check_results","scan_records","sos_records","study_records","users","game_scores");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `check_results`");
      _db.execSQL("DELETE FROM `scan_records`");
      _db.execSQL("DELETE FROM `sos_records`");
      _db.execSQL("DELETE FROM `study_records`");
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `game_scores`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CheckResultDao.class, CheckResultDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ScanRecordDao.class, ScanRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SOSRecordDao.class, SOSRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StudyRecordDao.class, StudyRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GameScoreDao.class, GameScoreDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public CheckResultDao checkResultDao() {
    if (_checkResultDao != null) {
      return _checkResultDao;
    } else {
      synchronized(this) {
        if(_checkResultDao == null) {
          _checkResultDao = new CheckResultDao_Impl(this);
        }
        return _checkResultDao;
      }
    }
  }

  @Override
  public ScanRecordDao scanRecordDao() {
    if (_scanRecordDao != null) {
      return _scanRecordDao;
    } else {
      synchronized(this) {
        if(_scanRecordDao == null) {
          _scanRecordDao = new ScanRecordDao_Impl(this);
        }
        return _scanRecordDao;
      }
    }
  }

  @Override
  public SOSRecordDao sosRecordDao() {
    if (_sOSRecordDao != null) {
      return _sOSRecordDao;
    } else {
      synchronized(this) {
        if(_sOSRecordDao == null) {
          _sOSRecordDao = new SOSRecordDao_Impl(this);
        }
        return _sOSRecordDao;
      }
    }
  }

  @Override
  public StudyRecordDao studyRecordDao() {
    if (_studyRecordDao != null) {
      return _studyRecordDao;
    } else {
      synchronized(this) {
        if(_studyRecordDao == null) {
          _studyRecordDao = new StudyRecordDao_Impl(this);
        }
        return _studyRecordDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public GameScoreDao gameScoreDao() {
    if (_gameScoreDao != null) {
      return _gameScoreDao;
    } else {
      synchronized(this) {
        if(_gameScoreDao == null) {
          _gameScoreDao = new GameScoreDao_Impl(this);
        }
        return _gameScoreDao;
      }
    }
  }
}
