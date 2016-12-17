package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.BindingAccountCodeResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 绑定宝付账号验证码（服务端接口） 返回参数
 *
 * @author Huan Wu
 * @version V1.0.0
 * @date 2016-4-5
 */
@XStreamAlias(value = "crs")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = BindingAccountCodeResponse.class)
public class BaofooBindingAccountCodeResponse extends AbstractResponse
		implements ResponseAdapter<BindingAccountCodeResponse> {
	private static final long serialVersionUID = -7420008016868951969L;
	// 结果信息
	private String msg;

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public BindingAccountCodeResponse adapter() {
		BindingAccountCodeResponse response = new BindingAccountCodeResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		return response;
	}
}
