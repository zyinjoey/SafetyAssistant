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
import com.example.safetyassistant.models.SOSRecord;
import com.example.safetyassistant.models.SOSType;
import java.lang.Class;
import java.lang.Double;
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
public final class SOSRecordDao_Impl implements SOSRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SOSRecord> __insertionAdapterOfSOSRecord;

  private final Converters __converters = new Converters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public SOSRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSOSRecord = new EntityInsertionAdapter<SOSRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `sos_records` (`id`,`type`,`contactName`,`contactPhone`,`latitude`,`longitude`,`timestamp`,`message`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SOSRecord entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        final String _tmp = __converters.fromSOSType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, _tmp);
        }
        if (entity.getContactName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContactName());
        }
        if (entity.getContactPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContactPhone());
        }
        if (entity.getLatitude() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getLongitude());
        }
        statement.bindLong(7, entity.getTimestamp());
        if (entity.getMessage() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getMessage());
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM sos_records";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final SOSRecord record, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSOSRecord.insert(record);
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
  public Object getAll(final Continuation<? super List<SOSRecord>> $completion) {
    final String _sql = "SELECT * FROM sos_records ORDER BY timestamp DESC LIMIT 50";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<SOSRecord>>() {
      @Override
      @NonNull
      public List<SOSRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contactName");
          final int _cursorIndexOfContactPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPhone");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final List<SOSRecord> _result = new ArrayList<SOSRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SOSRecord _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final SOSType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toSOSType(_tmp);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final String _tmpContactPhone;
            if (_cursor.isNull(_cursorIndexOfContactPhone)) {
              _tmpContactPhone = null;
            } else {
              _tmpContactPhone = _cursor.getString(_cursorIndexOfContactPhone);
            }
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            _item = new SOSRecord(_tmpId,_tmpType,_tmpContactName,_tmpContactPhone,_tmpLatitude,_tmpLongitude,_tmpTimestamp,_tmpMessage);
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
