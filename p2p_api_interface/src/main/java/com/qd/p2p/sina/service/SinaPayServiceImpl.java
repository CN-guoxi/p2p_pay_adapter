package com.qd.p2p.sina.service;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.rpc.RpcException;
import com.qd.p2p.sina.pay.Constant;
import com.qd.p2p.sina.pay.IPayService;
import com.qd.p2p.sina.pay.IRequestParam;
import com.qd.p2p.sina.pay.IResponse;
import com.qd.p2p.sina.pay.bussniessparam.AuditMemberInfosParam;
import com.qd.p2p.sina.pay.bussniessparam.HostingCollectTradeParam;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.BankCode;
import com.qd.p2p.sina.pay.enums.CardAttribute;
import com.qd.p2p.sina.pay.enums.CardType;
import com.qd.p2p.sina.pay.enums.CertType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.MemberType;
import com.qd.p2p.sina.pay.enums.PayType;
import com.qd.p2p.sina.pay.enums.VerifyMode;
import com.qd.p2p.sina.pay.enums.VerifyType;
import com.qd.p2p.sina.pay.param.AdvanceHostingPayParam;
import com.qd.p2p.sina.pay.param.AuditMemberInfosRequestParam;
import com.qd.p2p.sina.pay.param.BindingBankCardAdvanceParam;
import com.qd.p2p.sina.pay.param.BindingBankCardParam;
import com.qd.p2p.sina.pay.param.BindingVerifyParam;
import com.qd.p2p.sina.pay.param.CreateActivateMemberParam;
import com.qd.p2p.sina.pay.param.CreateHostingCollectTradeParam;
import com.qd.p2p.sina.pay.param.CreateHostingDepositParam;
import com.qd.p2p.sina.pay.param.CreateHostingWithdrawParam;
import com.qd.p2p.sina.pay.param.CreateSingleHostingPayTradeParam;
import com.qd.p2p.sina.pay.param.DepositExtendParam;
import com.qd.p2p.sina.pay.param.QueryBalanceParam;
import com.qd.p2p.sina.pay.param.QueryBankCardParam;
import com.qd.p2p.sina.pay.param.QueryHostingDepositParam;
import com.qd.p2p.sina.pay.param.QueryHostingTradeParam;
import com.qd.p2p.sina.pay.param.QueryHostingWithdrawParam;
import com.qd.p2p.sina.pay.param.QueryVerifyParam;
import com.qd.p2p.sina.pay.param.SetRealNameParam;
import com.qd.p2p.sina.pay.param.ShowMemberInfosSinaParam;
import com.qd.p2p.sina.pay.param.UnbindingBankCardParam;
import com.qd.p2p.sina.pay.response.BindingBankCardAdvanceResponse;
import com.qd.p2p.sina.pay.response.BindingBankCardResponse;
import com.qd.p2p.sina.pay.response.BlankResponse;
import com.qd.p2p.sina.pay.response.CreateActivateMemberResponse;
import com.qd.p2p.sina.pay.response.CreateHostingCollectTradeResponse;
import com.qd.p2p.sina.pay.response.CreateHostingDepositResponse;
import com.qd.p2p.sina.pay.response.CreateHostingWithdrawResponse;
import com.qd.p2p.sina.pay.response.CreateSingleHostingPayTradeResponse;
import com.qd.p2p.sina.pay.response.QueryBankCardResponse;
import com.qd.p2p.sina.pay.response.QueryHostingDepositParamResponse;
import com.qd.p2p.sina.pay.response.QueryHostingTradeResponse;
import com.qd.p2p.sina.pay.response.QueryHostingWithdrawResponse;
import com.qd.p2p.sina.pay.response.QueryVerifyResponse;
import com.qd.p2p.sina.pay.response.SetRealNameResponse;
import com.qd.p2p.sina.pay.response.ShowMemberInfosSinaResponse;
import com.qd.p2p.sina.pay.response.sinaQueryBalanceResponse;
import com.qdlc.p2p.common.constant.TradeCode;
import com.qdlc.p2p.common.exception.BusinessException;
import com.qdlc.p2p.common.util.OrderNoUtil;

