package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.BankCode;
import com.qd.p2p.sina.pay.enums.CardAttribute;
import com.qd.p2p.sina.pay.enums.CardType;
import com.qd.p2p.sina.pay.enums.CertType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.MemberType;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;

@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.AUDIT_MEMBER_INFOS, isMember=true)
public class AuditMemberInfosRequestParam extends AbstractNotifyRequestParam {

	//请求审核订单号，商户网站交易订单号，商户内部保证唯一
	@Param(value="audit_order_no", required=true)
	private String auditOrderNo;
	
	//用户标识信息，商户系统用户id(字母或数字)
	@Param(value="identity_id", required=true)
	private String identityId;
	
	//用户标识类型，ID的类型，目前只包括UID
	@Param(value="identity_type", required=true)
	private IdentityType identityType;
	
	//会员类型，详见附录，默认企业，且只支持企业
	@Param(value="member_type")
	private MemberType memberType;
	
	//公司名称,以便审核通过
	@Param(value="company_name")
	private String companyName;
	
	//企业网址
	private String website;
	
	//企业地址
	private String address;
	
	//执照号
	@Param("license_no")
	private String licenseNo;
	
	//营业执照所在地
	@Param("license_address")
	private String licenseAddress;
	
	//执照过期日（营业期限）
	@Param("license_expire_date")
	private String licenseExpireDate;
	
	//营业范围
	@Param("business_scope")
	private String businessScope;
	
	//联系电话
	private String telephone;
	
	//联系Email
	private String email;
	
	//组织机构代码
	@Param("organization_no")
	private String organizationNo;
	
	//企业简介
	private String summary;
	
	//企业法人
	@Param("legal_person")
	private String legalPerson;
	
	//法人证件号码
	@Param("cert_no")
	private String certNo;
	
	//证件类型
	@Param("cert_type")
	private CertType certType;
	
	//法人手机号码
	@Param("legal_person_phone")
	private String legalPersonPhone;
	
	//银行编号
	@Param("bank_code")
	private BankCode bankCode;
	
	//银行卡号
	@Param("bank_account_no")
	private String bankAccountNo;
	
	//卡类型
	@Param("card_type")
	private CardType cardType;
	
	//卡属性
	@Param("card_attribute")
	private CardAttribute cardAttribute;
	
	//开户行省份
	private String province;
	
	//开户行城市
	private String city;
	
	//支行名称
	@Param("bank_branch")
	private String bankBranch;
	
	//文件名称  文件格式: *.zip 且文件名只能由数字或字母组成
	private String fileName;
	
	//文件摘要
	private String digest;
	
	//文件摘要算法
	private String digestType;
	
	//扩展信息
	@Param("extend_param")
	private String extendParam;

	public String getAuditOrderNo() {
		return auditOrderNo;
	}

	public AuditMemberInfosRequestParam setAuditOrderNo(String auditOrderNo) {
		this.auditOrderNo = auditOrderNo;
		return this;
	}

	public String getIdentityId() {
		return identityId;
	}

	public AuditMemberInfosRequestParam setIdentityId(String identityId) {
		this.identityId = identityId;
		return this;
	}

	public IdentityType getIdentityType() {
		return identityType;
	}

	public AuditMemberInfosRequestParam setIdentityType(IdentityType identityType) {
		this.identityType = identityType;
		return this;
	}

	public MemberType getMemberType() {
		return memberType;
	}

	public AuditMemberInfosRequestParam setMemberType(MemberType memberType) {
		this.memberType = memberType;
		return this;
	}

	public String getCompanyName() {
		return companyName;
	}

	public AuditMemberInfosRequestParam setCompanyName(String companyName) {
		this.companyName = companyName;
		return this;
	}

	public String getWebsite() {
		return website;
	}

	public AuditMemberInfosRequestParam setWebsite(String website) {
		this.website = website;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public AuditMemberInfosRequestParam setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public AuditMemberInfosRequestParam setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
		return this;
	}

	public String getLicenseAddress() {
		return licenseAddress;
	}

	public AuditMemberInfosRequestParam setLicenseAddress(String licenseAddress) {
		this.licenseAddress = licenseAddress;
		return this;
	}

	public String getLicenseExpireDate() {
		return licenseExpireDate;
	}

	public AuditMemberInfosRequestParam setLicenseExpireDate(String licenseExpireDate) {
		this.licenseExpireDate = licenseExpireDate;
		return this;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public AuditMemberInfosRequestParam setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
		return this;
	}

	public String getTelephone() {
		return telephone;
	}

	public AuditMemberInfosRequestParam setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public AuditMemberInfosRequestParam setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getOrganizationNo() {
		return organizationNo;
	}

	public AuditMemberInfosRequestParam setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public AuditMemberInfosRequestParam setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public AuditMemberInfosRequestParam setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
		return this;
	}

	public String getCertNo() {
		return certNo;
	}

	public AuditMemberInfosRequestParam setCertNo(String certNo) {
		this.certNo = certNo;
		return this;
	}

	public CertType getCertType() {
		return certType;
	}

	public AuditMemberInfosRequestParam setCertType(CertType certType) {
		this.certType = certType;
		return this;
	}

	public String getLegalPersonPhone() {
		return legalPersonPhone;
	}

	public AuditMemberInfosRequestParam setLegalPersonPhone(String legalPersonPhone) {
		this.legalPersonPhone = legalPersonPhone;
		return this;
	}

	public BankCode getBankCode() {
		return bankCode;
	}

	public AuditMemberInfosRequestParam setBankCode(BankCode bankCode) {
		this.bankCode = bankCode;
		return this;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public AuditMemberInfosRequestParam setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
		return this;
	}

	public CardType getCardType() {
		return cardType;
	}

	public AuditMemberInfosRequestParam setCardType(CardType cardType) {
		this.cardType = cardType;
		return this;
	}

	public CardAttribute getCardAttribute() {
		return cardAttribute;
	}

	public AuditMemberInfosRequestParam setCardAttribute(CardAttribute cardAttribute) {
		this.cardAttribute = cardAttribute;
		return this;
	}

	public String getProvince() {
		return province;
	}

	public AuditMemberInfosRequestParam setProvince(String province) {
		this.province = province;
		return this;
	}

	public String getCity() {
		return city;
	}

	public AuditMemberInfosRequestParam setCity(String city) {
		this.city = city;
		return this;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public AuditMemberInfosRequestParam setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
		return this;
	}

	public String getFileName() {
		return fileName;
	}

	public AuditMemberInfosRequestParam setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	public String getDigest() {
		return digest;
	}

	public AuditMemberInfosRequestParam setDigest(String digest) {
		this.digest = digest;
		return this;
	}

	public String getDigestType() {
		return digestType;
		
	}

	public AuditMemberInfosRequestParam setDigestType(String digestType) {
		this.digestType = digestType;
		return this;
	}

	public String getExtendParam() {
		return extendParam;
	}

	public AuditMemberInfosRequestParam setExtendParam(String extendParam) {
		this.extendParam = extendParam;
		return this;
	}
	
	
}
