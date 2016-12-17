package com.qd.p2p.baofoo;

import com.qd.p2p.baofoo.enums.ParamType;

/**
 * 负责解析IResponse实现中属性值的Java类型
 * @author linya 2015-12-23
 * @see Param
 * @see ParamType
 * @see IResponse
 */
public interface IParamTypeParser {

	/**
	 * 该解析器是否支持对paramType的解析
	 * @param paramType
	 * @return
	 */
	boolean supports(ParamType paramType);
	
	/**
	 * 解析处理给定的value值
	 * @param value    ParamType 类型
	 * @param value    需要被解析的值
	 * @param attachmentObject   附件对象（支持处理的对象）
	 * @return
	 */
	public Object parse(ParamType paramType, Object value, Object attachmentObject);
	
}