@Service
public class SinaPayServiceImpl extends ApplicationObjectSupport implements SinaPayService {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    private static final Logger log = Logger.getLogger(SinaPayServiceImpl.class);

    /**
     * 绑定银行卡
     *
     * @param identityId    用户标识信息
     * @param bankCode      银行
     * @param bankAccountNo 银行卡号码，需RSA加密
     * @param province      开卡省份
     * @param city          开卡城市
     * @param phoneNo       银行卡预留手机号码，需RSA加密，可以为空
     * @author linya
     */
    @Override
    public BindingBankCardResponse bindingBankCard(String identityId, BankCode bankCode, String bankAccountNo, String province, String city, String phoneNo) {
        BindingBankCardParam param = new BindingBankCardParam();
        param.setRequestNo(getRandomSequence())
                .setIdentityId(identityId)
                .setIdentityType(IdentityType.UID)
                .setBankCode(bankCode)
                .setBankAccountNo(bankAccountNo)
                .setCardType(CardType.DEBIT)
                .setCardAttribute(CardAttribute.C)
                .setCertType(CertType.IC)
                .setProvince(province)
                .setCity(city);
        if (StringUtils.hasText(phoneNo)) {
            param.setPhoneNo(phoneNo)
                    .setVerifyMode(VerifyMode.SIGN);
        }
        BindingBankCardResponse response = request(param, BindingBankCardResponse.class);
        return response;
    }

    /**
     * 绑定银行卡推进
     *
     * @param ticket    绑定银行卡返回的ticket信息
     * @param validCode 绑定银行卡发送的手机验证码
     * @author linya
     * @see SinaPayServiceImpl#bindingBankCard(String, BankCode, String, String, String, String)
     * @see BindingBankCardResponse
     */
    @Override
    public BindingBankCardAdvanceResponse bindingBankCardAdvance(String ticket, String validCode) {
        BindingBankCardAdvanceParam param = new BindingBankCardAdvanceParam();
        param.setTicket(ticket).setValidCode(validCode);
        BindingBankCardAdvanceResponse response = request(param, BindingBankCardAdvanceResponse.class);
        return response;
    }

    /**
     * 解绑银行卡
     *
     * @param identityId 用户标识
     * @param cardId     绑卡银行卡ID
     * @return
     * @author linya
     */
    @Override
    public BlankResponse unbindingBankCard(String identityId, String cardId) {
        UnbindingBankCardParam param = new UnbindingBankCardParam();
        param.setIdentityId(identityId)
                .setIdentityType(IdentityType.UID)
                .setCardId(cardId);
        BlankResponse response = request(param, BlankResponse.class);
        return response;
    }


    /**
     * 快捷支付
     *
     * @param identityId    用户标识
     * @param amount        充值金额
     * @param bankCode      银行
     * @param bankAccountNo 银行卡号码，需RSA加密
     * @param province      开卡省份
     * @param city          开卡城市
     * @param accountName   持卡账户名，需RSA加密
     * @param phoneNo       银行卡预留手机号码，需RSA加密
     * @param summary       描述说明
     * @author linya
     */
    @Override
    public CreateHostingDepositResponse quickPay(String identityId, double amount, BankCode bankCode, String bankAccountNo, String province, String city, String accountName, String phoneNo, String summary) {
        CreateHostingDepositParam param = new CreateHostingDepositParam();
        param.setOutTradeNo(getRandomSequence());
        param.setSummary(summary);
        param.setIdentityId(identityId);
        param.setIdentityIype(IdentityType.UID);
        param.setAccountType(AccountType.SAVING_POT);
        param.setAmount(amount);

        DepositExtendParam extendParam = new DepositExtendParam();
        extendParam.setPayType(PayType.quick_pay);
        extendParam.setBankCode(bankCode);
        extendParam.setCardType(CardType.DEBIT);
        extendParam.setCardAttribute(CardAttribute.C);
        extendParam.setBankAccountNo(bankAccountNo);
        extendParam.setAccountName(accountName);
        extendParam.setPhoneNo(phoneNo);
        extendParam.setProvince(province);
        extendParam.setCity(city);

        param.setDepositExtendParam(extendParam);

        return request(param, CreateHostingDepositResponse.class);
    }

