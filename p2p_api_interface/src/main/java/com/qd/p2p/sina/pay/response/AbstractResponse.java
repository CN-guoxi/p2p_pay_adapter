package com.qd.p2p.sina.pay.response;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.BeanUtils;

import com.qd.p2p.sina.pay.IResponse;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.enums.ResponseCode;

/**
 * 提交查询的响应基类
 *
 * @author linya 2015-11-30
 */
public abstract class AbstractResponse implements IResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = -6877570600621626738L;
    
    private static final ResponseCode[] RESPONSE_SUCCESS_CODE = new ResponseCode[]{
    	ResponseCode.APPLY_SUCCESS, ResponseCode.MERCHANT_SUBMIT_AUDIT_SUCCESS,
    	ResponseCode.AUDIT_SUCCESS, ResponseCode.AUDIT_PROCESSING
    };

    @Param(value = "response_time", type = ParamType.LONG)
    private Long responseTime;

    @Param(value = "partner_id", type = ParamType.LONG)
    private Long partnerId;

    @Param("_input_charset")
    String inputCharset;

    String sign;

    @Param("sign_type")
    String signType;

    @Param("sign_version")
    String signVersion;

    @Param("response_code")
    private String responseCode;

    @Param("response_message")
    private String responseMessage;

    private String memo;

    @Param("req_status")
    String reqStatus;

    @Param("req_error_message")
    String reqErrorMessage;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignVersion() {
        return signVersion;
    }

    public void setSignVersion(String signVersion) {
        this.signVersion = signVersion;
    }

    public Long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getReqErrorMessage() {
        return reqErrorMessage;
    }

    public void setReqErrorMessage(String reqErrorMessage) {
        this.reqErrorMessage = reqErrorMessage;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
	public boolean success() {
    	for (ResponseCode code: RESPONSE_SUCCESS_CODE) {
			if(code.name().equals(responseCode)){
				return true;
			}
		}
		return false;
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
                        if(pd == null) continue;
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
}
