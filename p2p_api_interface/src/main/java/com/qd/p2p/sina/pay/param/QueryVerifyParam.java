package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 查询认证信息
 */
@Strategy(value=ServiceStrategy.QUERY_VERIFY,isMember=true)
public class QueryVerifyParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0x2b6656c4f6efc3e6L;

    /**用户标识信息*/
    @Param(value = "identity_id", required = true)
    private String identityId;

    /**用户标识类型*/
    @Param(value = "identity_type", required = true)
    private String identityType;

    /**认证类型*/
    @Param(value = "verify_type", required = true)
    private String verifyType;

    /**是否掩码*/
    @Param(value = "is_mask")
    private String isMask;

    /**扩展信息*/
    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public QueryVerifyParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public String getIdentityType() {
        return identityType;
    }

    public QueryVerifyParam setIdentityType(String identityType) {
        this.identityType = identityType;
        return this;
    }

    public String getVerifyType() {
        return verifyType;
    }

    public QueryVerifyParam setVerifyType(String verifyType) {
        this.verifyType = verifyType;
        return this;
    }

    public String getIsMask() {
        return isMask;
    }

    public QueryVerifyParam setIsMask(String isMask) {
        this.isMask = isMask;
        return this;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public QueryVerifyParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}