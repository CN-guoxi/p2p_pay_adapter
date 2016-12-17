package com.qd.p2p.sina.pay.impl;

import java.util.ArrayList;
import java.util.List;

import com.qd.p2p.sina.pay.IParamTypeParser;
import com.qd.p2p.sina.pay.IResponse;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.util.DataUtils;

/**
 * 针对ParamType中基本类型的数据做解析处理
 * @author linya 2015-12-23
 * @see Param
 * @see ParamType
 * @see IResponse
 */
public class PrimitiveParamTypeParser implements IParamTypeParser {

	private static final List<ParamType> SUPPORTS = new ArrayList<ParamType>();
	
	//特殊处理Boolean型值的匹配
	private static final String[] BOOLEAN_PATTERN = new String[]{"Y", "YES"};
	
	static{
		SUPPORTS.add(ParamType.STRING);
		SUPPORTS.add(ParamType.INT);
		SUPPORTS.add(ParamType.FLOAT);
		SUPPORTS.add(ParamType.LONG);
		SUPPORTS.add(ParamType.DOUBLE);
		SUPPORTS.add(ParamType.BOOLEAN);
		SUPPORTS.add(ParamType.DATE);
		SUPPORTS.add(ParamType.CALENDER);
	}

	@Override
	public boolean supports(ParamType paramType) {
		return SUPPORTS.contains(paramType);
	}

	@Override
	public Object parse(ParamType paramType, Object value, Object attachmentObject) {
		
        if (paramType == ParamType.STRING) {
            return DataUtils.toString(value);
        } else if (paramType == ParamType.BOOLEAN) {
        	if(value != null){
        		for(String pattern: BOOLEAN_PATTERN){
        			if(pattern.equalsIgnoreCase(value.toString())){
        				return true;
        			}
        		}
        	}
            return DataUtils.toBoolean(value);
        } else if (paramType == ParamType.INT) {
            return DataUtils.toInt(value);
        } else if (paramType == ParamType.LONG) {
            return DataUtils.toLong(value);
        } else if (paramType == ParamType.FLOAT) {
            return DataUtils.toFloat(value);
        } else if (paramType == ParamType.DOUBLE) {
            return DataUtils.toDouble(value);
        } else if (paramType == ParamType.DATE) {
            return DataUtils.toDate(DataUtils.toString(value), "yyyy-MM-dd HH:mm:ss");
        } else if (paramType == ParamType.CALENDER) {
            return DataUtils.toCalendar(DataUtils.toString(value), "yyyy-MM-dd HH:mm:ss");
        }
        
        return null;
	}
	

}
