# 安全助手 APP (SafetyAssistant)

## 项目简介

数字安全与反诈助手 APP - 一款面向全民的 Android 反电信诈骗与数字安全防护应用。

## 功能特性

### 核心功能
1. **数字安全直播** - 网络安全科普直播和视频课程
2. **反诈文本检测** - 智能检测短信、聊天记录中的诈骗风险
3. **二维码安全扫描** - 扫描二维码并分析安全性
4. **地图导航** - 查找附近派出所、银行、营业厅
5. **安全模式** - 一键求助、位置共享、紧急联系人
6. **语音助手** - 语音指令控制（唤醒词：安全助手）
7. **历史记录** - 查看检测、扫码、求救、学习记录
8. **反诈小游戏** - 通过游戏学习反诈知识

### 技术架构
- **开发语言**: Kotlin
- **最低 SDK**: API 24 (Android 7.0)
- **目标 SDK**: API 34 (Android 14)
- **架构模式**: MVVM

## 项目结构

```
SafetyAssistant/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/safetyassistant/
│   │   │   ├── activities/          # Activity 类
│   │   │   ├── adapters/            # RecyclerView 适配器
│   │   │   ├── models/              # 数据模型
│   │   │   ├── services/           # 服务类
│   │   │   ├── utils/               # 工具类
│   │   │   └── SafetyAssistantApp.kt # Application 类
│   │   ├── res/
│   │   │   ├── layout/              # 布局文件
│   │   │   ├── values/              # 资源文件
│   │   │   └── drawable/            # 图片资源
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle                     # 项目级 build.gradle
├── settings.gradle
├── gradle.properties
└── gradle/wrapper/
```

## 依赖库

- **高德地图 SDK** - 定位和导航功能
- **ZXing** - 二维码扫描
- **百度语音 SDK** - 语音识别和合成
- **OkHttp** - 网络请求
- **Gson** - JSON 解析
- **Glide** - 图片加载
- **Material Components** - UI 组件

## 配置说明

### 1. 高德地图配置
在 `AndroidManifest.xml` 中配置高德地图 KEY：
```xml
<meta-data
    android:name="com.amap.api.v2.apikey"
    android:value="您的KEY" />
```

### 2. 百度语音配置
在 `SafetyAssistantApp.kt` 中配置百度语音 APP ID 和 APP KEY。

## 使用说明

1. **克隆项目**
2. **打开项目** - 使用 Android Studio 打开项目
3. **同步 Gradle** - 等待依赖下载完成
4. **配置 SDK Key** - 添加高德地图和百度语音的 Key
5. **运行项目** - 连接设备或启动模拟器运行

## 权限说明

- INTERNET - 网络权限
- CAMERA - 摄像头权限（二维码扫描）
- ACCESS_FINE_LOCATION - 精确定位权限
- RECORD_AUDIO - 麦克风权限（语音助手）
- CALL_PHONE - 拨打电话权限
- SEND_SMS - 发送短信权限

## 开发建议

1. **模块化开发** - 每个功能模块独立，便于维护
2. **权限检查** - 使用 `PermissionUtils` 工具类检查权限
3. **数据存储** - 使用 `DataManager` 管理本地数据
4. **UI 设计** - 采用 Material Design 设计规范

## 版本信息

- 版本号: 1.0
- 开发时间: 2026年

## 作者

学生姓名：赵易
学号：302023315029
指导老师：[待填写]
