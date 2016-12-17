package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;
import com.qd.p2p.sina.pay.enums.VerifyType;

/**
 * 绑定认证信息
 * @author linya 2015-12-24
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.BINDING_VERIFY,isMember=true)
public class BindingVerifyParam extends AbstractRequestParam {

    
    //用户标识信息，商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，目前只包括UID
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;

    //认证类型
    @Param(value = "verify_type", required = true)
    private VerifyType verifyType;
    
    //认证内容
    @Param(value = "verify_entity", required = true)
    private String verifyEntity;

    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public BindingVerifyParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public BindingVerifyParam setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

    public VerifyType getVerifyType() {
		return verifyType;
	}

	public BindingVerifyParam setVerifyType(VerifyType verifyType) {
		this.verifyType = verifyType;
		return this;
	}

	public String getVerifyEntity() {
		return verifyEntity;
	}

	public BindingVerifyParam setVerifyEntity(String verifyEntity) {
		this.verifyEntity = verifyEntity;
		return this;
	}

	public String getExtendParam() {
        return extendParam;
    }

    public BindingVerifyParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}