package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.CertType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

/**
 * 设置实名信息
 */
@Strategy(value = ServiceStrategy.SET_REAL_NAME,isMember = true)
public class SetRealNameParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 3127282395211875302L;

    //用户标识信息，商户系统用户ID(字母或数字)
    @Param(value = "identity_id", required = true)
    private String identityId;

    //用户标识类型，ID的类型，目前只包括UID
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;

    //真实姓名，密文，使用新浪支付RSA公钥加密。明文长度：50
    @Param(value = "real_name", required = true)
    private String realName;

    //证件类型，目前只支持身份证
    @Param(value = "cert_type",required = true)
    private CertType certType;

    //证件号码，密文，使用新浪支付RSA公钥加密。明文长度：30
    @Param(value = "cert_no", required = true)
    private String certNo;

    //是否认证， 是否需要钱包做实名认证，值为Y/N，默认Y。暂不开放外部自助实名认证。
    @Param(value = "need_confirm")
    private String needConfirm;

    //扩展信息，业务扩展信息    参数格式：参数名1^参数值1|参数名2^参数值2|……
    @Param(value = "extend_param")
    private String extendParam;

    public String getIdentityId() {
        return identityId;
    }

    public SetRealNameParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public SetRealNameParam setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public SetRealNameParam setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public CertType getCertType() {
        return certType;
    }

    public SetRealNameParam setCertType(CertType certType) {
        this.certType = certType;
        return this;
    }

    public String getCertNo() {
        return certNo;
    }

    public SetRealNameParam setCertNo(String certNo) {
        this.certNo = certNo;
        return this;
    }

    public String getNeedConfirm() {
        return needConfirm;
    }

    public SetRealNameParam setNeedConfirm(String needConfirm) {
        this.needConfirm = needConfirm;
        return this;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public SetRealNameParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }
}