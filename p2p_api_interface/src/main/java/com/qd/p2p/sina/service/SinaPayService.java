package com.qd.p2p.sina.service;

import com.qd.p2p.sina.pay.bussniessparam.AuditMemberInfosParam;
import com.qd.p2p.sina.pay.enums.AccountType;
import com.qd.p2p.sina.pay.enums.BankCode;
import com.qd.p2p.sina.pay.enums.CertType;
import com.qd.p2p.sina.pay.enums.IdentityType;
import com.qd.p2p.sina.pay.enums.MemberType;
import com.qd.p2p.sina.pay.enums.VerifyType;
import com.qd.p2p.sina.pay.param.CreateHostingCollectTradeParam;
import com.qd.p2p.sina.pay.param.CreateSingleHostingPayTradeParam;
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

public interface SinaPayService {

    /**
     * 绑定银行卡
     *
     * @param identityId    用户标识信息
     * @param bankAccountNo 银行卡号码，需RSA加密
     * @param province      开卡省份
     * @param city          开卡城市
     * @param phoneNo       银行卡预留手机号码，需RSA加密，可以为空
     * @author linya
     */
    BindingBankCardResponse bindingBankCard(String identityId, BankCode bankCode, String bankAccountNo, String province, String city, String phoneNo);

    /**
     * 绑定银行卡推进
     *
     * @param ticket    绑定银行卡返回的ticket信息
     * @param validCode 绑定银行卡发送的手机验证码
     * @author linya
     * @see SinaPayServiceImpl#bindingBankCard(String, String, String, String, String)
     * @see BindingBankCardResponse
     */
    BindingBankCardAdvanceResponse bindingBankCardAdvance(String ticket, String validCode);

    /**
     * 解绑银行卡
     *
     * @param identityId 用户标识信息
     * @param cardId     绑卡银行卡ID
     * @return
     * @author linya
     */
    BlankResponse unbindingBankCard(String identityId, String cardId);

    /**
     * 快捷支付
     *
     * @param identityId    用户标识信息
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
    CreateHostingDepositResponse quickPay(String identityId, double amount, BankCode bankCode, String bankAccountNo, String province, String city, String accountName, String phoneNo, String summary);

    /**
     * 绑卡支付
     *
     * @param identityId 用户标识信息
     * @param amount     充值金额
     * @param cardId     银行卡卡ID
     * @param summary    描述说明
     * @author linya
     */
    CreateHostingDepositResponse bindingPay(String identityId, double amount, String cardId, String summary, String notifyUrl);

    /**
     * 支付推进(包括快捷支付、绑卡支付)
     *
     * @param ticket    支付返回的ticket信息
     * @param validCode 支付发送的手机验证码
     * @author linya
     * @see SinaPayServiceImpl#quickPay(String, double, BankCode, String, String, String, String, String, String)
     * @see CreateHostingDepositResponse
     */
    BlankResponse payAdvance(String ticket, String validCode, String notifyUrl);

    /**
     * 提现
     *
     * @param identityId 用户标识信息
     * @param cardId     绑卡银行卡ID
     * @param amount     提现金额
     * @param userFee    提现手续费
     * @param summary    操作备注
     * @param notifyUrl  回调URL
     * @return
     * @author linya
     */
    CreateHostingWithdrawResponse withdraw(String identityId, String cardId, double amount, double userFee, String summary, String notifyUrl);

    /**
     * 查询账户绑定的银行卡（单卡）
     *
     * @param identityId 用户标识信息
     * @param cardId     绑卡银行卡ID
     * @return
     * @author linya
     */
    QueryBankCardResponse queryBankCard(String identityId, String cardId);

    /**
     * 查询账户绑定的银行卡（所有卡）
     *
     * @param identityId 用户标识信息
     * @return
     * @author linya
     */
    QueryBankCardResponse queryBankCard(String identityId);

    /**
     * 查询帐户余额(默认存钱罐)
     *
     * @param identityId 用户标识
     * @return 帐户余额信息
     * @author wuaj
     */
    public sinaQueryBalanceResponse queryBalance(String identityId);

    /**
     * 查询资金余额
     *
     * @param identityId  用户标识信息
     * @param accountType 账户类型
     * @return
     * @author linya
     */
    sinaQueryBalanceResponse queryBalance(String identityId, AccountType accountType);

