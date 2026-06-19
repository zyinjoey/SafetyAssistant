package com.example.safetyassistant.utils;

/**
 * Activity 基类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0004J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0004R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/example/safetyassistant/utils/BaseActivity;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "createBinding", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLongToast", "message", "", "showToast", "app_debug"})
public abstract class BaseActivity<VB extends androidx.viewbinding.ViewBinding> extends androidx.appcompat.app.AppCompatActivity {
    protected VB binding;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final VB getBinding() {
        return null;
    }
    
    protected final void setBinding(@org.jetbrains.annotations.NotNull()
    VB p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 创建 ViewBinding
     */
    @org.jetbrains.annotations.NotNull()
    public abstract VB createBinding();
    
    /**
     * 初始化视图
     */
    public abstract void initView();
    
    /**
     * 初始化数据
     */
    public abstract void initData();
    
    /**
     * 显示 Toast
     */
    protected final void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * 显示长 Toast
     */
    protected final void showLongToast(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}