package com.corn.boot.configuration;


import com.corn.boot.aop.LogAop;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * @author yyc
 * @apiNote 默认基础配置类
 * */
@Configuration
@Import(LogAop.class)
public class BaseAutoConfiguration {
}
