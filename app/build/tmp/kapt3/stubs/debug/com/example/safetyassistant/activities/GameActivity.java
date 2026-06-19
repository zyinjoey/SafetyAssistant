package com.example.safetyassistant.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/safetyassistant/activities/GameActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "allQuestions", "", "Lcom/example/safetyassistant/models/GameQuestion;", "binding", "Lcom/example/safetyassistant/databinding/ActivityGameBinding;", "correctAnswers", "", "currentQuestionIndex", "isAnswered", "", "isGameStarted", "questions", "", "score", "totalQuestions", "answerQuestion", "", "isScam", "endGame", "initQuestions", "initView", "loadHighScore", "nextQuestion", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showExitConfirm", "showQuestion", "showStartScreen", "startGame", "app_debug"})
public final class GameActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.safetyassistant.databinding.ActivityGameBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.safetyassistant.models.GameQuestion> questions = null;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int totalQuestions = 0;
    private int correctAnswers = 0;
    private boolean isGameStarted = false;
    private boolean isAnswered = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.safetyassistant.models.GameQuestion> allQuestions = null;
    
    public GameActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initQuestions() {
    }
    
    private final void initView() {
    }
    
    private final void loadHighScore() {
    }
    
    private final void showStartScreen() {
    }
    
    private final void startGame() {
    }
    
    private final void showQuestion() {
    }
    
    private final void answerQuestion(boolean isScam) {
    }
    
    private final void nextQuestion() {
    }
    
    private final void endGame() {
    }
    
    private final void showExitConfirm() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}