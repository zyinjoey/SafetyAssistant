package com.example.safetyassistant.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.safetyassistant.R
import com.example.safetyassistant.databinding.ActivityGameBinding
import com.example.safetyassistant.models.GameQuestion
import com.example.safetyassistant.models.GameScore
import com.example.safetyassistant.utils.DataManager

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    private val questions = mutableListOf<GameQuestion>()
    private var currentQuestionIndex = 0
    private var score = 0
    private var totalQuestions = 0
    private var correctAnswers = 0

    private var isGameStarted = false
    private var isAnswered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initQuestions()
        initView()
        loadHighScore()
        showStartScreen()
    }

    private val allQuestions = listOf(
        // 1-10: 原有题目
        GameQuestion(
            id = "1",
            description = "【银行短信】尊敬的用户，您的账户存在异常，请点击链接进行认证：http://t.cn/xxx",
            isScam = true,
            explanation = "这是典型的钓鱼短信，银行不会通过短信发送认证链接。"
        ),
        GameQuestion(
            id = "2",
            description = "【快递通知】您的快递已送达，请凭取件码到菜鸟驿站领取。",
            isScam = false,
            explanation = "这是正常的快递通知，取件码是快递取件的正常方式。"
        ),
        GameQuestion(
            id = "3",
            description = "【中奖信息】恭喜您获得一等奖！奖金10万元，请联系客服领取。",
            isScam = true,
            explanation = "天上不会掉馅饼，这是典型的中奖诈骗。"
        ),
        GameQuestion(
            id = "4",
            description = "【朋友求助】在吗？我手机坏了，急需用钱，能借我1000元吗？",
            isScam = true,
            explanation = "这是冒充熟人诈骗，遇到这种情况应该电话核实。"
        ),
        GameQuestion(
            id = "5",
            description = "【社保通知】您的社保卡已停用，请点击链接重新激活。",
            isScam = true,
            explanation = "这是社保诈骗，社保部门不会通过短信发送链接。"
        ),
        GameQuestion(
            id = "6",
            description = "【运营商短信】您的手机套餐本月剩余流量5GB。",
            isScam = false,
            explanation = "这是运营商的正常流量提醒短信。"
        ),
        GameQuestion(
            id = "7",
            description = "【客服电话】您好，这里是公安局，您涉嫌一起洗钱案件，请配合调查。",
            isScam = true,
            explanation = "这是冒充公检法诈骗，公安机关不会通过电话办案。"
        ),
        GameQuestion(
            id = "8",
            description = "【网购通知】您的订单已发货，预计3天后送达。",
            isScam = false,
            explanation = "这是正常的网购订单通知。"
        ),
        GameQuestion(
            id = "9",
            description = "【贷款广告】无抵押、无担保、快速放款，额度最高50万。",
            isScam = true,
            explanation = "这是贷款诈骗，正规贷款都需要审核，不会无门槛。"
        ),
        GameQuestion(
            id = "10",
            description = "【积分兑换】您的积分即将过期，请尽快兑换礼品。",
            isScam = true,
            explanation = "这类短信可能是积分诈骗，请到官方渠道核实。"
        ),
        // 11-20: 新增题目
        GameQuestion(
            id = "11",
            description = "【外卖通知】您有一份外卖已送达，请到门口取餐。",
            isScam = false,
            explanation = "这是正常的外卖送达通知。"
        ),
        GameQuestion(
            id = "12",
            description = "【刷单兼职】日赚200-500元，只需手机操作，轻松在家赚钱。",
            isScam = true,
            explanation = "这是刷单诈骗，刷单本身就是违法的，天下没有轻松赚钱的事。"
        ),
        GameQuestion(
            id = "13",
            description = "【银行扣款】您尾号1234的银行卡消费500元，如非本人操作请拨打客服。",
            isScam = false,
            explanation = "这是银行正常的消费提醒短信。"
        ),
        GameQuestion(
            id = "14",
            description = "【航班取消】您购买的XX航班已取消，请点击链接办理退票。",
            isScam = true,
            explanation = "这是航班诈骗，应该通过官方渠道核实航班信息。"
        ),
        GameQuestion(
            id = "15",
            description = "【水电费提醒】您本月水电费共计200元，请按时缴纳。",
            isScam = false,
            explanation = "这是正常的水电费缴费提醒。"
        ),
        GameQuestion(
            id = "16",
            description = "【游戏交易】诚心出售游戏账号，装备豪华，价格实惠，联系方式：QQ123456。",
            isScam = true,
            explanation = "这是游戏账号交易诈骗，可能收到钱后账号被找回。"
        ),
        GameQuestion(
            id = "17",
            description = "【疫苗预约】您已预约新冠疫苗，请按时到指定地点接种。",
            isScam = false,
            explanation = "这是正常的疫苗预约通知。"
        ),
        GameQuestion(
            id = "18",
            description = "【投资理财】加入我们的投资群，导师带单，稳赚不赔，月收益30%。",
            isScam = true,
            explanation = "这是典型的投资诈骗，高收益必然伴随高风险，稳赚不赔的都是骗局。"
        ),
        GameQuestion(
            id = "19",
            description = "【社区通知】本周六上午9点在社区活动室举办健康讲座，欢迎参加。",
            isScam = false,
            explanation = "这是正常的社区活动通知。"
        ),
        GameQuestion(
            id = "20",
            description = "【注销校园贷】您有校园贷记录需要注销，否则影响个人征信，请联系客服。",
            isScam = true,
            explanation = "这是注销校园贷诈骗，征信问题应该通过官方渠道处理。"
        )
    )

    private fun initQuestions() {
        questions.clear()
        // 从20题中随机选择10题
        questions.addAll(allQuestions.shuffled().take(10))
    }

    private fun initView() {
        binding.toolbar.setNavigationOnClickListener {
            if (isGameStarted) {
                showExitConfirm()
            } else {
                finish()
            }
        }

        binding.btnStart.setOnClickListener {
            startGame()
        }

        binding.btnSafe.setOnClickListener {
            answerQuestion(false)
        }

        binding.btnScam.setOnClickListener {
            answerQuestion(true)
        }

        binding.btnNext.setOnClickListener {
            nextQuestion()
        }

        binding.btnBack.setOnClickListener {
            showStartScreen()
        }
    }

    private fun loadHighScore() {
        val highScore = DataManager.getGameScore()
        highScore?.let {
            binding.tvHighScore.text = "最高分：${it.score}"
        }
    }

    private fun showStartScreen() {
        isGameStarted = false
        binding.layoutStart.visibility = View.VISIBLE
        binding.layoutGame.visibility = View.GONE
        binding.layoutResult.visibility = View.GONE
    }

    private fun startGame() {
        isGameStarted = true
        currentQuestionIndex = 0
        score = 0
        totalQuestions = 0
        correctAnswers = 0

        // 打乱问题顺序
        questions.shuffle()

        binding.layoutStart.visibility = View.GONE
        binding.layoutGame.visibility = View.VISIBLE
        binding.layoutResult.visibility = View.GONE

        showQuestion()
    }

    private fun showQuestion() {
        if (currentQuestionIndex >= questions.size) {
            endGame()
            return
        }

        isAnswered = false
        val question = questions[currentQuestionIndex]

        binding.tvQuestionNumber.text = "第 ${currentQuestionIndex + 1} / ${questions.size} 题"
        binding.tvQuestion.text = question.description

        binding.btnSafe.isEnabled = true
        binding.btnScam.isEnabled = true
        binding.layoutExplanation.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
    }

    private fun answerQuestion(isScam: Boolean) {
        if (isAnswered) return
        isAnswered = true

        totalQuestions++
        val question = questions[currentQuestionIndex]

        binding.btnSafe.isEnabled = false
        binding.btnScam.isEnabled = false

        if (isScam == question.isScam) {
            // 答对了
            correctAnswers++
            score += 10
            binding.tvResult.text = "回答正确！+10分"
            binding.tvResult.setTextColor(getColor(R.color.safe_green))
        } else {
            // 答错了
            binding.tvResult.text = "回答错误！"
            binding.tvResult.setTextColor(getColor(R.color.danger_red))
        }

        binding.tvScore.text = "当前得分：$score"

        // 显示解释
        binding.layoutExplanation.visibility = View.VISIBLE
        binding.tvExplanation.text = question.explanation
        binding.btnNext.visibility = View.VISIBLE
    }

    private fun nextQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex >= questions.size) {
            endGame()
        } else {
            showQuestion()
        }
    }

    private fun endGame() {
        isGameStarted = false
        binding.layoutStart.visibility = View.GONE
        binding.layoutGame.visibility = View.GONE
        binding.layoutResult.visibility = View.VISIBLE

        val accuracy = if (totalQuestions > 0) {
            (correctAnswers.toFloat() / totalQuestions * 100).toInt()
        } else 0

        binding.tvFinalScore.text = "最终得分：$score"
        binding.tvAccuracy.text = "正确率：$accuracy% ($correctAnswers/$totalQuestions)"

        // 保存分数
        val gameScore = GameScore(
            score = score,
            totalQuestions = totalQuestions,
            correctAnswers = correctAnswers
        )
        DataManager.saveGameScore(gameScore)

        // 显示评价
        val evaluation = when {
            accuracy >= 80 -> "太棒了！你是反诈小能手！"
            accuracy >= 60 -> "不错不错，继续加油！"
            accuracy >= 40 -> "还需要加强学习哦！"
            else -> "多看看安全知识，提高警惕！"
        }
        binding.tvEvaluation.text = evaluation
    }

    private fun showExitConfirm() {
        AlertDialog.Builder(this)
            .setTitle("退出游戏")
            .setMessage("确定要退出当前游戏吗？")
            .setPositiveButton("退出") { _, _ ->
                finish()
            }
            .setNegativeButton("继续游戏", null)
            .show()
    }

    override fun onBackPressed() {
        if (isGameStarted) {
            showExitConfirm()
        } else {
            super.onBackPressed()
        }
    }
}
