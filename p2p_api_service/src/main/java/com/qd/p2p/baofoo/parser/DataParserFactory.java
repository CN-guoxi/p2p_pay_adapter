package com.qd.p2p.baofoo.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.util.Log;
import com.qd.p2p.commons.ScanPackageUtil;

public class DataParserFactory {

	//DataParser实现类
	private static Map<ParserSupportKey, DataParser> parserMap;
	
	//匹配过的DataParser
	private static Map<ParserSupportKey, DataParser> matchedParserMap = new HashMap<ParserSupportKey, DataParser>();
	
	
	/**
	 * 获取匹配的DataParser
	 * @param param
	 * @param dataType
	 * @return
	 * @throws RequestHandlerException
	 */
	public static DataParser getDataParser(IRequestParam param, DataType dataType) throws RequestHandlerException{
		
		//初始化解析器实例
		if(parserMap == null){
			synchronized(DataParserFactory.class){
				newAllDadaParserInstance();
			}
		}
		
		//从缓存中获取
		Class<? extends IRequestParam> targetClass = param.getClass();
		DataParser parser = findFormSuperOrInterface(targetClass, targetClass, dataType);
		if(parser != null){
			return parser;
		}
		
		//查找接口匹配
		Class<?>[] interfaceClasses = targetClass.getInterfaces();
		if(interfaceClasses != null){
			for(int i = 0; i < interfaceClasses.length; i ++){
				parser = findFormSuperOrInterface(targetClass, interfaceClasses[i], dataType);
				if(parser != null){
					return parser;
				}
			}
		}
		
		//查找父类匹配
		Class<?> clazz = targetClass.getSuperclass();
		while(clazz != null){
			parser = findFormSuperOrInterface(targetClass, clazz, dataType);
			if(parser != null){
				break;
			}
            clazz = clazz.getSuperclass();
		}
		
		return parser;
	}
	
	
	/**
	 * 从接口或父类匹配数据解析器
	 * @param targetClass
	 * @param superOrInterfaceClass
	 * @param dataType
	 * @return
	 */
	private static DataParser findFormSuperOrInterface(Class<?> targetClass, Class<?> superOrInterfaceClass, DataType dataType){
		ParserSupportKey key = new ParserSupportKey(superOrInterfaceClass, dataType);
		DataParser parser = parserMap.get(key);
        if(parser != null){
        	ParserSupportKey trueKey = new ParserSupportKey(targetClass, dataType);
        	matchedParserMap.put(trueKey, parser);
        }
        return parser;
	}

	
	/**
	 * 获取所有的DataParser接口实现类
	 * @return
	 */
	private static void newAllDadaParserInstance(){
		
		//获取所有DataParser接口实现类型
		Set<Class<DataParser>> classes = ScanPackageUtil.getClasses(DataParser.class.getPackage().getName(), DataParser.class);
		
		//实例化
		parserMap = new HashMap<ParserSupportKey, DataParser>();
		
		//遍历
		for(Class<DataParser> parserType: classes){
			DataParser parser = newInstance(parserType);
			if(parser != null){
				Class<? extends IRequestParam> requestParamClass = parser.supportsRequestParam();
				DataType dataType = parser.supportsDataType();
				parserMap.put(new ParserSupportKey(requestParamClass, dataType), parser);
			}
		}
		
	}
	
	/**
	 * 实例化DataParser
	 * @param parserType
	 * @return
	 */
	private static DataParser newInstance(Class<DataParser> parserType){
		DataParser parser = null;
		try {
			parser = parserType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("++++ " + parserType.getName() + "is not a default constructor", e);
		}
		
		return parser;
	}
	
	/**
	 * 定义缓存key，根据请求类型和数据格式区分
	 * @author linya
	 */
	private static class ParserSupportKey{
		
		Class<?> requestParamType;
		
		DataType dataType;
		
		ParserSupportKey(Class<?> requestParamType, DataType dataType){
			this.requestParamType = requestParamType;
			this.dataType = dataType;
		}

		@Override
		public int hashCode() {
			int hashCode = 17;
			hashCode = hashCode * 37 + requestParamType.hashCode();
			hashCode = hashCode * 37 + dataType.name().hashCode();
			return hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			
			if(obj == this){
				return true;
			}
			
			if(!(obj instanceof ParserSupportKey)){
				return false;
			}
			
			ParserSupportKey supportKey = (ParserSupportKey)obj;
			
			return requestParamType.equals(supportKey.requestParamType) && dataType.equals(supportKey.dataType);
		}
		
	}
}
