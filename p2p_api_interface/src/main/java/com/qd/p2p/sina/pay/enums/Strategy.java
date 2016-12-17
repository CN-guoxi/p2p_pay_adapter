package com.qd.p2p.sina.pay.enums;

import com.qd.p2p.sina.pay.ServiceStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务策略
 * value 指定策略名称
 *
 * @author linya 2015-11-25
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Strategy {

    ServiceStrategy value();

    boolean isMember() default false;
}