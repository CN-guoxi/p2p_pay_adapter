package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.GenericResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("crs")
@Adapted(value=AdaptePlatform.BAOFOO, adaptedClass=GenericResponse.class)
public class BaofooGenericResponse extends AbstractResponse implements ResponseAdapter<GenericResponse>{

	@Override
	public GenericResponse adapter() {
		GenericResponse response = new GenericResponse();
		response.setResponseCode(getCode());
		response.setResponseMsg(getMsg());
		response.setStatus(getStatus());
		return response;
	}
	
}
