package com.qd.p2p.sina.pay.bussniessparam;

import com.qd.p2p.sina.pay.enums.BankCode;
import com.qd.p2p.sina.pay.enums.CardAttribute;
import com.qd.p2p.sina.pay.enums.CardType;

public class AuditMemberInfosParam {
	
	//请求审核订单号，商户网站交易订单号，商户内部保证唯一
	private String auditOrderNo;
	
	//用户标识信息，商户系统用户id(字母或数字)
	private String identityId;
	
	//公司名称,以便审核通过
	private String companyName;
	
	//企业网址
	private String website;
	
	//企业地址
	private String address;
	
	//执照号
	private String licenseNo;
	
	//营业执照所在地
	private String licenseAddress;
	
	//执照过期日（营业期限）
	private String licenseExpireDate;
	
	//营业范围
	private String businessScope;
	
	//联系电话
	private String telephone;
	
	//联系Email
	private String email;
	
	//组织机构代码
	private String organizationNo;
	
	//企业简介
	private String summary;
	
	//企业法人
	private String legalPerson;
	
	//法人证件号码
	private String certNo;
	
	//法人手机号码
	private String legalPersonPhone;
	
	//银行编号
	private BankCode bankCode;
	
	//银行卡号
	private String bankAccountNo;
	
	//卡类型
	private CardType cardType;
	
	//卡属性
	private CardAttribute cardAttribute;
	
	//开户行省份
	private String province;
	
	//开户行城市
	private String city;
	
	//支行名称
	private String bankBranch;
	
	//文件名称  文件格式: *.zip 且文件名只能由数字或字母组成
	private String fileName;
	
	//文件摘要
	private String digest;
	
	//文件摘要算法
	private String digestType;
	
	//异步通知地址
	private String notifyUrl;

	public String getAuditOrderNo() {
		return auditOrderNo;
	}

	public void setAuditOrderNo(String auditOrderNo) {
		this.auditOrderNo = auditOrderNo;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLicenseAddress() {
		return licenseAddress;
	}

	public void setLicenseAddress(String licenseAddress) {
		this.licenseAddress = licenseAddress;
	}

	public String getLicenseExpireDate() {
		return licenseExpireDate;
	}

	public void setLicenseExpireDate(String licenseExpireDate) {
		this.licenseExpireDate = licenseExpireDate;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public void setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
	}

	public BankCode getBankCode() {
		return bankCode;
	}

	public void setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
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

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getDigestType() {
		return digestType;
	}

	public void setDigestType(String digestType) {
		this.digestType = digestType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}
