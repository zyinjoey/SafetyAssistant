package com.example.safetyassistant.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/safetyassistant/databinding/ActivityHistoryBinding;", "currentTab", "", "tabViews", "", "Landroid/widget/TextView;", "getTabViews", "()Ljava/util/List;", "tabViews$delegate", "Lkotlin/Lazy;", "initView", "", "loadCheckRecords", "loadData", "loadSOSRecords", "loadScanRecords", "loadStudyRecords", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "switchTab", "tab", "updateTabSelection", "selectedTab", "CheckRecordAdapter", "SOSRecordAdapter", "ScanRecordAdapter", "StudyRecordAdapter", "app_debug"})
public final class HistoryActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.safetyassistant.databinding.ActivityHistoryBinding binding;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentTab = "check";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy tabViews$delegate = null;
    
    public HistoryActivity() {
        super();
    }
    
    private final java.util.List<android.widget.TextView> getTabViews() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void switchTab(java.lang.String tab) {
    }
    
    private final void updateTabSelection(java.lang.String selectedTab) {
    }
    
    private final void loadData() {
    }
    
    private final void loadCheckRecords() {
    }
    
    private final void loadScanRecords() {
    }
    
    private final void loadSOSRecords() {
    }
    
    private final void loadStudyRecords() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$CheckRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/HistoryActivity$CheckRecordAdapter$ViewHolder;", "Lcom/example/safetyassistant/activities/HistoryActivity;", "records", "", "Lcom/example/safetyassistant/models/CheckResult;", "(Lcom/example/safetyassistant/activities/HistoryActivity;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class CheckRecordAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.HistoryActivity.CheckRecordAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.example.safetyassistant.models.CheckResult> records = null;
        
        public CheckRecordAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.safetyassistant.models.CheckResult> records) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.safetyassistant.activities.HistoryActivity.CheckRecordAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.safetyassistant.activities.HistoryActivity.CheckRecordAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$CheckRecordAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemCheckRecordBinding;", "(Lcom/example/safetyassistant/activities/HistoryActivity$CheckRecordAdapter;Lcom/example/safetyassistant/databinding/ItemCheckRecordBinding;)V", "bind", "", "record", "Lcom/example/safetyassistant/models/CheckResult;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final com.example.safetyassistant.databinding.ItemCheckRecordBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.databinding.ItemCheckRecordBinding binding) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.models.CheckResult record) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$SOSRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/HistoryActivity$SOSRecordAdapter$ViewHolder;", "Lcom/example/safetyassistant/activities/HistoryActivity;", "records", "", "Lcom/example/safetyassistant/models/SOSRecord;", "(Lcom/example/safetyassistant/activities/HistoryActivity;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class SOSRecordAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.HistoryActivity.SOSRecordAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.example.safetyassistant.models.SOSRecord> records = null;
        
        public SOSRecordAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.safetyassistant.models.SOSRecord> records) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.safetyassistant.activities.HistoryActivity.SOSRecordAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.safetyassistant.activities.HistoryActivity.SOSRecordAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$SOSRecordAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemSosRecordBinding;", "(Lcom/example/safetyassistant/activities/HistoryActivity$SOSRecordAdapter;Lcom/example/safetyassistant/databinding/ItemSosRecordBinding;)V", "bind", "", "record", "Lcom/example/safetyassistant/models/SOSRecord;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final com.example.safetyassistant.databinding.ItemSosRecordBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.databinding.ItemSosRecordBinding binding) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.models.SOSRecord record) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$ScanRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/HistoryActivity$ScanRecordAdapter$ViewHolder;", "Lcom/example/safetyassistant/activities/HistoryActivity;", "records", "", "Lcom/example/safetyassistant/models/ScanRecord;", "(Lcom/example/safetyassistant/activities/HistoryActivity;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class ScanRecordAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.HistoryActivity.ScanRecordAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.example.safetyassistant.models.ScanRecord> records = null;
        
        public ScanRecordAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.safetyassistant.models.ScanRecord> records) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.safetyassistant.activities.HistoryActivity.ScanRecordAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.safetyassistant.activities.HistoryActivity.ScanRecordAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$ScanRecordAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemScanRecordBinding;", "(Lcom/example/safetyassistant/activities/HistoryActivity$ScanRecordAdapter;Lcom/example/safetyassistant/databinding/ItemScanRecordBinding;)V", "bind", "", "record", "Lcom/example/safetyassistant/models/ScanRecord;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final com.example.safetyassistant.databinding.ItemScanRecordBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.databinding.ItemScanRecordBinding binding) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.models.ScanRecord record) {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$StudyRecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/HistoryActivity$StudyRecordAdapter$ViewHolder;", "Lcom/example/safetyassistant/activities/HistoryActivity;", "records", "", "Lcom/example/safetyassistant/models/StudyRecord;", "(Lcom/example/safetyassistant/activities/HistoryActivity;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class StudyRecordAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.HistoryActivity.StudyRecordAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.example.safetyassistant.models.StudyRecord> records = null;
        
        public StudyRecordAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.safetyassistant.models.StudyRecord> records) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.safetyassistant.activities.HistoryActivity.StudyRecordAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.safetyassistant.activities.HistoryActivity.StudyRecordAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/HistoryActivity$StudyRecordAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemStudyRecordBinding;", "(Lcom/example/safetyassistant/activities/HistoryActivity$StudyRecordAdapter;Lcom/example/safetyassistant/databinding/ItemStudyRecordBinding;)V", "bind", "", "record", "Lcom/example/safetyassistant/models/StudyRecord;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final com.example.safetyassistant.databinding.ItemStudyRecordBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.databinding.ItemStudyRecordBinding binding) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.models.StudyRecord record) {
            }
        }
    }
}