    /**
     * 查询帐户余额
     *
     * @param identityId   用户标识
     * @param identityType 标志类型
     * @param accountType  帐户类型
     * @return 绑定的银行卡信息
     * @author wuaj
     */
    sinaQueryBalanceResponse queryBalance(String identityId, IdentityType identityType, AccountType accountType);

    /**
     * 代收资金
     *
     * @param identityId       用户标识信息
     * @param goodsId          商户标的号，对应“标的录入”接口中的标的号，用来关联此笔代收和标的
     * @param amount           代收金额
     * @param canRepayOnFailed 支付失败后是否可以再次支付
     * @param payerIp          支付者IP地址
     * @param summary          操作备注
     * @return
     * @author linya
     */
    CreateHostingCollectTradeResponse createHostingCollectTrade(String identityId, String goodsId, double amount, String canRepayOnFailed, String payerIp, String summary);

    /**
     * 代收资金(用户)
     *
     * @param orderNo     订单号
     * @param tppId       支付者标识信息
     * @param amount      代收金额
     * @param summaryName 操作备注
     * @param callBackUrl 回调地址
     * @return
     */
    CreateHostingCollectTradeResponse createHostingCollectTradeForPerson(String orderNo, String tppId, double amount, String summaryName, String callBackUrl);

    /**
     * 代收资金(平台)
     *
     * @param orderNo     订单号
     * @param tppId       支付者标识信息
     * @param amount      代收金额
     * @param summaryName 操作备注
     * @param callBackUrl 回调地址
     * @return
     */
    CreateHostingCollectTradeResponse createHostingCollectTradeForPlatform(String orderNo, String tppId, double amount, String summaryName, String callBackUrl);

    /**
     * 代收资金
     * @return
     */
    CreateHostingCollectTradeResponse createHostingCollectTrade(CreateHostingCollectTradeParam param);
    
    /**
     * 托管代收付易
     * @return
     */
    CreateSingleHostingPayTradeResponse createSingleHostingPayTrade(CreateSingleHostingPayTradeParam param);

    /**
     * 创建激活会员
     *
     * @param identityId
     * @param memberType
     * @return
     */
    CreateActivateMemberResponse createActiveMember(String identityId, MemberType memberType);

    /**
     * 实名
     *
     * @param identityId
     * @param identityType
     * @param cert
     * @param CertNo
     * @param realName
     * @return
     */
    SetRealNameResponse realName(String identityId, IdentityType identityType, CertType cert, String CertNo, String realName);

    /**
     * 绑定认证信息
     *
     * @param identityId
     * @param identityType
     * @param verifyType
     * @param verifyEntity
     * @return
     */
    BlankResponse bindingVerify(String identityId, IdentityType identityType, VerifyType verifyType, String verifyEntity);

    /**
     * 查询认证信息
     *
     * @param identityId 用户标识信息
     * @return
     */
    QueryVerifyResponse queryVerify(String identityId);

    /**
     * sina页面展示用户信息
     *
     * @param identityId 用户标识信息
     * @return
     */
    ShowMemberInfosSinaResponse showMemberInfosSina(String identityId);

    /**
     * 企业用户认证
     *
     * @param param
     * @return
     */
    BlankResponse auditMemberInfos(AuditMemberInfosParam param);

    /**
     * 查询托管交易状态
     *
     * @param orderId 订单ID
     * @return
     */
    QueryHostingTradeResponse queryHostingTrade(String orderId);

    /**
     * 查询托管交易状态
     *
     * @param tppUserCustId 用户第三方Id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param page 页号
     * @return
     */
    QueryHostingTradeResponse queryHostingTrade(String tppUserCustId,String startTime,String endTime,String page,String size);

    /**
     * 查询充值状态
     *
     * @param orderId 订单ID
     * @return
     */
    QueryHostingDepositParamResponse queryHostingDepositParam(String tppUserCustId,String orderId);

    /**
     * 查询充值状态
     *
     * @param tppUserCustId 用户第三方Id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param page 页号
     * @return
     */
    QueryHostingDepositParamResponse queryHostingDepositParam(String tppUserCustId,String startTime,String endTime,int page,int rows);

    /**
     * 查询提现状态
     *
     * @param orderId 订单ID
     * @return
     */
    QueryHostingWithdrawResponse queryHostingWithdraw(String tppUserCustId,String orderId);

    /**
     * 查询提现状态
     *
     * @param tppUserCustId 用户第三方Id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param page 页号
     * @return
     */
    QueryHostingWithdrawResponse queryHostingWithdraw(String tppUserCustId,String startTime,String endTime,String page,String rows);

}