package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.TransferAccountsResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 单笔转账（服务端接口） 返回参数
 *
 * @author ygw
 * @version V1.0.0
 * @date 2016-4-5
 */
@SuppressWarnings("serial")
@XStreamAlias(value="crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass= TransferAccountsResponse.class)
public class BaofooTransferAccountsResponse extends AbstractResponse implements ResponseAdapter<TransferAccountsResponse> {
	
	@Override
	public TransferAccountsResponse adapter() {
		TransferAccountsResponse response = new TransferAccountsResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		return response;
	}
}
