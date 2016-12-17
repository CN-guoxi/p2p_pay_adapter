package com.qd.p2p.baofoo.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.qd.p2p.baofoo.ServiceStrategy;

/**
 * 服务策略
 * value 指定策略名称
 *
 * @author linya 2015-11-25
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Strategy {

    /**
     * 服务策略类型
     * @return
     */
    ServiceStrategy value();
    
    /**
     * 参数是否进行aes加密
     * @return
     */
    boolean aesEncrypt() default false;
    
}