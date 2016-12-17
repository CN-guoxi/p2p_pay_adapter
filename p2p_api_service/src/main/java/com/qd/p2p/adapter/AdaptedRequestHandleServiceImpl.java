package com.qd.p2p.adapter;

import java.util.Properties;

import org.springframework.stereotype.Service;

import com.qd.p2p.adapter.enums.ResponseOrderStatus;
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
import com.qd.p2p.adapter.param.QueryOrderStatusParam;
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
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.enums.P2pBizType;
import com.qd.p2p.baofoo.util.CommonUtil;
import com.qd.p2p.commons.PropertyPlaceholderConfigurerHelper;

/**
 * 支付请求处理接口实现类
 *
 * @author linya
 */
@Service
public class AdaptedRequestHandleServiceImpl implements AdaptedRequestHandleService {

    private static final long serialVersionUID = -258461355487412L;

    private static RequestAdapterHandler handler = new RequestAdapterHandler();

	@Override
	public PlatformInfo getPlatformInfo() {
		PlatformInfo platformInfo = new PlatformInfo();
		// 获取支付平台
		String platform = PropertyPlaceholderConfigurerHelper.getValue(RequestAdapterHandler.PLATFORM);
		AdaptePlatform adapterPlatform = AdaptePlatform.getPlatform(platform);
		if ((adapterPlatform == null) || AdaptePlatform.BAOFOO.equals(adapterPlatform)) {
			if (ConfigurationConsts.DOMAIN == null) {
				Properties props = PropertyPlaceholderConfigurerHelper.getProperties();
				ConfigurationConsts.init(props);
			}
			platformInfo.setDomain(ConfigurationConsts.DOMAIN);
			platformInfo.setMerchantId(ConfigurationConsts.MERCHANT_ID);
			platformInfo.setTerminalId(ConfigurationConsts.TERMINAL_ID);
			platformInfo.setName(AdaptePlatform.BAOFOO.name());
		}
		return platformInfo;
	}

	/**
	 * AES加密 AES( XML内容 , 商户密钥);
	 *
	 * @return
	 */
	@Override
	public String aesEncryptKey16(String xml) {
		return CommonUtil.aesEncryptKey16(xml, ConfigurationConsts.KEY_PWD);
	}

	/**
	 *
	 * 得到一个md5签名 val + ~|~ + "商户密钥";
	 *
	 * @return
	 */
	@Override
	public String signMd5(String val) {
		return CommonUtil.MD5(val + "~|~" + ConfigurationConsts.KEY_PWD);
	}

	/**
	 * 绑定账户
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public BindingAccountResponse bindingAccount(BindingAccountParameter parameter) {
		BindingAccountResponse responsive = handler.submit(parameter, BindingAccountResponse.class);
		return responsive;
	}

	/**
	 * 发送绑定账户验证码
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public BindingAccountCodeResponse sendBindingAccountCode(BindingAccountCodeParameter parameter) {
		BindingAccountCodeResponse responsive = handler.submit(parameter, BindingAccountCodeResponse.class);
		return responsive;
	}

	/**
	 * 发送绑定银行卡验证码
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public BindingBankCardCodeResponse sendBindingBankCode(BindingBankCardCodeParameter parameter) {
		BindingBankCardCodeResponse responsive = handler.submit(parameter, BindingBankCardCodeResponse.class);
		return responsive;
	}

	/**
	 * 绑定银行卡
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public BindingBankCardResponse bindingBankCard(BindingBankCardParameter parameter) {
		return handler.submit(parameter, BindingBankCardResponse.class);
	}

	/**
	 * 解绑银行卡
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public GenericResponse unBindingBankCard(UnBindingBankCardParameter parameter) {
		return handler.submit(parameter, GenericResponse.class);
	}

	/**
	 * 绑定银行卡（企业）
	 * @param parameter
	 * @return
	 */
	@Override
	public GenericResponse bindingBankCardForEnterprise(BindingBankCardForEnterpriseParameter parameter) {
		return handler.submit(parameter, GenericResponse.class);
	}

