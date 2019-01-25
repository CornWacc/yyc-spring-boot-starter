package com.corn.boot.annotations;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo-admin.xml"}) //扫描dubbo配置文件
public @interface Runner {

    String port() default "8080";

    String env() default "dev";

}
