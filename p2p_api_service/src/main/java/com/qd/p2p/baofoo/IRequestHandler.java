package com.qd.p2p.baofoo;

/**
 * 请求处理对象
 * RequestParam 封装请求参数，
 * 发起http请求，返回指定的responseClass类型的响应实例。
 * @author linya 2015-12-22
 */
public interface IRequestHandler {
	

	/**
	 * 获取单一的响应对象
	 * @param IRequestParam
	 * @param responseClass
	 * @return
	 */
	<T extends IResponse> T submit(IRequestParam IRequestParam, Class<T> responseClass);
	
}
