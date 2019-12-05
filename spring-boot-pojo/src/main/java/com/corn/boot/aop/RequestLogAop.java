package com.corn.boot.aop;


import com.corn.boot.annotations.RequestLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequestLogAop {

    private static final Logger log = LoggerFactory.getLogger(RequestLogAop.class);

    @Pointcut("@annotation(com.corn.boot.annotations.RequestLog)")
    public void pointCut(){}

    @Before("pointCut() && @annotation(requestLog)")
    public void cut(JoinPoint joinPoint, RequestLog requestLog){

        Object[] objects = joinPoint.getArgs();
        log.info("客户端请求方法{},入参:{}",joinPoint.getSignature().getName(),requestLog.value());
    }
}
