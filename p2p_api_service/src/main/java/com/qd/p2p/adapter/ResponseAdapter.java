package com.qd.p2p.adapter;

/**
 * 响应适配器
 * @author linya
 */
public interface ResponseAdapter<T extends Response> {
	
	T adapter();
	
}
