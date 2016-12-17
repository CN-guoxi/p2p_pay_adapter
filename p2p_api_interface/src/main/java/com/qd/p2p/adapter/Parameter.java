package com.qd.p2p.adapter;

import java.io.Serializable;

/**
 * 支付接口参数
 * @author linya
 */
public interface Parameter extends Serializable{

	/**
	 * 添加扩展参数
	 * @param key
	 * @param value
	 */
	void addExtraParameter(String key, Object value);
	
	
	/**
	 * 获取扩展参数
	 * @param key
	 * @return
	 */
	Object getExtraParameter(String key);
	
}