    /**
     * 快捷支付
     *
     * @param identityId 用户标识
     * @param amount     充值金额
     * @param cardId     绑定的卡号
     * @param summary    描述说明
     */
    @Override
    public CreateHostingDepositResponse bindingPay(String identityId, double amount, String cardId, String summary, String notifyUrl) {
        CreateHostingDepositParam param = new CreateHostingDepositParam();
        param.setOutTradeNo(getRandomSequence());
        param.setSummary(summary);
        param.setIdentityId(identityId);
        param.setIdentityIype(IdentityType.UID);
        param.setAccountType(AccountType.SAVING_POT);
        param.setAmount(amount);
        param.setNotifyUrl(notifyUrl);
        DepositExtendParam extendParam = new DepositExtendParam();
        extendParam.setPayType(PayType.binding_pay);
        extendParam.setCardId(cardId);
        param.setDepositExtendParam(extendParam);

        return request(param, CreateHostingDepositResponse.class);
    }

    /**
     * 支付推进
     *
     * @param ticket    快捷支付返回的ticket信息
     * @param validCode 快捷支付发送的手机验证码
     * @see SinaPayServiceImpl#quickPay(String, double, BankCode, String, String, String, String, String, String)
     * @see CreateHostingDepositResponse
     */
    @Override
    public BlankResponse payAdvance(String ticket, String validCode, String notifyUrl) {
        AdvanceHostingPayParam param = new AdvanceHostingPayParam();
        param.setOutAdvanceNo(getRandomSequence());
        param.setTicket(ticket);
        param.setValidateCode(validCode);
        param.setNotifyUrl(notifyUrl);
        return request(param, BlankResponse.class);
    }

    /**
     * 提现
     *
     * @param identityId 用户标识
     * @param cardId     绑卡银行卡ID
     * @param amount     提现金额
     * @param userFee    提现手续费
     * @param summary    操作备注
     * @return
     */
    @Override
    public CreateHostingWithdrawResponse withdraw(String identityId, String cardId, double amount, double userFee, String summary, String notifyUrl) {
        CreateHostingWithdrawParam param = new CreateHostingWithdrawParam();
        param.setOutTradeNo(getRandomSequence())
                .setIdentityId(identityId)
                .setIdentityIype(IdentityType.UID)
                .setAccountType(AccountType.SAVING_POT)
                .setAmount(amount)
                .setUserFee(userFee)
                .setCardId(cardId)
                .setNotifyUrl(notifyUrl);
        CreateHostingWithdrawResponse response = request(param, CreateHostingWithdrawResponse.class);
        return response;
    }

    /**
     * 查询账户绑定的银行卡
     *
     * @param identityId 用户标识
     * @param cardId     绑定的卡ID
     * @return 绑定的银行卡信息
     */
    @Override
    public QueryBankCardResponse queryBankCard(String identityId, String cardId) {
        QueryBankCardParam param = new QueryBankCardParam();
        param.setIdentityId(identityId)
                .setIdentityType(IdentityType.UID);
        if (StringUtils.hasText(cardId)) {
            param.setCardId(cardId);
        }
        QueryBankCardResponse response = request(param, QueryBankCardResponse.class);
        return response;
    }

