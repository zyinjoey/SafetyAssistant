package com.example.safetyassistant.utils

import com.example.safetyassistant.models.CheckResult
import com.example.safetyassistant.models.RiskLevel
import java.util.UUID

object TextCheckUtils {

    // 诈骗关键词库
    private val scamKeywords = listOf(
        // 银行诈骗
        "账户异常", "资金被冻结", "银行卡过期", "银行密码过期",
        "您的银行账户", "银行安全", "账户解锁", "网银升级",

        // 快递诈骗
        "包裹有违禁品", "快递被扣押", "取件码", "快递异常",

        // 中奖诈骗
        "恭喜中奖", "一等奖", "奖金", "抽奖", "中奖信息", "获得奖品",
        "扫码领奖", "免费领取",

        // 杀猪盘
        "投资平台", "稳赚不赔", "高收益", "投资理财",
        "导师带你", "内幕消息", "漏洞", "博彩", "彩票",
        "带你赚钱", "回报率高", "区块链", "虚拟货币",

        // 冒充公检法
        "涉嫌洗钱", "涉嫌犯罪", "通缉令", "资金清查",
        "安全账户", "调查账户", "刑警", "警官",
        "冻结账户", "法律文书", "传唤",

        // 医保社保
        "医保卡异常", "社保卡停用", "医保报销", "社保升级",

        // 熟人诈骗
        "出事了", "急需用钱", "借钱", "汇款", "住院",
        "被绑架", "受伤", "嫖娼被抓", "醉驾",

        // 网购诈骗
        "订单异常", "退款", "退货", "质量问题",
        "商品缺货", "卖家联系方式", "交易失败",

        // 贷款诈骗
        "无抵押贷款", "快速放款", "贷款申请",
        "额度提升", "信用评估", "注销账户",

        // 积分兑换
        "积分兑换", "积分即将过期", "兑换礼品", "积分清零",

        // 色情诈骗
        "裸聊", "约炮", "同城交友", "美女", "激情",

        // 钓鱼链接
        "点击链接", "登录网址", "认证", "激活",
        "t.cn", "url.cn", "tinyurl", "bit.ly",

        // 刷单诈骗
        "刷单", "兼职", "做任务", "返利",
        "关注公众号", "点赞", "好评返现",

        // 游戏诈骗
        "游戏交易", "装备交易", "账号买卖", "代练",

        // 其他常见
        "转账", "汇款", "验证码", "密码", "中奖"
    )

    // 高风险关键词
    private val highRiskKeywords = listOf(
        "安全账户", "转账汇款", "验证码",
        "账户异常", "资金冻结", "涉嫌洗钱",
        "通缉令", "中奖", "密码", "网银升级",
        "医保卡异常", "社保卡停用", "无抵押贷款",
        "裸聊", "刷单", "博彩", "虚拟货币"
    )

    // 常见诈骗模板正则
    private val scamPatterns = listOf(
        // 银行类
        Regex("您好，您的.{0,10}(银行账户|银行卡|账户).{0,20}(异常|冻结|过期)"),
        Regex("您的.{0,5}(银行|账户).{0,10}存在风险"),
        Regex("(银行|账户)安全验证"),

        // 中奖类
        Regex("恭喜您.{0,10}(获得|中奖)"),
        Regex("(一等奖|二等奖|特等奖).{0,20}(价值|奖金|奖品)"),
        Regex("(免费|扫码).{0,10}(领取|获得)"),

        // 公检法类
        Regex("(涉嫌|涉案).{0,10}(洗钱|诈骗|犯罪)"),
        Regex("(公安局|检察院|法院).{0,10}(通知|文书)"),
        Regex("(通缉|追逃).{0,10}(令|对象)"),

        // 快递类
        Regex("(快递|包裹).{0,10}(异常|被扣|违禁)"),
        Regex("(取件码|签收).{0,10}(异常|点击)"),

        // 钓鱼类
        Regex("(点击|登录|认证).{0,5}(链接|网址|网站)"),
        Regex("(http|https|www)\\S{5,}"),  // 检测长链接

        // 贷款类
        Regex("(无抵押|低息|快速).{0,10}(贷款|借款)"),
        Regex("(额度|信用).{0,10}(提升|评估|认证)"),

        // 熟人诈骗类
        Regex("(急需|立刻).{0,5}(转账|汇款|付款)"),
        Regex("(在医院|出事了|住院).{0,10}(需要|借)"),

        // 刷单类
        Regex("(刷单|做任务).{0,10}(返利|佣金|工资)"),
        Regex("(关注|点赞|好评).{0,10}(返现|佣金)")
    )

    // 常见诈骗电话号码特征
    private val suspiciousPhonePatterns = listOf(
        "+1-", "+2", "+8",  // 国外号码
        "400-", "4000",     // 400电话
        "170", "171",       // 虚拟运营商
        "00-", "+00"        // 境外电话
    )

    // 可疑账号格式
    private val suspiciousAccountPatterns = listOf(
        Regex("\\d{6,}@\\w+\\.\\w+"),  // 长数字邮箱
        Regex("https?://[^\\s]{30,}")   // 超长链接
    )

