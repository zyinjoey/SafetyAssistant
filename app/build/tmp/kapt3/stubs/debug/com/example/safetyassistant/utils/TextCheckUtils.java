package com.example.safetyassistant.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005J,\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/safetyassistant/utils/TextCheckUtils;", "", "()V", "highRiskKeywords", "", "", "scamKeywords", "scamPatterns", "Lkotlin/text/Regex;", "suspiciousAccountPatterns", "suspiciousPhonePatterns", "calculateRiskLevel", "Lcom/example/safetyassistant/models/RiskLevel;", "keywords", "reasons", "calculateSpecialCharRatio", "", "text", "checkText", "Lcom/example/safetyassistant/models/CheckResult;", "generateSafetyTips", "riskLevel", "hasExcessiveRepeatingChars", "", "isScamTemplate", "app_debug"})
public final class TextCheckUtils {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> scamKeywords = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> highRiskKeywords = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<kotlin.text.Regex> scamPatterns = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> suspiciousPhonePatterns = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<kotlin.text.Regex> suspiciousAccountPatterns = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.safetyassistant.utils.TextCheckUtils INSTANCE = null;
    
    private TextCheckUtils() {
        super();
    }
    
    /**
     * 检测文本是否为诈骗信息
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.safetyassistant.models.CheckResult checkText(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    /**
     * 计算特殊字符占比
     */
    private final float calculateSpecialCharRatio(java.lang.String text) {
        return 0.0F;
    }
    
    /**
     * 检测是否有过多重复字符
     */
    private final boolean hasExcessiveRepeatingChars(java.lang.String text) {
        return false;
    }
    
    /**
     * 计算风险等级
     */
    private final com.example.safetyassistant.models.RiskLevel calculateRiskLevel(java.util.List<java.lang.String> keywords, java.util.List<java.lang.String> reasons) {
        return null;
    }
    
    /**
     * 生成安全提示
     */
    private final java.lang.String generateSafetyTips(com.example.safetyassistant.models.RiskLevel riskLevel, java.util.List<java.lang.String> keywords, java.util.List<java.lang.String> reasons) {
        return null;
    }
    
    /**
     * 检测是否为诈骗短信模板
     */
    public final boolean isScamTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return false;
    }
}