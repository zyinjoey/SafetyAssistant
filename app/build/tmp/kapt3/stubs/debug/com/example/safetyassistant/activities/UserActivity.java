package com.example.safetyassistant.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/safetyassistant/activities/UserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/safetyassistant/databinding/ActivityUserBinding;", "contactAdapter", "Lcom/example/safetyassistant/activities/UserActivity$EmergencyContactAdapter;", "deleteContact", "", "contact", "Lcom/example/safetyassistant/models/EmergencyContact;", "initView", "loadUserData", "makeCall", "phoneNumber", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showAddContactDialog", "showEditUserDialog", "EmergencyContactAdapter", "app_debug"})
public final class UserActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.safetyassistant.databinding.ActivityUserBinding binding;
    private com.example.safetyassistant.activities.UserActivity.EmergencyContactAdapter contactAdapter;
    
    public UserActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView() {
    }
    
    private final void loadUserData() {
    }
    
    private final void showEditUserDialog() {
    }
    
    private final void showAddContactDialog() {
    }
    
    private final void deleteContact(com.example.safetyassistant.models.EmergencyContact contact) {
    }
    
    private final void makeCall(java.lang.String phoneNumber) {
    }
    
    /**
     * 紧急联系人适配器
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0017B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00072\u000e\u0010\u000f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J \u0010\u0011\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0014\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/safetyassistant/activities/UserActivity$EmergencyContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/UserActivity$EmergencyContactAdapter$ViewHolder;", "Lcom/example/safetyassistant/activities/UserActivity;", "onCallClick", "Lkotlin/Function1;", "Lcom/example/safetyassistant/models/EmergencyContact;", "", "onDeleteClick", "(Lcom/example/safetyassistant/activities/UserActivity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "contacts", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setContacts", "newContacts", "ViewHolder", "app_debug"})
    public final class EmergencyContactAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.UserActivity.EmergencyContactAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.example.safetyassistant.models.EmergencyContact, kotlin.Unit> onCallClick = null;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.example.safetyassistant.models.EmergencyContact, kotlin.Unit> onDeleteClick = null;
        @org.jetbrains.annotations.NotNull()
        private java.util.List<com.example.safetyassistant.models.EmergencyContact> contacts;
        
        public EmergencyContactAdapter(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.example.safetyassistant.models.EmergencyContact, kotlin.Unit> onCallClick, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.example.safetyassistant.models.EmergencyContact, kotlin.Unit> onDeleteClick) {
            super();
        }
        
        public final void setContacts(@org.jetbrains.annotations.NotNull()
        java.util.List<com.example.safetyassistant.models.EmergencyContact> newContacts) {
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public com.example.safetyassistant.activities.UserActivity.EmergencyContactAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.safetyassistant.activities.UserActivity.EmergencyContactAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/UserActivity$EmergencyContactAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemEmergencyContactBinding;", "(Lcom/example/safetyassistant/activities/UserActivity$EmergencyContactAdapter;Lcom/example/safetyassistant/databinding/ItemEmergencyContactBinding;)V", "bind", "", "contact", "Lcom/example/safetyassistant/models/EmergencyContact;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final com.example.safetyassistant.databinding.ItemEmergencyContactBinding binding = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.databinding.ItemEmergencyContactBinding binding) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull()
            com.example.safetyassistant.models.EmergencyContact contact) {
            }
        }
    }
}