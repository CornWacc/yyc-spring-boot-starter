package com.corn.boot.annotations;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootApplication
public @interface Runner {

    String port() default "8080";

    String active() default "dev";

    /**
     * 这是扫描mapping的路径
     * */
    String mappingPath() default "/mapping/**.xml";
}
