package com.qd.p2p.adapter;

import com.qd.p2p.adapter.param.BankCardListForEnterpriseParameter;
import com.qd.p2p.adapter.param.BankCardListParameter;
import com.qd.p2p.adapter.param.BindingAccountCodeParameter;
import com.qd.p2p.adapter.param.BindingAccountParameter;
import com.qd.p2p.adapter.param.BindingBankCardCodeParameter;
import com.qd.p2p.adapter.param.BindingBankCardForEnterpriseParameter;
import com.qd.p2p.adapter.param.BindingBankCardParameter;
import com.qd.p2p.adapter.param.CreditByPageParameter;
import com.qd.p2p.adapter.param.ExportP2PBusinessToExcelParameter;
import com.qd.p2p.adapter.param.FlowBorrowParam;
import com.qd.p2p.adapter.param.FullBorrowLoanParam;
import com.qd.p2p.adapter.param.QueryBalanceParameter;
import com.qd.p2p.adapter.param.QueryP2PBusinessParameter;
import com.qd.p2p.adapter.param.QueryTotalBalanceParameter;
import com.qd.p2p.adapter.param.RechargeByAuthenticationParameter;
import com.qd.p2p.adapter.param.RechargeByPageParameter;
import com.qd.p2p.adapter.param.RechargeParameter;
import com.qd.p2p.adapter.param.RepayBorrowParam;
import com.qd.p2p.adapter.param.TenderBorrowParam;
import com.qd.p2p.adapter.param.TransferAccountsParameter;
import com.qd.p2p.adapter.param.UnBindingBankCardParameter;
import com.qd.p2p.adapter.param.WithdrawParameter;
import com.qd.p2p.adapter.response.BankCardListForEnterpriseResponse;
import com.qd.p2p.adapter.response.BankCardListResponse;
import com.qd.p2p.adapter.response.BindingAccountCodeResponse;
import com.qd.p2p.adapter.response.BindingAccountResponse;
import com.qd.p2p.adapter.response.BindingBankCardCodeResponse;
import com.qd.p2p.adapter.response.BindingBankCardResponse;
import com.qd.p2p.adapter.response.ExportP2PBusinessToExcelResponse;
import com.qd.p2p.adapter.response.FlowBorrowResponse;
import com.qd.p2p.adapter.response.FullBorrowLoanResponse;
import com.qd.p2p.adapter.response.GenericResponse;
import com.qd.p2p.adapter.response.HtmlResponse;
import com.qd.p2p.adapter.response.QueryBalanceResponse;
import com.qd.p2p.adapter.response.QueryOrderStatusResponse;
import com.qd.p2p.adapter.response.QueryP2PBusinessResponse;
import com.qd.p2p.adapter.response.QueryP2PBusinessUserInfoResponse;
import com.qd.p2p.adapter.response.QueryTotalBalanceResponse;
import com.qd.p2p.adapter.response.RechargeResponse;
import com.qd.p2p.adapter.response.RepayBorrowResponse;
import com.qd.p2p.adapter.response.TenderBorrowResponse;
import com.qd.p2p.adapter.response.TransferAccountsResponse;

/**
 * 支付请求服务接口
 *
 * @author linya
 */
public interface AdaptedRequestHandleService {

	/**
	 * 获取托管平台相关信息
	 */
	PlatformInfo getPlatformInfo();

	/**
	 * AES加密 AES( XML内容 , 商户密钥);
	 *
	 * @return
	 */
	String aesEncryptKey16(String xml);

	/**
	 *
	 * 得到一个md5签名 val + ~|~ + "商户密钥";
	 *
	 * @return
	 */
	String signMd5(String val);

	/**
	 * 绑定账户
	 *
	 * @param parameter
	 * @return
	 */
	BindingAccountResponse bindingAccount(BindingAccountParameter parameter);

	/**
	 * 发送绑定账户验证码
	 *
	 * @param parameter
	 * @return
	 */
	BindingAccountCodeResponse sendBindingAccountCode(BindingAccountCodeParameter parameter);

	/**
	 * 发送绑定银行卡验证码
	 *
	 * @param parameter
	 * @return
	 */
	BindingBankCardCodeResponse sendBindingBankCode(BindingBankCardCodeParameter parameter);

