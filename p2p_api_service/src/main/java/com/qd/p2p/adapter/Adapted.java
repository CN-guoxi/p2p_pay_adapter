package com.qd.p2p.adapter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Adapted {
   
	/**
     * 支付平台
     * @return
     */
    AdaptePlatform value();
    
    /**
     * 被适配的类型
     * @return
     */
    Class<?>[] adaptedClass();
    
}