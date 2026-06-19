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
import com.example.safetyassistant.models.StudyRecord;
import com.example.safetyassistant.models.StudyType;
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
public final class StudyRecordDao_Impl implements StudyRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StudyRecord> __insertionAdapterOfStudyRecord;

  private final Converters __converters = new Converters();

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public StudyRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudyRecord = new EntityInsertionAdapter<StudyRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `study_records` (`id`,`courseId`,`courseName`,`type`,`duration`,`timestamp`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudyRecord entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getCourseId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCourseId());
        }
        if (entity.getCourseName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCourseName());
        }
        final String _tmp = __converters.fromStudyType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp);
        }
        statement.bindLong(5, entity.getDuration());
        statement.bindLong(6, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM study_records";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final StudyRecord record, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStudyRecord.insert(record);
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
  public Object getAll(final Continuation<? super List<StudyRecord>> $completion) {
    final String _sql = "SELECT * FROM study_records ORDER BY timestamp DESC LIMIT 100";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<StudyRecord>>() {
      @Override
      @NonNull
      public List<StudyRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCourseId = CursorUtil.getColumnIndexOrThrow(_cursor, "courseId");
          final int _cursorIndexOfCourseName = CursorUtil.getColumnIndexOrThrow(_cursor, "courseName");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<StudyRecord> _result = new ArrayList<StudyRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudyRecord _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpCourseId;
            if (_cursor.isNull(_cursorIndexOfCourseId)) {
              _tmpCourseId = null;
            } else {
              _tmpCourseId = _cursor.getString(_cursorIndexOfCourseId);
            }
            final String _tmpCourseName;
            if (_cursor.isNull(_cursorIndexOfCourseName)) {
              _tmpCourseName = null;
            } else {
              _tmpCourseName = _cursor.getString(_cursorIndexOfCourseName);
            }
            final StudyType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toStudyType(_tmp);
            final long _tmpDuration;
            _tmpDuration = _cursor.getLong(_cursorIndexOfDuration);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new StudyRecord(_tmpId,_tmpCourseId,_tmpCourseName,_tmpType,_tmpDuration,_tmpTimestamp);
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
