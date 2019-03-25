package com.corn.boot.base;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author yyc
 * @apiNote 基础接口层
 */
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    protected String getRequestUrlName(String methodName) {
        Method[] methods = getClass().getMethods();
        String resMethod = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof PostMapping) {
                        PostMapping postMapping = (PostMapping) annotation;
                        resMethod = postMapping.value()[0];
                    } else if (annotation instanceof GetMapping) {
                        GetMapping getMapping = (GetMapping) annotation;
                        resMethod = getMapping.value()[0];
                    }
                }
            }
        }
        return resMethod;
    }

}
