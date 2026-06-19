package com.example.safetyassistant.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0016J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000bJ\u000e\u0010\'\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/safetyassistant/utils/DataManager;", "", "()V", "checkRecordsCache", "", "Lcom/example/safetyassistant/models/CheckResult;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/safetyassistant/data/AppDatabase;", "gameScoreCache", "Lcom/example/safetyassistant/models/GameScore;", "initDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "scanRecordsCache", "Lcom/example/safetyassistant/models/ScanRecord;", "sosRecordsCache", "Lcom/example/safetyassistant/models/SOSRecord;", "studyRecordsCache", "Lcom/example/safetyassistant/models/StudyRecord;", "userCache", "Lcom/example/safetyassistant/models/User;", "clearAllData", "", "createDefaultUser", "getCheckRecords", "getGameScore", "getSOSRecords", "getScanRecords", "getStudyRecords", "getUser", "init", "context", "Landroid/content/Context;", "saveCheckRecord", "record", "saveGameScore", "score", "saveSOSRecord", "saveScanRecord", "saveStudyRecord", "saveUser", "user", "app_debug"})
public final class DataManager {
    @org.jetbrains.annotations.Nullable()
    private static com.example.safetyassistant.data.AppDatabase database;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CompletableDeferred<java.lang.Boolean> initDeferred = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.safetyassistant.models.User userCache;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.NotNull()
    private static volatile java.util.List<com.example.safetyassistant.models.CheckResult> checkRecordsCache;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.NotNull()
    private static volatile java.util.List<com.example.safetyassistant.models.ScanRecord> scanRecordsCache;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.NotNull()
    private static volatile java.util.List<com.example.safetyassistant.models.SOSRecord> sosRecordsCache;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.NotNull()
    private static volatile java.util.List<com.example.safetyassistant.models.StudyRecord> studyRecordsCache;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.safetyassistant.models.GameScore gameScoreCache;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.safetyassistant.utils.DataManager INSTANCE = null;
    
    private DataManager() {
        super();
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public final void saveUser(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.User user) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.safetyassistant.models.User getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.safetyassistant.models.User createDefaultUser() {
        return null;
    }
    
    public final void saveCheckRecord(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.CheckResult record) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.CheckResult> getCheckRecords() {
        return null;
    }
    
    public final void saveScanRecord(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.ScanRecord record) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.ScanRecord> getScanRecords() {
        return null;
    }
    
    public final void saveSOSRecord(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.SOSRecord record) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.SOSRecord> getSOSRecords() {
        return null;
    }
    
    public final void saveStudyRecord(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.StudyRecord record) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.StudyRecord> getStudyRecords() {
        return null;
    }
    
    public final void saveGameScore(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.GameScore score) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.safetyassistant.models.GameScore getGameScore() {
        return null;
    }
    
    public final void clearAllData() {
    }
}