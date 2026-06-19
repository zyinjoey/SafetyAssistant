package com.example.safetyassistant.models;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JM\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010(\u001a\u00020\u0003J\u0006\u0010)\u001a\u00020\u0003J\t\u0010*\u001a\u00020\u0007H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006,"}, d2 = {"Lcom/example/safetyassistant/models/User;", "", "id", "", "nickname", "phoneNumber", "securityLevel", "", "emergencyContacts", "", "Lcom/example/safetyassistant/models/EmergencyContact;", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getEmergencyContacts", "()Ljava/util/List;", "setEmergencyContacts", "(Ljava/util/List;)V", "getId", "getNickname", "setNickname", "getPhoneNumber", "setPhoneNumber", "getSecurityLevel", "()I", "setSecurityLevel", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getMaskedPhoneNumber", "getSecurityLevelText", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "users")
public final class User {
    @androidx.room.PrimaryKey()
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String nickname;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String phoneNumber;
    private int securityLevel;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.safetyassistant.models.EmergencyContact> emergencyContacts;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String avatarUrl;
    
    public User(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, int securityLevel, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.safetyassistant.models.EmergencyContact> emergencyContacts, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUrl) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNickname() {
        return null;
    }
    
    public final void setNickname(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getSecurityLevel() {
        return 0;
    }
    
    public final void setSecurityLevel(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.EmergencyContact> getEmergencyContacts() {
        return null;
    }
    
    public final void setEmergencyContacts(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.safetyassistant.models.EmergencyContact> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarUrl() {
        return null;
    }
    
    public final void setAvatarUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMaskedPhoneNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecurityLevelText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.safetyassistant.models.EmergencyContact> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.safetyassistant.models.User copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, int securityLevel, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.safetyassistant.models.EmergencyContact> emergencyContacts, @org.jetbrains.annotations.Nullable()
    java.lang.String avatarUrl) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}