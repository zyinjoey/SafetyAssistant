package com.example.safetyassistant.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u001c\u0010\u0016\u001a\u00020\b2\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0006\u0010\u0018\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/safetyassistant/utils/LocationService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "locationCallback", "Lkotlin/Function1;", "Lcom/example/safetyassistant/utils/LocationData;", "", "locationListener", "Landroid/location/LocationListener;", "locationManager", "Landroid/location/LocationManager;", "destroy", "getAddress", "", "latitude", "", "longitude", "getLastKnownLocation", "Landroid/location/Location;", "init", "startLocation", "callback", "stopLocation", "Companion", "app_debug"})
public final class LocationService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private android.location.LocationManager locationManager;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super com.example.safetyassistant.utils.LocationData, kotlin.Unit> locationCallback;
    @org.jetbrains.annotations.Nullable()
    private android.location.LocationListener locationListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.safetyassistant.utils.LocationService.Companion Companion = null;
    
    public LocationService(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void init() {
    }
    
    public final void startLocation(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.safetyassistant.utils.LocationData, kotlin.Unit> callback) {
    }
    
    private final android.location.Location getLastKnownLocation() {
        return null;
    }
    
    private final java.lang.String getAddress(double latitude, double longitude) {
        return null;
    }
    
    public final void stopLocation() {
    }
    
    public final void destroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lcom/example/safetyassistant/utils/LocationService$Companion;", "", "()V", "calculateDistance", "", "lat1", "", "lon1", "lat2", "lon2", "formatDistance", "", "distanceMeters", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final float calculateDistance(double lat1, double lon1, double lat2, double lon2) {
            return 0.0F;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String formatDistance(float distanceMeters) {
            return null;
        }
    }
}