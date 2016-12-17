package com.qd.p2p.baofoo.response;

import org.apache.commons.lang3.StringUtils;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.enums.ResponseStatus;
import com.qd.p2p.adapter.response.HtmlResponse;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.enums.ResponseCode;

@SuppressWarnings("serial")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=HtmlResponse.class)
public class BaofooHtmlResponse implements IResponse, ResponseAdapter<HtmlResponse> {

	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	@Override
	public boolean success() {
		return true;
	}
	

	@Override
	public ResponseStatus getStatus() {
		return StringUtils.isBlank(html) ? ResponseStatus.FAILURE : ResponseStatus.SUCCESS;
	}

	@Override
	public void setStatus(ResponseStatus status) {
		
	}

	@Override
	public String getCode() {
		return ResponseCode.CSD000.name();
	}

	@Override
	public void setMsg(String msg) {
		
	}

	@Override
	public HtmlResponse adapter() {
		HtmlResponse response = new HtmlResponse();
		response.setHtml(getHtml());
		response.setStatus(getStatus());
		return response;
	}
}
