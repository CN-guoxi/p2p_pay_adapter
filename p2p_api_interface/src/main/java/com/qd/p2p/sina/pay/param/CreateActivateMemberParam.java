package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.MemberType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 创建激活会员
 * @author linya 2015-12-24
 */
@Strategy(value=ServiceStrategy.CREATE_ACTIVATE_MEMBER,isMember=true)
public class CreateActivateMemberParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0255462554236673741746L;
    
    //用户标识信息，商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，目前只包括UID
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;

    //会员类型, 会员类型，详见附录，默认个人
    @Param(value = "member_type")
    private MemberType memberType;

    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public CreateActivateMemberParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public CreateActivateMemberParam setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public CreateActivateMemberParam setMemberType(MemberType memberType) {
        this.memberType = memberType;
        return this;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public CreateActivateMemberParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}