package com.qd.p2p.baofoo.datagram;

import com.qd.p2p.baofoo.IRequestParam;

/**
 * 报文生成器
 * @author linya
 */
public interface DatagramGenerator<T extends IRequestParam> {

	/**
	 * 定义支持的请求参数类型
	 * @param param
	 * @return
	 */
	Class<T> supportsRequestParam();
	
	/**
	 * 生成请求报文
	 * @param param     请求参数
	 * @param content   参数内容
	 * @param sign		签名
	 */
	String generate(T param, String content, String sign);
	
}
