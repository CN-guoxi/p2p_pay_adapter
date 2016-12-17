package com.qd.p2p.baofoo.response;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;

import com.qd.p2p.adapter.enums.ResponseStatus;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.enums.Param;
import com.qd.p2p.baofoo.enums.ResponseCode;

/**
 * 提交查询的响应基类
 *
 * @author linya 2015-11-30
 */
public abstract class AbstractResponse implements IResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = -6877570600621626738L;

    /**
     * 应答码
     */
    private String code;

    /**
     * 请求参数数据密文
     */
    private String sign;

    /**
     * 结果信息
     */
    private String msg;
    
    /**
     * 请求处理状态
     */
    private ResponseStatus status;

    @Override
    public boolean success() {
        return ResponseCode.CSD000.name().equalsIgnoreCase(code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setStatus(ResponseStatus responseStatus) {
        if (success()) {
            status = ResponseStatus.SUCCESS;
        } else {
            status = ResponseStatus.FAILURE;
        }
    }

    public ResponseStatus getStatus() {
        setStatus(null);
        return status;
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        try {
            for (Class<?> clazz = this.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
                if (IResponse.class.isAssignableFrom(clazz)) {
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field f : fields) {
                        PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(this.getClass(), f.getName());
                        if (pd == null) continue;
                        Method method = pd.getReadMethod();
                        if (method != null) {
                            Object value = method.invoke(this);
                            sb.append(f.getName() + "=" + value + ",");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("}");
        return sb.toString();
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