    /**
     * 查询账户绑定的所有银行卡
     *
     * @param identityId 用户标识
     * @return 绑定的银行卡信息
     */
    @Override
    public QueryBankCardResponse queryBankCard(String identityId) {
        return queryBankCard(identityId, null);
    }

    /**
     * 查询帐户余额(默认存钱罐)
     *
     * @param identityId 用户标识
     * @return 帐户余额信息
     */
    @Override
    public sinaQueryBalanceResponse queryBalance(String identityId) {
        return queryBalance(identityId, IdentityType.UID, AccountType.SAVING_POT);
    }

    /**
     * 查询帐户余额
     *
     * @param identityId   用户标识
     * @param identityType 标志类型
     * @param accountType  帐户类型
     * @return 绑定的银行卡信息
     */
    @Override
    public sinaQueryBalanceResponse queryBalance(String identityId, IdentityType identityType, AccountType accountType) {
        QueryBalanceParam param = new QueryBalanceParam();
        param.setIdentityId(identityId)
                .setIdentityType(identityType)
                .setAccountType(accountType);
        return request(param, sinaQueryBalanceResponse.class);
    }

    /**
     * 查询资金余额
     *
     * @param identityId  用户标识
     * @param accountType 账户类型
     * @return
     */
    @Override
    public sinaQueryBalanceResponse queryBalance(String identityId, AccountType accountType) {
        return queryBalance(identityId, IdentityType.UID, accountType);
    }

    @Override
    public CreateHostingCollectTradeResponse createHostingCollectTradeForPerson(String orderNo, String tppId, double amount, String summaryName, String callBackUrl) {
        return createHostingCollectTrade(orderNo, tppId, amount, summaryName, IdentityType.UID, AccountType.SAVING_POT, callBackUrl);
    }

    @Override
    public CreateHostingCollectTradeResponse createHostingCollectTradeForPlatform(String orderNo, String tppId, double amount, String summaryName, String callBackUrl) {
        return createHostingCollectTrade(orderNo, tppId, amount, summaryName, IdentityType.EMAIL, AccountType.BASIC, callBackUrl);
    }

    private CreateHostingCollectTradeResponse createHostingCollectTrade(String orderNo, String tppId, double amount, String summaryName, IdentityType tdentityType, AccountType accountType, String callBackUrl) {
        // 调用代收接口
        HostingCollectTradeParam bizParam = HostingCollectTradeParam.build()
                .setIdentityId(tppId)
                .setAmount(amount)
                .setSummary(summaryName + orderNo)
                .setCanRepayOnFailed("N")
                .setOutOrderNo(orderNo)
                .setIdentityType(tdentityType)
                .setAccountType(accountType)
                .setNofifyUrl(callBackUrl);
        return createHostingCollectTrade(bizParam);
    }

    /**
     * 代收资金
     *
     * @param identityId       用户标识
     * @param goodsId          商户标的号，对应“标的录入”接口中的标的号，用来关联此笔代收和标的
     * @param amount           代收金额
     * @param canRepayOnFailed 支付失败后是否可以再次支付
     * @param payerIp          支付者IP地址
     * @param summary          操作备注
     * @return
     */
    @Override
    public CreateHostingCollectTradeResponse createHostingCollectTrade(String identityId, String goodsId, double amount, String canRepayOnFailed, String payerIp, String summary) {
        CreateHostingCollectTradeParam param = new CreateHostingCollectTradeParam();
        param.setOutTradeNo(getRandomSequence())
                .setOutTradeCode(TradeCode.C1001)
                .setPayerId(identityId)
                .setGoodsId(goodsId)
                .setPayerIdentityType(IdentityType.UID)
                .setAmount(amount)
                .setPayerIp(payerIp)
                .setSummary(summary)
                .setCanRepayOnFailed(canRepayOnFailed);
        DepositExtendParam extend = new DepositExtendParam();
        extend.setPayType(PayType.balance);
        extend.setAccountType(AccountType.SAVING_POT);
        param.setPayParam(extend);
        CreateHostingCollectTradeResponse response = request(param, CreateHostingCollectTradeResponse.class);
        return response;
    }

