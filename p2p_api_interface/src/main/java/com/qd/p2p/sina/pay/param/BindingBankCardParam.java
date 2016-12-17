package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.BankCode;
import com.qd.p2p.sina.pay.enums.CardAttribute;
import com.qd.p2p.sina.pay.enums.CardType;
import com.qd.p2p.sina.pay.enums.CertType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;
import com.qd.p2p.sina.pay.enums.VerifyMode;

import org.apache.commons.lang3.StringUtils;

/**
 * 绑定银行卡请求参数
 * @author linya  2015-12-22
 */
@SuppressWarnings("serial")
@Strategy(value = ServiceStrategy.BINDING_BANK_CARD, isMember = true)
public class BindingBankCardParam extends AbstractRequestParam {

	//绑卡请求号(非空);商户网站交易订单号，商户内部保证唯一，例如：20131105154925
    @Param(value = "request_no", required = true)
    private String requestNo;            

    //用户标识信息(非空);商户系统用户ID(字母或数字),例如：2000011212
    @Param(value = "identity_id", required = true)
    private String identityId;            

    //ID的类型(非空);目前只包括UID，例如：UID
    @Param(value = "identity_type", required = true)
    private IdentityType identityType;        

   //银行编号(非空);ICBC,CCB等，例如：ICBC
    @Param(value = "bank_code", required = true)
    private BankCode bankCode;            

   //银行卡号(非空);密文，使用新浪支付RSA公钥加密。明文长度：30
    @Param(value = "bank_account_no", required = true)
    private String bankAccountNo;        

    //户名(可空);密文，使用新浪支付RSA公钥加密。明文长度：50。空则使用实名认证时实名信息
    @Param(value ="account_name")
    private String accountName;            

    //卡类型(非空);DEBIT(借记卡),CREDIT(信用卡)
    @Param(value="card_type", required = true)
    private CardType cardType;            

    //卡属性(非空);
    @Param(value="card_attribute", required = true)
    private CardAttribute cardAttribute;        

    //证件类型(非空);目前只支持身份证，为空则使用实名认证中的证件信息
    @Param(value="cert_type", required = true)
    private CertType certType;            

    //证件号码 (可空);密文，使用新浪支付RSA公钥加密。明文长度：30。空则使用实名认证时实名信息
    @Param("cert_no")
    private String certNo;                

    //银行预留手机号(可空);密文，使用新浪支付RSA公钥加密。明文长度：20。如认证方式不为空，则要求此信息也不能为空。
    @Param("phone_no")
    private String phoneNo;                

    //有效期;密文，使用新浪支付RSA公钥加密。明文长度：10；信用卡专用，有效期(10/13)，（月份/年份）
    @Param("validity_period")
    private String validityPeriod;        

    //CVV2;密文，使用新浪支付RSA公钥加密。明文长度：10；信用卡专用
    @Param("verification_value")
    private String verificationValue;    

    //省份(非空)；例如：浙江省
    private String province;            

    //城市(非空)；例如：杭州市
    private String city;                

    //支行名称(可空);银行支行名称；例如：中国农业银行深圳南山支行
    @Param("bank_branch")
    private String bankBranch;            

    //认证方式(可空);银行卡真实性认证方式;例如：SIGN
    @Param("verify_mode")
    private VerifyMode verifyMode;            
    
    //扩展信息(可控);业务扩展信息，参数格式：参数名1^参数值1|参数名2^参数值2;例如：test^true|notify_type^sync
    @Param("extend_param")
    private String extendParam;           

    public String getRequestNo() {
        return requestNo;
    }

    public BindingBankCardParam setRequestNo(String requestNo) {
        this.requestNo = requestNo;
        return this;
    }

    public String getIdentityId() {
        return identityId;
    }

    public BindingBankCardParam setIdentityId(String identityId) {
        this.identityId = identityId;
        return this;
    }

    public IdentityType getIdentityType() {
		return identityType;
	}

	public BindingBankCardParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public BankCode getBankCode() {
		return bankCode;
	}

	public BindingBankCardParam setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
		return this;
	}

	public String getBankAccountNo() {
        return bankAccountNo;
    }

    public BindingBankCardParam setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public BindingBankCardParam setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public CardType getCardType() {
		return cardType;
	}

	public BindingBankCardParam setCardType(CardType cardType) {
		this.cardType = cardType;
		return this;
	}

	public CardAttribute getCardAttribute() {
		return cardAttribute;
	}

	public BindingBankCardParam setCardAttribute(CardAttribute cardAttribute) {
		this.cardAttribute = cardAttribute;
		return this;
	}

	public CertType getCertType() {
		return certType;
	}

	public BindingBankCardParam setCertType(CertType certType) {
		this.certType = certType;
		return this;
	}

	public String getCertNo() {
        return certNo;
    }

    public BindingBankCardParam setCertNo(String certNo) {
        this.certNo = certNo;
        return this;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public BindingBankCardParam setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public String getValidityPeriod() {
        return validityPeriod;
    }

    public BindingBankCardParam setValidityPeriod(String validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    public String getVerificationValue() {
        return verificationValue;
    }

    public BindingBankCardParam setVerificationValue(String verificationValue) {
        this.verificationValue = verificationValue;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public BindingBankCardParam setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public BindingBankCardParam setCity(String city) {
        this.city = city;
        return this;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public BindingBankCardParam setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
        return this;
    }

    public VerifyMode getVerifyMode() {
        return verifyMode;
    }

    public BindingBankCardParam setVerifyMode(VerifyMode verifyMode) {
        this.verifyMode = verifyMode;
        return this;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public BindingBankCardParam setExtendParam(String extendParam) {
        this.extendParam = extendParam;
        return this;
    }

    @Override
    public boolean restrictCheck() {
        if(StringUtils.isNotEmpty(phoneNo)) {
            return verifyMode != null;
        } else {
            return verifyMode == null;
        }
    }
}
