package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.BindingAccountCodeParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * (三.一)绑定宝付账号验证码（服务端接口）请求参数
 *
 * @author Huan wu
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@Strategy(ServiceStrategy.SEND_BINDCODE_BY_SERVER)
@XStreamAlias("custody_req")
@Adapted(value = AdaptePlatform.BAOFOO, adaptedClass = BindingAccountCodeParameter.class)
public class BaofooBindingAccountCodeParam extends AbstractRequestParam
		implements ParameterAdapter<BindingAccountCodeParameter>, ITxtRequestParam {

	// 请求参数（文本类型）
	private String requestParams;

	@Override
	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	@Override
	public void adapter(BindingAccountCodeParameter t) {
		this.requestParams = t.getAccount();
	}
}