    @Deprecated
    private CreateHostingCollectTradeResponse createHostingCollectTrade(HostingCollectTradeParam bizParam) {
        String identityId = bizParam.getIdentityId();
        String goodsId = bizParam.getGoodsId();
        double amount = bizParam.getAmount();
        String payerIp = bizParam.getPayerIp();
        String summary = bizParam.getSummary();
        String canRepayOnFailed = bizParam.isCanRepayOnFailed();
        String outTradeNo = bizParam.getOutOrderNo();
        String notifyUrl = bizParam.getNofifyUrl();
        CreateHostingCollectTradeParam param = new CreateHostingCollectTradeParam();
        param.setOutTradeNo(getRandomSequence())
                .setOutTradeCode(TradeCode.C1001)
                .setPayerId(identityId)
                .setGoodsId(goodsId)
                .setPayerIdentityType(bizParam.getIdentityType())
                .setAmount(amount)
                .setPayerIp(payerIp)
                .setSummary(summary)
                .setCanRepayOnFailed(canRepayOnFailed)
                .setNotifyUrl(notifyUrl);
        if (outTradeNo != null) {
            param.setOutTradeNo(outTradeNo);
        }
        DepositExtendParam extend = new DepositExtendParam();
        extend.setPayType(PayType.balance);
        extend.setAccountType(bizParam.getAccountType());
        param.setPayParam(extend);
        CreateHostingCollectTradeResponse response = request(param, CreateHostingCollectTradeResponse.class);
        return response;
    }

    /**
     * 托管代收交易
     * @return
     */
    @Override
    public CreateHostingCollectTradeResponse createHostingCollectTrade(CreateHostingCollectTradeParam param) {
        return request(param, CreateHostingCollectTradeResponse.class);
    }
    
    /**
     * 托管代付交易
     * @return
     */
    @Override
    public CreateSingleHostingPayTradeResponse createSingleHostingPayTrade(CreateSingleHostingPayTradeParam param) {
        return request(param, CreateSingleHostingPayTradeResponse.class);
    }

    /**
     * 请求新浪接口
     *
     * @param param
     * @param responseClass
     * @return 请求结果
     */
    private <T extends IResponse> T request(IRequestParam param, Class<T> responseClass) {
        param.checkParameter();
        IPayService iPayService = getApplicationContext().getBean(IPayService.class);
        T response = null;
        try {
            response = iPayService.invoke(param, responseClass);
        } catch (RpcException e) {
            log.error("++++ 请求新浪接口发生异常，请求参数：" + param, e);
            e.printStackTrace();
            throw new BusinessException("系统繁忙，请重试！");
        } catch (Exception e) {
            log.error("++++ 请求新浪接口发生异常，请求参数：" + param, e);
            e.printStackTrace();
            throw new BusinessException("系统维护中，请稍后重试！");
        }

        //response==null，表示服务端口，系统发送错误，没有请求处理了
        if (response == null) {
            try {
                response = responseClass.newInstance();
                response.setReqStatus(Constant.NO_REQUEST);
            } catch (Exception e) {
                log.error("++++ responseClass must have a no-args constructor" + param, e);
            }
        }

        return response;
    }


    /**
     * 获取随机序列数
     *
     * @param length 需要大于14位，如果不大于按照大于处理
     * @return 随便字符串
     */
    private static String getRandomSequence(int length) {

        String time = sdf.format(new Date());
        int len = Math.max(length - time.length(), 0);
        if (len == 0) {
            return time;
        }

        int count = 1;
        StringBuffer placeholder = new StringBuffer();
        Random rd = new Random();
        while (len-- > 0) {
            count *= 10;
            placeholder.append("#");
        }
        String suff = MessageFormat.format("{0, number," + placeholder.toString() + "}", rd.nextInt(count));
        return time + suff;
    }

