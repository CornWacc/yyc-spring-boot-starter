package com.corn.boot.annotations;


import java.lang.annotation.*;

@Target(ElementType.TYPE) //运用地方
@Retention(RetentionPolicy.RUNTIME) //存活时间
@Inherited //继承
@Documented //文档
public @interface DoTranscation {
}
