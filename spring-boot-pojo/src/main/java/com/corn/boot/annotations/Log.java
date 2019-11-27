package com.corn.boot.annotations;

import java.lang.annotation.*;


/**
 * @author yyc
 * @apiNote 日志环绕通知注解
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface Log {

    String name() default "";

    String version() default "1.0.0";

    String des() default "";

    boolean showQuestTime() default false;
}
