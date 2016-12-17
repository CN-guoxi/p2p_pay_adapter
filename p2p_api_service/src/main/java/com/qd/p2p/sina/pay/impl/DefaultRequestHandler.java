package com.qd.p2p.sina.pay.impl;

import com.qd.p2p.sina.pay.*;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DefaultRequestHandler implements IRequestHandler {

    private static final Logger log = Logger.getLogger(DefaultRequestHandler.class);
    
    private final IParamTypeParser primitiveParser = new PrimitiveParamTypeParser();
    
    private final IParamTypeParser entityResponseParser = new DefaultEntityParamTypeParser();

    public <T extends IResponse> T submit(IRequestParam queryParam, Class<T> responseClass) {
        T response = null;
        try {
            Map<String, Object> responseMap = HttpPostProcess.request(queryParam);
            // 将响应数据封装成Response实例
            response = responseClass.newInstance();
            populateResponse(response, responseMap);
            log.info("++++ response " + response.getClass().getSimpleName() + ":" + response.toString());
        } catch (Exception e) {
        	log.error("++++ request is error: " + ", serviceNo is: " + queryParam.getServiceName(), e);
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 构建响应Response对象
     *
     * @param response
     * @param responseMap
     */
    private void populateResponse(IResponse response, Map<String, Object> responseMap) {
        if (responseMap == null) {
            return;
        }
        for (Class<?> clazz = response.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            if (IResponse.class.isAssignableFrom(clazz)) {
                populateResponse(response, clazz, responseMap);
            }
        }
    }

    private void populateResponse(IResponse response, Class<?> clazz, Map<String, Object> responseMap) {
        Field currentFiled = null;
        try {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                currentFiled = f;
                Param paramAnnotation = f.getAnnotation(Param.class);
                String param;
                ParamType paramType;
                if (paramAnnotation != null) {
                    if (!paramAnnotation.enabled()) {
                        continue;
                    }
                    param = paramAnnotation.value();
                    paramType = paramAnnotation.type();
                } else {
                    param = f.getName();
                    paramType = ParamType.STRING;
                }

                PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(clazz, f.getName());
                if (pd == null) {
                    continue;
                }

                Method method = pd.getWriteMethod();
                if (method == null) {
                    continue;
                }

                //处理多值匹配的情况
                String[] keys = param.split(",");
                for (String key : keys) {
                    Object oldVal = responseMap.get(key.trim());
                    Object value = convertType(paramType, oldVal, response);
                    method.invoke(response, value);
                    if (oldVal != null) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析响应发生错误:" + clazz.getName() + ":" + currentFiled.getName(), e);
        }
    }

    /**
     * 参数类型处理
     * @param paramType
     * @param value
     * @return
     */
    private Object convertType(ParamType paramType, Object value, IResponse response) {
    	if(primitiveParser.supports(paramType)){
    		return primitiveParser.parse(paramType, value, null);
    	}else if(entityResponseParser.supports(paramType)){
    		return entityResponseParser.parse(paramType, value, response);
    	}
    	return null;
    }
	
}
