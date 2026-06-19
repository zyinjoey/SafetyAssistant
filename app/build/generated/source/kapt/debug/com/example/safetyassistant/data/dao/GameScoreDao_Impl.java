package com.example.safetyassistant.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.safetyassistant.models.GameScore;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GameScoreDao_Impl implements GameScoreDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GameScore> __insertionAdapterOfGameScore;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public GameScoreDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGameScore = new EntityInsertionAdapter<GameScore>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `game_scores` (`id`,`score`,`totalQuestions`,`correctAnswers`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GameScore entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getScore());
        statement.bindLong(3, entity.getTotalQuestions());
        statement.bindLong(4, entity.getCorrectAnswers());
        statement.bindLong(5, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM game_scores";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final GameScore score, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGameScore.insert(score);
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
  public Object getLatest(final Continuation<? super GameScore> $completion) {
    final String _sql = "SELECT * FROM game_scores ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<GameScore>() {
      @Override
      @Nullable
      public GameScore call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfTotalQuestions = CursorUtil.getColumnIndexOrThrow(_cursor, "totalQuestions");
          final int _cursorIndexOfCorrectAnswers = CursorUtil.getColumnIndexOrThrow(_cursor, "correctAnswers");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final GameScore _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpScore;
            _tmpScore = _cursor.getInt(_cursorIndexOfScore);
            final int _tmpTotalQuestions;
            _tmpTotalQuestions = _cursor.getInt(_cursorIndexOfTotalQuestions);
            final int _tmpCorrectAnswers;
            _tmpCorrectAnswers = _cursor.getInt(_cursorIndexOfCorrectAnswers);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new GameScore(_tmpId,_tmpScore,_tmpTotalQuestions,_tmpCorrectAnswers,_tmpTimestamp);
          } else {
            _result = null;
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
