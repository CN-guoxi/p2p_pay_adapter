package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BankCardListParameter;
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
@Strategy(value=ServiceStrategy.GET_BANK_CARD_LIST)
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=BankCardListParameter.class)
public class BaofooBankCardListParam extends AbstractRequestParam implements ParameterAdapter<BankCardListParameter> {

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public void adapter(BankCardListParameter bankCardListParameter) {
		this.userId = bankCardListParameter.getPlatformUserId();
	}
}
