package com.qd.p2p.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付接口参数
 * @author linya
 */
@SuppressWarnings("serial")
public class AbstractParameter implements Parameter{

	Map<String, Object> extraParameter = new HashMap<String, Object>();
	
	@Override
	public void addExtraParameter(String key, Object value) {
		extraParameter.put(key, value);
	}

	@Override
	public Object getExtraParameter(String key) {
		return extraParameter.get(key);
	}

}