	/**
	 * 绑定银行卡
	 *
	 * @param parameter
	 * @return
	 */
	BindingBankCardResponse bindingBankCard(BindingBankCardParameter parameter);

	/**
	 * 解绑银行卡
	 *
	 * @param parameter
	 * @return
	 */
	GenericResponse unBindingBankCard(UnBindingBankCardParameter parameter);

	/**
	 * 绑定银行卡（企业）
	 *
	 * @param parameter
	 * @return
	 */
	GenericResponse bindingBankCardForEnterprise(BindingBankCardForEnterpriseParameter parameter);
	
	/**
	 * 充值
	 *
	 * @param parameter
	 * @return
	 */
	RechargeResponse recharge(RechargeParameter parameter);

	/**
	 * 提现
	 *
	 * @param parameter
	 * @return
	 */
	GenericResponse withdraw(WithdrawParameter parameter);

	/**
	 * 账户余额查询
	 *
	 * @param parameter
	 * @return
	 * @author Kaiju Zhao
	 */
	QueryBalanceResponse queryBalance(QueryBalanceParameter parameter);

	/**
	 * 账户余额总额查询
	 *
	 * @param parameter
	 * @return
	 * @author Kaiju Zhao
	 */
	QueryTotalBalanceResponse queryTotalBalance(QueryTotalBalanceParameter parameter);

	/**
	 * 查询业务数据导出到Excel
	 *
	 * @param parameter
	 * @return
	 * @author Kaiju Zhao
	 */
	ExportP2PBusinessToExcelResponse exportP2PBusinessToExcel(ExportP2PBusinessToExcelParameter parameter);

	/**
	 * 获取会员银行卡信息(个人)
	 *
	 * @param parameter
	 * @return
	 * @author hongbinglin
	 */
	BankCardListResponse queryBankList(BankCardListParameter parameter);
	
	/**
	 * 获取会员银行卡信息(企业)
	 *
	 * @param parameter
	 * @return
	 * @author linya
	 */
	BankCardListForEnterpriseResponse queryBankListForEnterprise(BankCardListForEnterpriseParameter parameter);

	/**
	 * 业务查询接口（不包含查询用户信息）
	 *
	 * @param parameter
	 * @return
	 * @author Kaiju Zhao
	 */
	QueryP2PBusinessResponse queryP2PBusiness(QueryP2PBusinessParameter parameter);

	QueryOrderStatusResponse queryOrderStatus(String orderId, Integer type);

	/**
	 * 业务查询接口-查询用户信息
	 *
	 * @param parameter
	 * @return
	 * @author Kaiju Zhao
	 */
	QueryP2PBusinessUserInfoResponse queryP2PBusinessUserInfo(QueryP2PBusinessParameter parameter);

	/**
	 * 投标
	 *
	 * @param parameter 投标参数
	 * @return 投标结果
	 */
	TenderBorrowResponse tender(TenderBorrowParam parameter);

	/**
	 * 流标
	 *
	 * @param parameter 流标参数
	 * @return 流标结果
	 */
	FlowBorrowResponse flow(FlowBorrowParam parameter);

	/**
	 * 满标放款
	 *
	 * @param parameter 满标参数
	 * @return 满标结果
	 */
	FullBorrowLoanResponse loan(FullBorrowLoanParam parameter);

	/**
	 * 还款
	 *
	 * @param parameter 还款参数
	 * @return 还款结果
	 */
	RepayBorrowResponse repay(RepayBorrowParam parameter);

	/**
	 * 单笔转账
	 *
	 * @param parameter 转账参数
	 * @return 转账结果
	 */
	TransferAccountsResponse transferAccounts(TransferAccountsParameter parameter);

	/**
	 * 充值网银支付
	 *
	 * @param parameter 转账参数
	 * @return 转账结果
	 */
	HtmlResponse rechargeByPage(RechargeByPageParameter parameter);

	/**
	 * 充值认证支付
	 *
	 * @param parameter
	 * @return
	 */
	HtmlResponse rechargeByAuthentication(RechargeByAuthenticationParameter parameter);

	/**
	 * 获取资金托管商户认证书（页面）
	 *
	 * @param parameter
	 * @return
	 * @author Kaiju Zhao
	 */
	HtmlResponse creditByPage(CreditByPageParameter parameter);

}
