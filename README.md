# ChatBot 的 Java 版本

### 接入流程

点击[这里](https://github.com/chatrbot/chatbot)查看

### 运行示例

1. 下载代码

   ```html
   git clone https://codechina.csdn.net/qq_38558119/chatbot_java.git
   ```

2. 安装相关依赖库

   使用maven下载依赖

3. 替换 application.yml中 <u>wstoken</u> 的值([如何获取我的 token](https://github.com/chatrbot/chatbot#faq))

4. 然后运行ChatbotApplication类main方法.

### 编写plugin

##### 	有两种plugin类型

​	`GroupBotEvent`:群内非消息事件

> ```
> 非人为发送的消息:机器人入群,机器人退群,用户加群,用户退群.
> 1.编写该类型的plugin需继承抽象类:GroupEventProcess,并且对于继承类加上该类型注解:@EventPlugin,并将该类加入spring容器中
> 2.实现process方法,该方法会将事件类型包装成 GroupBotEvent 对象,里面有事件的信息.
> ```

​	`UserMessage`:用户消息事件

> ```
> 人为产生的消息(群内消息或者私聊消息):全部的消息行为
> 1.编写该类型的plugin需继承抽象类:MessageProcess,并且对于继承类加上该类型注解:@MsgPlugin,并将该类加入spring容器中
> 2.实现process方法,该方法会将事件类型包装成 UserMessage 对象,里面有事件的信息.
> ```

#####     消息经过代码逻辑处理后的消息回复

> ```
> 1.使用抽象类中 sender() 方法的返回对象,包含了发送文本,图片,音频,视频,表情等http调用方法,具体使用可参看sample包下的示例
> ```

##### 	项目使用工具

> ```
> 基于springboot2.x,方便后期集成其他框架
> 目前使用工具:
> WebSocket => Netty
> Http调用 => Forest
> Json格式化 => Jackson
> Xml格式化 => Dom4j
> 日志记录 => Log4j
> ```

ps: [Forest文档](http://forest.dtflyx.com/)

##### Linux 下使用
>```
> 需要修改log4j配置文件中对于的日志存放地址
>```




