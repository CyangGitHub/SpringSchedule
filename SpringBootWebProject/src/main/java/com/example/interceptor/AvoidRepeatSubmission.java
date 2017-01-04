package com.example.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by admin on 2016/11/28.
 * 防重复提交注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidRepeatSubmission {
    boolean isSaveToken() default false;
    boolean isRemoveToken() default false;
}
