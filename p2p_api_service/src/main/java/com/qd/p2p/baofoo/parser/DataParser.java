package com.qd.p2p.baofoo.parser;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerException;

/**
 * 数据解析器
 * 
 * <p>
 * 请求参数根据supportsRequestParam()方法来查找具体的DataParser子类来解析特定的IRequestParam。
 * DataParser提供了对DataType的区分，DataType定义了数据格式，可以是json格式或xml格式。
 * </p>
 * 
 * <p>
 * 功能：<br/>
 * 1. 根据请求参数对象获取请求加密报文<br/>
 * 2. 将响应字符串解析成具体的响应对象<br/>
 * </p>
 * 
 * @author linya
 */
public interface DataParser {
	
	/**
	 * 定义支持的请求参数类型
	 * @param param
	 * @return
	 */
	Class<? extends IRequestParam> supportsRequestParam();
	
	/**
	 * 解析的数据类型
	 * @return
	 */
	DataType supportsDataType();
	
	/**
	 * 将IRequestParam的参数解析成字符串
	 * @param param
	 * @return
	 */
	String parseRequest(IRequestParam param) throws RequestHandlerException;
	
	/**
	 * 将响应字符串解析成响应对象
	 * @param responseString
	 * @return
	 * @throws RequestHandlerException 
	 */
	<T extends IResponse> T parseResponse(String responseString, Class<T> responseClass) throws RequestHandlerException;
	
}
