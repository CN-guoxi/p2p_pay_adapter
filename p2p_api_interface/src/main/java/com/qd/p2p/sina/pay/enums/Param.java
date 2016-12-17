package com.qd.p2p.sina.pay.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义RequestParam的请求参数
 * enabled设置请求时是否需要字段参数，value指定参数名称，type指定参数类型(解析响应Response时用到)
 *
 * @author linya 2015-11-25
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    String value() default "";

    boolean enabled() default true;

    ParamType type() default ParamType.STRING;

    boolean required() default false;

}