    private static String getRandomSequence() {
        return OrderNoUtil.getInstance().getSerialNumber();
    }

    /**
     * 实名
     */
    @Override
    public SetRealNameResponse realName(String identityId, IdentityType identityType, CertType cert, String CertNo, String realName) {
        SetRealNameParam param = new SetRealNameParam();
        param.setIdentityId(identityId)
                .setIdentityType(identityType)
                .setCertType(cert)
                .setCertNo(CertNo)
                .setRealName(realName);
        SetRealNameResponse setRealNameResponse = request(param, SetRealNameResponse.class);
        return setRealNameResponse;
    }

    /**
     * 创建激活会员
     */
    @Override
    public CreateActivateMemberResponse createActiveMember(String identityId, MemberType memberType) {
        CreateActivateMemberParam param = new CreateActivateMemberParam();
        param.setIdentityId(identityId)
                .setIdentityType(IdentityType.UID)
                .setMemberType(memberType);
        CreateActivateMemberResponse response = request(param, CreateActivateMemberResponse.class);
        return response;
    }

    /**
     * 绑定认证信息
     */
    @Override
    public BlankResponse bindingVerify(String identityId,
                                       IdentityType identityType, VerifyType verifyType,
                                       String verifyEntity) {
        BindingVerifyParam param = new BindingVerifyParam();
        param.setIdentityId(identityId).setIdentityType(identityType).setVerifyType(verifyType).setVerifyEntity(verifyEntity);
        BlankResponse response = request(param, BlankResponse.class);
        return response;
    }

    /**
     * 查询认证信息
     *
     * @param identityId 用户标识信息
     * @return
     */
    @Override
    public QueryVerifyResponse queryVerify(String identityId) {
        QueryVerifyParam param = new QueryVerifyParam();
        param.setIdentityId(identityId)
                .setIdentityType("UID")
                .setVerifyType("MOBILE")
                .setIsMask("N");
        QueryVerifyResponse response = request(param, QueryVerifyResponse.class);
        return response;
    }

    /**
     * sina页面展示用户信息
     *
     * @param identityId 用户标识信息
     * @return
     */
    @Override
    public ShowMemberInfosSinaResponse showMemberInfosSina(String identityId) {
        ShowMemberInfosSinaParam param = new ShowMemberInfosSinaParam();
        param.setIdentityId(identityId);
        param.setIdentityType("UID");
        ShowMemberInfosSinaResponse response = request(param, ShowMemberInfosSinaResponse.class);
        return response;
    }

    /**
     * 企业用户认证
     *
     * @param param
     * @return
     */
    @Override
    public BlankResponse auditMemberInfos(AuditMemberInfosParam param) {
        AuditMemberInfosRequestParam requestParam = new AuditMemberInfosRequestParam();
        requestParam.setAuditOrderNo(param.getAuditOrderNo())
                .setIdentityId(param.getIdentityId())
                .setCompanyName(param.getCompanyName())
                .setWebsite(param.getWebsite())
                .setAddress(param.getAddress())
                .setLicenseNo(param.getLicenseNo())
                .setLicenseAddress(param.getLicenseAddress())
                .setLicenseExpireDate(param.getLicenseExpireDate())
                .setBusinessScope(param.getBusinessScope())
                .setTelephone(param.getTelephone())
                .setEmail(param.getEmail())
                .setOrganizationNo(param.getOrganizationNo())
                .setSummary(param.getSummary())
                .setLegalPerson(param.getLegalPerson())
                .setLegalPersonPhone(param.getLegalPersonPhone())
                .setCertNo(param.getCertNo())
                .setBankCode(param.getBankCode())
                .setBankAccountNo(param.getBankAccountNo())
                .setCardType(CardType.CREDIT)
                .setCardAttribute(CardAttribute.B)
                .setBankBranch(param.getBankBranch())
                .setProvince(param.getProvince())
                .setCity(param.getCity())
                .setFileName(param.getFileName())
                .setDigest(param.getDigest())
                .setDigestType(param.getDigestType())
                .setIdentityType(IdentityType.UID)
                .setCertType(CertType.IC)
                .setNotifyUrl(param.getNotifyUrl());
        BlankResponse response = request(requestParam, BlankResponse.class);
        return response;
    }

