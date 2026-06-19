package com.example.safetyassistant.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\nR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/safetyassistant/activities/EmergencyContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/safetyassistant/activities/EmergencyContactAdapter$ViewHolder;", "onCallClick", "Lkotlin/Function1;", "Lcom/example/safetyassistant/models/EmergencyContact;", "", "onDeleteClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "contacts", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setContacts", "list", "ViewHolder", "app_debug"})
public final class EmergencyContactAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.safetyassistant.activities.EmergencyContactAdapter.ViewHolder> {
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
    java.util.List<com.example.safetyassistant.models.EmergencyContact> list) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.safetyassistant.activities.EmergencyContactAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.safetyassistant.activities.EmergencyContactAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/safetyassistant/activities/EmergencyContactAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/safetyassistant/databinding/ItemEmergencyContactBinding;", "(Lcom/example/safetyassistant/activities/EmergencyContactAdapter;Lcom/example/safetyassistant/databinding/ItemEmergencyContactBinding;)V", "bind", "", "contact", "Lcom/example/safetyassistant/models/EmergencyContact;", "app_debug"})
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