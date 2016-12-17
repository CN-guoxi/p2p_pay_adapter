package com.qd.p2p.baofoo.enums;

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

    /**
     * 传输时参数值
     */
    String value() default "";

    /**
     * 是否将参数作为加密报文
     */
    boolean enabled() default true;

    /**
     * 参数是否必须
     */
    boolean required() default false;

    /**
     * 参数类型
     */
    ParamType type() default ParamType.STRING;

    /**
     * 如果ParamType是ENTITY, LIST，则需要指定实体对象中的类型
     */
    Class<?> entity() default Object.class;
    
}