    /**
     * 根据订单号查询
     *
     * @param orderId 订单号
     * @return
     */
    @Override
    public QueryHostingTradeResponse queryHostingTrade(String orderId) {
        QueryHostingTradeParam param = new QueryHostingTradeParam();
        param.setOutTradeNo(orderId);
        return request(param, QueryHostingTradeResponse.class);
    }

    /**
     * 根据用户第三方Id与时间查询
     *
     * @param tppUserCustId 用户第三方Id
     * @param startTime     开始时间
     * @param endTime       结束时间
     * @param page          页号
     * @return
     */

    @Override
    public QueryHostingTradeResponse queryHostingTrade(String tppUserCustId, String startTime, String endTime, String page, String size) {
        QueryHostingTradeParam param = new QueryHostingTradeParam();
        param.setIdentityId(tppUserCustId);
        param.setIdentityType("UID");
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setPageNo(page);
        param.setPageSize(size);
        return request(param, QueryHostingTradeResponse.class);
    }

    /**
     * 查询充值状态
     *
     * @param orderId 订单ID
     * @return
     */

    @Override
    public QueryHostingDepositParamResponse queryHostingDepositParam(String tppUserCustId, String orderId) {
        QueryHostingDepositParam param = new QueryHostingDepositParam();
        param.setIdentityId(tppUserCustId);
        param.setIdentityType(IdentityType.UID);
        param.setOutTradeNo(orderId);
        return request(param, QueryHostingDepositParamResponse.class);
    }

    /**
     * 查询充值状态
     *
     * @param tppUserCustId 用户第三方Id
     * @param startTime     开始时间
     * @param endTime       结束时间
     * @param page          页号
     * @return
     */

    @Override
    public QueryHostingDepositParamResponse queryHostingDepositParam(String tppUserCustId, String startTime, String endTime, int page, int rows) {
        QueryHostingDepositParam param = new QueryHostingDepositParam();
        param.setIdentityId(tppUserCustId);
        param.setIdentityType(IdentityType.UID);
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setPageNo(page);
        param.setPageSize(rows);
        return request(param, QueryHostingDepositParamResponse.class);
    }

    /**
     * 查询提现状态
     *
     * @param orderId 订单ID
     * @return
     */

    @Override
    public QueryHostingWithdrawResponse queryHostingWithdraw(String tppUserCustId, String orderId) {
        QueryHostingWithdrawParam param = new QueryHostingWithdrawParam();
        param.setIdentityId(tppUserCustId);
        param.setIdentityType(IdentityType.UID);
        param.setOutTradeNo(orderId);
        return request(param, QueryHostingWithdrawResponse.class);
    }

    /**
     * 查询提现状态
     *
     * @param tppUserCustId 用户第三方Id
     * @param startTime     开始时间
     * @param endTime       结束时间
     * @param page          页号
     * @return
     */

    @Override
    public QueryHostingWithdrawResponse queryHostingWithdraw(String tppUserCustId, String startTime, String endTime, String page, String rows) {
        QueryHostingWithdrawParam param = new QueryHostingWithdrawParam();
        param.setIdentityId(tppUserCustId);
        param.setIdentityType(IdentityType.UID);
        param.setStartTime(startTime);
        param.setEndTime(endTime);
        param.setPageNo(page);
        param.setPageSize(rows);
        return request(param, QueryHostingWithdrawResponse.class);
    }
}
