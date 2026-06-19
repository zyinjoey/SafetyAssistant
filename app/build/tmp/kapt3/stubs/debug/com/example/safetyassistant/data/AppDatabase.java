package com.example.safetyassistant.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lcom/example/safetyassistant/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "checkResultDao", "Lcom/example/safetyassistant/data/dao/CheckResultDao;", "gameScoreDao", "Lcom/example/safetyassistant/data/dao/GameScoreDao;", "scanRecordDao", "Lcom/example/safetyassistant/data/dao/ScanRecordDao;", "sosRecordDao", "Lcom/example/safetyassistant/data/dao/SOSRecordDao;", "studyRecordDao", "Lcom/example/safetyassistant/data/dao/StudyRecordDao;", "userDao", "Lcom/example/safetyassistant/data/dao/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.safetyassistant.models.CheckResult.class, com.example.safetyassistant.models.ScanRecord.class, com.example.safetyassistant.models.SOSRecord.class, com.example.safetyassistant.models.StudyRecord.class, com.example.safetyassistant.models.User.class, com.example.safetyassistant.models.GameScore.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.example.safetyassistant.data.Converters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.safetyassistant.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.safetyassistant.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.safetyassistant.data.dao.CheckResultDao checkResultDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.safetyassistant.data.dao.ScanRecordDao scanRecordDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.safetyassistant.data.dao.SOSRecordDao sosRecordDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.safetyassistant.data.dao.StudyRecordDao studyRecordDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.safetyassistant.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.safetyassistant.data.dao.GameScoreDao gameScoreDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/safetyassistant/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/safetyassistant/data/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.safetyassistant.data.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}