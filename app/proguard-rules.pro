# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep model classes
-keep class com.example.safetyassistant.models.** { *; }

# Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }

# OkHttp
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class okhttp3.** { *; }

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule { <init>(...); }

# 高德地图
-keep class com.amap.api.** { *; }
-keep class com.loc.** { *; }

# 百度语音
-keep class com.baidu.speech.** { *; }

# ZXing
-keep class com.google.zxing.** { *; }
