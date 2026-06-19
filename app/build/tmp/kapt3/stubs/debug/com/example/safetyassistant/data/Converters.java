package com.example.safetyassistant.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0013\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/safetyassistant/data/Converters;", "", "()V", "gson", "Lcom/google/gson/Gson;", "fromEmergencyContactList", "", "value", "", "Lcom/example/safetyassistant/models/EmergencyContact;", "fromRiskLevel", "", "Lcom/example/safetyassistant/models/RiskLevel;", "fromSOSType", "Lcom/example/safetyassistant/models/SOSType;", "fromStringList", "fromStudyType", "Lcom/example/safetyassistant/models/StudyType;", "toEmergencyContactList", "json", "toRiskLevel", "level", "toSOSType", "name", "toStringList", "toStudyType", "app_debug"})
public final class Converters {
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    public final int fromRiskLevel(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.RiskLevel value) {
        return 0;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.example.safetyassistant.models.RiskLevel toRiskLevel(int level) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromSOSType(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.SOSType value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.example.safetyassistant.models.SOSType toSOSType(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromStudyType(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.models.StudyType value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final com.example.safetyassistant.models.StudyType toStudyType(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromStringList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> toStringList(@org.jetbrains.annotations.NotNull()
    java.lang.String json) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fromEmergencyContactList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.safetyassistant.models.EmergencyContact> value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.EmergencyContact> toEmergencyContactList(@org.jetbrains.annotations.NotNull()
    java.lang.String json) {
        return null;
    }
}