	/**
	 * 充值
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public RechargeResponse recharge(RechargeParameter parameter) {
		return handler.submit(parameter, RechargeResponse.class);
	}

	/**
	 * 提现
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public GenericResponse withdraw(WithdrawParameter parameter) {
		return handler.submit(parameter, GenericResponse.class);
	}

	@Override
	public QueryBalanceResponse queryBalance(QueryBalanceParameter parameter) {
		return handler.submit(parameter, QueryBalanceResponse.class);
	}

	@Override
	public QueryTotalBalanceResponse queryTotalBalance(QueryTotalBalanceParameter parameter) {
		return handler.submit(parameter, QueryTotalBalanceResponse.class);
	}

	@Override
	public TransferAccountsResponse transferAccounts(TransferAccountsParameter parameter) {
		return handler.submit(parameter, TransferAccountsResponse.class);
	}

	@Override
	public HtmlResponse rechargeByPage(RechargeByPageParameter parameter) {
		return handler.submit(parameter, HtmlResponse.class);
	}

	@Override
	public HtmlResponse rechargeByAuthentication(RechargeByAuthenticationParameter parameter) {
		return handler.submit(parameter, HtmlResponse.class);
	}

	@Override
	public ExportP2PBusinessToExcelResponse exportP2PBusinessToExcel(ExportP2PBusinessToExcelParameter parameter) {
		return handler.submit(parameter, ExportP2PBusinessToExcelResponse.class);
	}

	@Override
	public BankCardListResponse queryBankList(BankCardListParameter parameter) {
		return handler.submit(parameter, BankCardListResponse.class);
	}

	@Override
	public BankCardListForEnterpriseResponse queryBankListForEnterprise(BankCardListForEnterpriseParameter parameter) {
		return handler.submit(parameter, BankCardListForEnterpriseResponse.class);
	}

	@Override
	public QueryP2PBusinessResponse queryP2PBusiness(QueryP2PBusinessParameter parameter) {
		return handler.submit(parameter, QueryP2PBusinessResponse.class);
	}

	@Override
	public QueryOrderStatusResponse queryOrderStatus(String orderId, Integer type) {
		QueryOrderStatusParam parameter = new QueryOrderStatusParam();
		parameter.setOrderId(orderId);
		parameter.setType(type);
		QueryOrderStatusResponse response = handler.submit(parameter, QueryOrderStatusResponse.class);
		Integer relStatus = response.getRelStatus();
		if (relStatus == null) {
			response.setOrderStatus(ResponseOrderStatus.NO_ORDER);
			response.setResponseMsg("订单号不存在!");
			return response;
		}
		if (relStatus == 1) {
			response.setOrderStatus(ResponseOrderStatus.SUCCESS);
		} else {
			if (type == P2pBizType.RECHARGE.getType()) {
				if (relStatus == 0) {
					response.setOrderStatus(ResponseOrderStatus.IN_PROCESS);
				} else {
					response.setOrderStatus(ResponseOrderStatus.FAILURE);
				}
			} else if (type == P2pBizType.WITHDRAW.getType()) {
				if ((relStatus == 0) || (relStatus == 5)) {
					response.setOrderStatus(ResponseOrderStatus.IN_PROCESS);
				} else {
					response.setOrderStatus(ResponseOrderStatus.FAILURE);
				}
			} else if (type == P2pBizType.USER.getType()) {
				if (relStatus == 0) {
					response.setOrderStatus(ResponseOrderStatus.NO_PERMISSION);
				} else if (relStatus == -1) {
					response.setOrderStatus(ResponseOrderStatus.LOGOUT);
				}
			} else {
				response.setOrderStatus(ResponseOrderStatus.FAILURE);
			}
		}
		return response;
	}

	@Override
	public QueryP2PBusinessUserInfoResponse queryP2PBusinessUserInfo(QueryP2PBusinessParameter parameter) {
		return handler.submit(parameter, QueryP2PBusinessUserInfoResponse.class);
	}

	/**
	 * 投标
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public TenderBorrowResponse tender(TenderBorrowParam parameter) {
		return handler.submit(parameter, TenderBorrowResponse.class);
	}

	/**
	 * 流标
	 *
	 * @param parameter
	 * @return
	 */
	@Override
	public FlowBorrowResponse flow(FlowBorrowParam parameter) {
		return handler.submit(parameter, FlowBorrowResponse.class);
	}

	/**
	 * 满标放款
	 *
	 * @param parameter 满标参数
	 * @return 满标结果
	 */
	@Override
	public FullBorrowLoanResponse loan(FullBorrowLoanParam parameter) {
		return handler.submit(parameter, FullBorrowLoanResponse.class);
	}

	/**
	 * 还款
	 *
	 * @param parameter 还款参数
	 * @return 还款结果
	 */
	@Override
	public RepayBorrowResponse repay(RepayBorrowParam parameter) {
		return handler.submit(parameter, RepayBorrowResponse.class);
	}

	@Override
	public HtmlResponse creditByPage(CreditByPageParameter parameter) {
		return handler.submit(parameter, HtmlResponse.class);
	}

}
