package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.BindingBankCardCodeResponse;
import com.qd.p2p.adapter.response.BindingBankCardResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 绑定银行卡验证码（服务端接口） 返回参数
 *
 * @author Huan Wu
 * @version V1.0.0
 * @date 2016-4-5
 */
@XStreamAlias(value = "crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = BindingBankCardResponse.class)
public class BaofooBindingBankCardResponse extends AbstractResponse
		implements ResponseAdapter<BindingBankCardResponse> {
	private static final long serialVersionUID = -7420008016868951969L;
	
	@XStreamAlias("card_id")
	private String cardId;

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Override
	public BindingBankCardResponse adapter() {
		BindingBankCardResponse response = new BindingBankCardResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		response.setCardId(cardId);
		return response;
	}
}
