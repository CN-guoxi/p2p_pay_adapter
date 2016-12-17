package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BankCardListForEnterpriseParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;

/**
 * (十九)获取会员银行卡（列表）信息请求参数
 *
 * @author linya
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(value=ServiceStrategy.GET_BANK_CARD_LIST_FOR_ENTERPRISE)
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=BankCardListForEnterpriseParameter.class)
public class BaofooBankCardListForEnterpriseParam extends AbstractRequestParam implements ParameterAdapter<BankCardListForEnterpriseParameter> {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public void adapter(BankCardListForEnterpriseParameter bankCardListParameter) {
		this.userId = bankCardListParameter.getPlatformUserId();
	}
}
