package com.qd.p2p.sina.pay.param;


import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.BankCode;
import com.qd.p2p.sina.pay.enums.CardAttribute;
import com.qd.p2p.sina.pay.enums.CardType;
import com.qd.p2p.sina.pay.enums.CertType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.PayType;

/**
 * 充值扩展
 */
@SuppressWarnings("serial")
public class DepositExtendParam implements Serializable{

	private static Map<PayType, String[]> payTypeParamMap = new HashMap<PayType, String[]>();
	
	static{
		payTypeParamMap.put(PayType.online_bank, new String[]{"bankCode","cardType","cardAttribute"});
		payTypeParamMap.put(PayType.balance, new String[]{"accountType"});
		payTypeParamMap.put(PayType.binding_pay, new String[]{"cardId"});
		payTypeParamMap.put(PayType.quick_pay, new String[]{
				"bankCode","bankAccountNo","accountName", "cardType","cardAttribute","certType",
				"certNo","phoneNo","validityPeriod","verificationValue","province","city"
		});
	}
	
    /** 支付类型 */
	@Param(required=true)
    private PayType payType;

    /** 银行代码 */
	@Param(required=true)
    private BankCode bankCode;

    /** 卡类型 */
	@Param(required=true)
    private CardType cardType;

    /** 卡属性 */
	@Param(required=true)
    private CardAttribute cardAttribute;

    /** 帐户类型 */
	@Param(required=true)
    private AccountType accountType;
    
    /** 绑定卡ID */
	@Param(required=true)
    private String cardId;
    
    /** 银行卡号 */
	@Param(required=true)
    private String bankAccountNo;
    
    /** 户名 */
	@Param(required=true)
    private String accountName;
    
    /** 证件号码 */
    @Param(required=false)
    private String certNo;
    
    /** 证件类型 */
    @Param(required=false)
    private CertType certType;
    
    /** 手机号 */
    @Param(required=true)
    private String phoneNo;
    
    /** 有效期 */
    @Param(required=false)
    private String validityPeriod;
    
    /** CVV2, 密文，使用新浪支付RSA公钥加密。明文长度：10；信用卡专用 */
    @Param(required=false)
    private String verificationValue;
    
    /** 省份 */
    @Param(required=true)
    private String province;

    /** 城市 */
    @Param(required=true)
    private String city;
    
    /** 最终生成的扩展参数 */
    private String extendParam;
    
    public boolean check(){
    	
    	String[] fieldNames = payTypeParamMap.get(payType);
		
    	try {
			Class<?> clazz = this.getClass();
			StringBuffer buffer = new StringBuffer(200);
			for(int i = 0; i < fieldNames.length; i ++){
				String f = fieldNames[i];
				//检查属性是否存在
				PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(clazz, f);
				if(pd == null){
					return false;
				}
				//检查空值
				Method method = pd.getReadMethod();
				Object value = method.invoke(this);
				Field filed = clazz.getDeclaredField(f);
				Param paramAnnotation = filed.getAnnotation(Param.class);
				if(paramAnnotation != null && paramAnnotation.required()){
					if(value == null){
						return false;
					}
				}else{
					value = (value == null) ? "" : value.toString();
				}
				
				//生成扩展参数
				buffer.append(value.toString());
				if(i != fieldNames.length -1){
					buffer.append(",");
				}
				
			}
			extendParam = buffer.toString();
		} catch (Exception e) {
			throw new IllegalArgumentException("DepositExtendParam restrict parameter failure ");
		}
		return true;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public BankCode getBankCode() {
		return bankCode;
	}

	public void setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public CardAttribute getCardAttribute() {
		return cardAttribute;
	}

	public void setCardAttribute(CardAttribute cardAttribute) {
		this.cardAttribute = cardAttribute;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public CertType getCertType() {
		return certType;
	}

	public void setCertType(CertType certType) {
		this.certType = certType;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public String getVerificationValue() {
		return verificationValue;
	}

	public void setVerificationValue(String verificationValue) {
		this.verificationValue = verificationValue;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public void setExtendParam(String extendParam) {
		this.extendParam = extendParam;
	}
    
    
}
