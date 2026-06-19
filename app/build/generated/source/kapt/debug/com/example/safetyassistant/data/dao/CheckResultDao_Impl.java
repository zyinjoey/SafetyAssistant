package com.example.safetyassistant.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.safetyassistant.data.Converters;
import com.example.safetyassistant.models.CheckResult;
import com.example.safetyassistant.models.RiskLevel;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CheckResultDao_Impl implements CheckResultDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CheckResult> __insertionAdapterOfCheckResult;

  private final Converters __converters = new Converters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public CheckResultDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCheckResult = new EntityInsertionAdapter<CheckResult>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `check_results` (`id`,`content`,`riskLevel`,`riskKeywords`,`safetyTips`,`timestamp`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CheckResult entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getContent() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContent());
        }
        final int _tmp = __converters.fromRiskLevel(entity.getRiskLevel());
        statement.bindLong(3, _tmp);
        final String _tmp_1 = __converters.fromStringList(entity.getRiskKeywords());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        if (entity.getSafetyTips() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSafetyTips());
        }
        statement.bindLong(6, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM check_results";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final CheckResult record, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCheckResult.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<CheckResult>> $completion) {
    final String _sql = "SELECT * FROM check_results ORDER BY timestamp DESC LIMIT 100";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<CheckResult>>() {
      @Override
      @NonNull
      public List<CheckResult> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfRiskLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "riskLevel");
          final int _cursorIndexOfRiskKeywords = CursorUtil.getColumnIndexOrThrow(_cursor, "riskKeywords");
          final int _cursorIndexOfSafetyTips = CursorUtil.getColumnIndexOrThrow(_cursor, "safetyTips");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<CheckResult> _result = new ArrayList<CheckResult>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CheckResult _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final RiskLevel _tmpRiskLevel;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfRiskLevel);
            _tmpRiskLevel = __converters.toRiskLevel(_tmp);
            final List<String> _tmpRiskKeywords;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfRiskKeywords)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfRiskKeywords);
            }
            _tmpRiskKeywords = __converters.toStringList(_tmp_1);
            final String _tmpSafetyTips;
            if (_cursor.isNull(_cursorIndexOfSafetyTips)) {
              _tmpSafetyTips = null;
            } else {
              _tmpSafetyTips = _cursor.getString(_cursorIndexOfSafetyTips);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new CheckResult(_tmpId,_tmpContent,_tmpRiskLevel,_tmpRiskKeywords,_tmpSafetyTips,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