    /**
     * 检测文本是否为诈骗信息
     */
    fun checkText(text: String): CheckResult {
        val id = UUID.randomUUID().toString()
        val riskKeywords = mutableListOf<String>()
        val riskReasons = mutableListOf<String>()

        // 1. 检测高风险关键词
        for (keyword in highRiskKeywords) {
            if (text.contains(keyword)) {
                riskKeywords.add(keyword)
                riskReasons.add("包含高风险词：$keyword")
            }
        }

        // 2. 检测诈骗模板正则
        for (pattern in scamPatterns) {
            if (pattern.containsMatchIn(text)) {
                riskReasons.add("匹配可疑模板")
                break
            }
        }

        // 3. 检测可疑电话号码
        for (prefix in suspiciousPhonePatterns) {
            if (text.contains(prefix)) {
                riskReasons.add("包含可疑电话号码特征")
                break
            }
        }

        // 4. 检测可疑账号/链接
        for (pattern in suspiciousAccountPatterns) {
            if (pattern.containsMatchIn(text)) {
                riskReasons.add("包含可疑账号或链接")
                break
            }
        }

        // 5. 检测特殊字符占比（乱码检测）
        val specialCharRatio = calculateSpecialCharRatio(text)
        if (specialCharRatio > 0.3) {
            riskReasons.add("包含异常特殊字符")
        }

        // 6. 检测重复字符（可能的人工痕迹）
        if (hasExcessiveRepeatingChars(text)) {
            riskReasons.add("包含异常重复字符")
        }

        // 7. 检查普通诈骗关键词
        for (keyword in scamKeywords) {
            if (text.contains(keyword) && !riskKeywords.contains(keyword)) {
                riskKeywords.add(keyword)
            }
        }

        // 8. 综合判断风险等级
        val riskLevel = calculateRiskLevel(riskKeywords, riskReasons)

        // 生成安全提示
        val safetyTips = generateSafetyTips(riskLevel, riskKeywords, riskReasons)

        return CheckResult(
            id = id,
            content = text,
            riskLevel = riskLevel,
            riskKeywords = riskKeywords.distinct(),
            safetyTips = safetyTips
        )
    }

    /**
     * 计算特殊字符占比
     */
    private fun calculateSpecialCharRatio(text: String): Float {
        if (text.isEmpty()) return 0f
        val specialChars = text.count { !it.isLetterOrDigit() && !it.isWhitespace() }
        return specialChars.toFloat() / text.length
    }

    /**
     * 检测是否有过多重复字符
     */
    private fun hasExcessiveRepeatingChars(text: String): Boolean {
        // 检测连续4个以上相同字符
        for (i in 0 until text.length - 4) {
            val char = text[i]
            var count = 1
            for (j in i + 1 until text.length) {
                if (text[j] == char) count++ else break
                if (count >= 4) return true
            }
        }
        return false
    }

    /**
     * 计算风险等级
     */
    private fun calculateRiskLevel(
        keywords: List<String>,
        reasons: List<String>
    ): RiskLevel {
        // 高风险关键词 >= 2
        val highRiskCount = keywords.count { keyword ->
            highRiskKeywords.contains(keyword)
        }

        return when {
            highRiskCount >= 2 -> RiskLevel.HIGH_RISK
            highRiskCount == 1 && reasons.size >= 2 -> RiskLevel.HIGH_RISK
            highRiskCount == 1 || reasons.size >= 2 -> RiskLevel.SUSPICIOUS
            keywords.size >= 2 -> RiskLevel.SUSPICIOUS
            keywords.size == 1 -> RiskLevel.SUSPICIOUS
            else -> RiskLevel.SAFE
        }
    }

    /**
     * 生成安全提示
     */
    private fun generateSafetyTips(
        riskLevel: RiskLevel,
        keywords: List<String>,
        reasons: List<String>
    ): String {
        val baseTips = when (riskLevel) {
            RiskLevel.SAFE -> "该信息目前未检测到明显的诈骗特征，但请保持警惕。"
            RiskLevel.SUSPICIOUS -> "该信息包含可疑内容，建议谨慎处理。"
            RiskLevel.HIGH_RISK -> "警告！该信息疑似诈骗信息，请不要相信、不要回复、不要转账。"
        }

        val additionalTips = when (riskLevel) {
            RiskLevel.SAFE -> ""
            RiskLevel.SUSPICIOUS -> "\n\n⚠️ 检测到以下可疑特征：\n${reasons.joinToString("\n") { "• $it" }}"
            RiskLevel.HIGH_RISK -> "\n\n⚠️ 高风险警告：\n${(reasons + keywords.take(3).map { "• $it" }).joinToString("\n")}\n\n如有疑问，请拨打110报警。"
        }

        return baseTips + additionalTips
    }

    /**
     * 检测是否为诈骗短信模板
     */
    fun isScamTemplate(text: String): Boolean {
        var matchCount = 0
        for (pattern in scamPatterns) {
            if (pattern.containsMatchIn(text)) {
                matchCount++
            }
        }
        return matchCount >= 1
    }
}