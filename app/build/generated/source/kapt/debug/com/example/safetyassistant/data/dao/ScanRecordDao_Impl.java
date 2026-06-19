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
import com.example.safetyassistant.models.ScanRecord;
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
public final class ScanRecordDao_Impl implements ScanRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ScanRecord> __insertionAdapterOfScanRecord;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ScanRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScanRecord = new EntityInsertionAdapter<ScanRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `scan_records` (`id`,`content`,`result`,`isSafe`,`timestamp`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ScanRecord entity) {
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
        if (entity.getResult() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getResult());
        }
        final int _tmp = entity.isSafe() ? 1 : 0;
        statement.bindLong(4, _tmp);
        statement.bindLong(5, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM scan_records";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final ScanRecord record, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfScanRecord.insert(record);
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
  public Object getAll(final Continuation<? super List<ScanRecord>> $completion) {
    final String _sql = "SELECT * FROM scan_records ORDER BY timestamp DESC LIMIT 100";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<ScanRecord>>() {
      @Override
      @NonNull
      public List<ScanRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfResult = CursorUtil.getColumnIndexOrThrow(_cursor, "result");
          final int _cursorIndexOfIsSafe = CursorUtil.getColumnIndexOrThrow(_cursor, "isSafe");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<ScanRecord> _result = new ArrayList<ScanRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ScanRecord _item;
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
            final String _tmpResult;
            if (_cursor.isNull(_cursorIndexOfResult)) {
              _tmpResult = null;
            } else {
              _tmpResult = _cursor.getString(_cursorIndexOfResult);
            }
            final boolean _tmpIsSafe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSafe);
            _tmpIsSafe = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new ScanRecord(_tmpId,_tmpContent,_tmpResult,_tmpIsSafe,_tmpTimestamp);
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
