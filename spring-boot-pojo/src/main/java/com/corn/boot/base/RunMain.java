package com.corn.boot.base;


import com.corn.boot.annotations.Runner;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Annotation;

/**
 * @author yyc
 * @apiNote 主启动类
 * ps:1.为解决启动项目不用手动再去启动zk的问题
 */
public class RunMain{

    private static final Logger log = LoggerFactory.getLogger(RunMain.class);

    public static void springRun(Class classz , String... args){
        long startTime = System.currentTimeMillis();
        try{
            Annotation annotation = classz.getAnnotation(Runner.class);
            Runner runner = (Runner) annotation;
            Apps.setServerPort(runner.port());
            Apps.setSpringProfileActive(runner.active());
            SpringApplication.run(classz,args);
            long endTime = System.currentTimeMillis();
            log.info("********** 项目启动成功:{},耗时:{},端口号:{},配置:{} **********", System.getProperty("os.name"), endTime - startTime,runner.port(),runner.active());
        }catch (Exception e){
            System.out.println("启动错误");
        }
    }
    
}

