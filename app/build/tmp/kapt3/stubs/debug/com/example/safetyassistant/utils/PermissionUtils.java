package com.example.safetyassistant.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/example/safetyassistant/utils/PermissionUtils;", "", "()V", "REQUEST_CODE_PERMISSIONS", "", "REQUIRED_PERMISSIONS", "", "", "getREQUIRED_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "hasAllPermissions", "", "context", "Landroid/content/Context;", "hasPermission", "permission", "isPermissionDeniedForever", "activity", "Landroid/app/Activity;", "requestPermission", "", "requestCode", "requestPermissions", "app_debug"})
public final class PermissionUtils {
    public static final int REQUEST_CODE_PERMISSIONS = 1001;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] REQUIRED_PERMISSIONS = {"android.permission.CAMERA", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.RECORD_AUDIO", "android.permission.CALL_PHONE", "android.permission.SEND_SMS", "android.permission.READ_SMS"};
    @org.jetbrains.annotations.NotNull()
    public static final com.example.safetyassistant.utils.PermissionUtils INSTANCE = null;
    
    private PermissionUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getREQUIRED_PERMISSIONS() {
        return null;
    }
    
    /**
     * 检查权限是否已授权
     */
    public final boolean hasPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
    
    /**
     * 检查所有权限是否已授权
     */
    public final boolean hasAllPermissions(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * 请求权限
     */
    public final void requestPermissions(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    /**
     * 请求单个权限
     */
    public final void requestPermission(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String permission, int requestCode) {
    }
    
    /**
     * 检查权限是否被永久拒绝
     */
    public final boolean isPermissionDeniedForever(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String permission) {
        return false;
    }
}