package com.qd.p2p.sina.pay.param;

import com.google.common.collect.Maps;
import com.qd.p2p.sina.pay.IRequestParam;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 提供请求查询参数的抽象类
 *
 * @author linya 2015-11-25
 */
public abstract class AbstractRequestParam implements IRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = -3815093340600743746L;

    @Param(enabled = false)
    private static final Logger log = Logger.getLogger(AbstractRequestParam.class);

    @Param(value = "service")
    private String serviceName;

    private boolean isMember;

    @Override
    public String getServiceName() {
        return serviceName;
    }

    public AbstractRequestParam setServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @Override
    public boolean isMember() {
        return isMember;
    }

    public AbstractRequestParam setIsMember(boolean isMember) {
        this.isMember = isMember;
        return this;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = Maps.newHashMap();

        // 如果没有设置serviceNo，尝试从注解中获取
        String serviceName = getServiceName();
        if (serviceName == null) {
            Strategy strategyAnnotation = this.getClass().getAnnotation(Strategy.class);
            if (strategyAnnotation != null) {
                this.setServiceName(strategyAnnotation.value().getServiceEnName());
                this.setIsMember(strategyAnnotation.isMember());
            }
        }

        // 解析属性到Map
        for (Class<?> clazz = this.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            if (IRequestParam.class.equals(clazz)) {
                break;
            }
            map.putAll(toMap(clazz));
        }
        return map;
    }

    private Map<String, Object> toMap(Class<?> clazz) {
        Map<String, Object> map = new HashMap<String, Object>();
        Field currentFiled = null;
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                currentFiled = f;
                Param paramAnnotation = f.getAnnotation(Param.class);
                String param = null;
                if (paramAnnotation != null) {
                    if (paramAnnotation.enabled()) {
                        param = paramAnnotation.value();
                        if(StringUtils.isBlank(param)){
                        	param = f.getName();
                        }
                    }
                } else {
                    param = f.getName();
                }
                if (param != null) {
                    PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(clazz, f.getName());
                    if (pd == null) continue;

                    Method method = pd.getReadMethod();
                    if (method == null) continue; // 非get方法不参加签名及请求

                    Object value = method.invoke(this);
                    //过滤掉空值
                    if (value == null ||
                            (value instanceof String && StringUtils.isEmpty((String) value))) {
                        continue;
                    }
                    map.put(param, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("创建请求参数发生错误:" + clazz.getName() + ":" + currentFiled.getName(), e);
        }

        return map;
    }

    @Override
    public boolean checkParameter() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields) {
            Param paramAnnotation = f.getAnnotation(Param.class);
            if (paramAnnotation != null && paramAnnotation.required()) {
                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(this.getClass(), f.getName());
                if (pd == null) continue;

                Method method = pd.getReadMethod();
                if (method == null) continue;

                Object value = null;
                try {
                    value = method.invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (value == null || StringUtils.isEmpty(value.toString())) {
                    throw new IllegalArgumentException(String.format(" parameter [%s] is required ", f.getName()));
                }
            }
        }

        // 约束check
        if (!restrictCheck()) {
            throw new IllegalArgumentException(" restrict parameter failure ");
        }
        // check strategy
        Strategy strategyAnnotation = this.getClass().getAnnotation(Strategy.class);
        if (strategyAnnotation == null) {
            throw new IllegalArgumentException(" service_strategy is required ");
        }
        return true;
    }

    /**
     * 约束性判断，子类实现
     *
     * @return
     */
    protected boolean restrictCheck() {
        return true;
    }
}
