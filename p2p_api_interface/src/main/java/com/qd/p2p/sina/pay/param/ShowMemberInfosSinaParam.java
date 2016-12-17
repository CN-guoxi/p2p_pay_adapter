package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * sina页面展示用户信息
 */
@Strategy(value = ServiceStrategy.SHOW_MEMBER_INFOS_SINA,isMember = true)
public class ShowMemberInfosSinaParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0255462554236673741746L;

    /**用户标识信息*/
    @Param(value = "identity_id", required = true)
    private String identityId;

    /**用户标识类型*/
    @Param(value = "identity_type", required = true)
    private String identityType;

    /**扩展信息*/
    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }
}