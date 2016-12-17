package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;

/**
 * 提交查询的响应基类
 *
 */
public class QueryVerifyResponse extends AbstractResponse {

    @Param(enabled = false)
    private static final long serialVersionUID = 0x2b6656c4f6efc3e6L;

    @Param("verify_entity")
    private String verifyEntity;

    @Param("verify_time")
    private String verifyTime;

    @Param("extend_param")
    private String extendParam;

    public String getVerifyEntity() {
        return verifyEntity;
    }

    public void setVerifyEntity(String verifyEntity) {
        this.verifyEntity = verifyEntity;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }
}
