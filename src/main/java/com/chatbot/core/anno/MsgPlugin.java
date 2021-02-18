package com.chatbot.core.anno;

import java.lang.annotation.*;

/**
 * 用户产生消息处理注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MsgPlugin {
    boolean open() default true;
}
