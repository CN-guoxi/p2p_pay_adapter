package com.qd.p2p.baofoo.response;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.enums.ResponseStatus;
import com.qd.p2p.adapter.response.BindingAccountResponse;
import com.qd.p2p.baofoo.enums.ResponseCode;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias(value = "crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = BindingAccountResponse.class)
public class BaofooBindingAccountResponse extends AbstractResponse implements ResponseAdapter<BindingAccountResponse> {

	// 结果信息
	private String msg;
	private boolean hasAccount;

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isHasAccount() {
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}

	@Override
	public BindingAccountResponse adapter() {
		BindingAccountResponse response = new BindingAccountResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		response.setHasAccount(ResponseCode.BD009.name().equalsIgnoreCase(getCode()));
		return response;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
