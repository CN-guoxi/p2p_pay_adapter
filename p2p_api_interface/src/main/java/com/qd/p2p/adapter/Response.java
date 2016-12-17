package com.qd.p2p.adapter;

import java.io.Serializable;

import com.qd.p2p.adapter.enums.ResponseStatus;

public interface Response extends Serializable{

	boolean isSuccess();
	
	ResponseStatus getStatus();
	
	String getResponseCode();

	String getResponseMsg();

	void setStatus(ResponseStatus status);

	void setResponseCode(String responseCode);

	void setResponseMsg(String responseMsg);

}
