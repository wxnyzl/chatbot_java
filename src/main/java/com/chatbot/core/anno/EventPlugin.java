package com.chatbot.core.anno;

import java.lang.annotation.*;

/**
 * 群事件消息处理注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventPlugin {
    boolean open() default true;
}
