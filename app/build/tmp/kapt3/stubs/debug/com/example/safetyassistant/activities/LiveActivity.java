package com.example.safetyassistant.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/safetyassistant/activities/LiveActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/safetyassistant/databinding/ActivityLiveBinding;", "courseAdapter", "Lcom/example/safetyassistant/activities/LiveActivity$CourseAdapter;", "courses", "", "Lcom/example/safetyassistant/models/Course;", "initView", "", "loadData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CourseAdapter", "app_debug"})
public final class LiveActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.safetyassistant.databinding.ActivityLiveBinding binding;
    private com.example.safetyassistant.activities.LiveActivity.CourseAdapter courseAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.safetyassistant.models.Course> courses = null;
    
    public LiveActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void loadData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0016B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\nR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/safetyassistant/activities/LiveActivity$CourseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/LiveActivity$CourseAdapter$ViewHolder;", "Lcom/example/safetyassistant/activities/LiveActivity;", "onItemClick", "Lkotlin/Function1;", "Lcom/example/safetyassistant/models/Course;", "", "(Lcom/example/safetyassistant/activities/LiveActivity;Lkotlin/jvm/functions/Function1;)V", "list", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCourses", "newList", "ViewHolder", "app_debug"})
    public final class CourseAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.LiveActivity.CourseAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.example.safetyassistant.models.Course, kotlin.Unit> onItemClick = null;
        @org.jetbrains.annotations.NotNull()
        private java.util.List<com.example.safetyassistant.models.Course> list;
        
        public CourseAdapter(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.example.safetyassistant.models.Course, kotlin.Unit> onItemClick) {
            super();
        }
        
        public final void setCourses(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.safetyassistant.models.Course> newList) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.safetyassistant.activities.LiveActivity.CourseAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.safetyassistant.activities.LiveActivity.CourseAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/LiveActivity$CourseAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemCourseBinding;", "(Lcom/example/safetyassistant/activities/LiveActivity$CourseAdapter;Lcom/example/safetyassistant/databinding/ItemCourseBinding;)V", "bind", "", "course", "Lcom/example/safetyassistant/models/Course;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final com.example.safetyassistant.databinding.ItemCourseBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.databinding.ItemCourseBinding binding) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.models.Course course) {
            }
        }
    }
}