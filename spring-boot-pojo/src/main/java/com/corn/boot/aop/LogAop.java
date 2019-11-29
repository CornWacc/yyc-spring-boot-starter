package com.corn.boot.aop;


import com.corn.boot.annotations.Log;
import com.corn.boot.base.LogClientBase;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAop extends LogClientBase {

    @Pointcut("@annotation(com.corn.boot.annotations.Log)")
    public void pointCut() {
    }

    @Around(value = "pointCut() && @annotation(log)")
    public Object aroundMethod(ProceedingJoinPoint point, Log log) {

        this.log.info("{}开始执行,入参:{}", log.des(), new Gson().toJson(point.getArgs()));
        long startTime = System.currentTimeMillis();

        Object o = null;
        try {
            o = point.proceed();
            this.log.info("{}执行结束,出参:{}", log.des(), new Gson().toJson(o));

        } catch (Throwable throwable) {
            this.log.info("接口执行异常");
            throwable.printStackTrace();
        }

        if (log.showQuestTime()) {
            long endTime = System.currentTimeMillis();
            this.log.info("接口测试完成:{},版本{},总用时{}", log.name(), log.version(), endTime - startTime);
        }

        return o;
    }
}
