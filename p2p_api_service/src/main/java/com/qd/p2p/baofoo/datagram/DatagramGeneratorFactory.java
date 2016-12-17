package com.qd.p2p.baofoo.datagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.util.Log;
import com.qd.p2p.commons.ScanPackageUtil;

/**
 * 获取报文生成器工厂类
 * @author linya
 */
public class DatagramGeneratorFactory {

	//所有DatagramGenerator实例对象
	private static Map<Class<? extends IRequestParam>, DatagramGenerator<?>> datagramGeneratorMap;
	
	//匹配过的请求参数对应的DatagramGenerator，避免重复遍历父类
	private static Map<Class<? extends IRequestParam>, DatagramGenerator<?>> matchedDatagramdGeneratorMap = new HashMap<Class<? extends IRequestParam>, DatagramGenerator<?>>();
	
	/**
	 * 获取请求参数对应的报文生成器
	 * @param param
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static DatagramGenerator getDatagramGenerator(IRequestParam param){
		
		//初始化报文生成器
		if(datagramGeneratorMap == null){
			synchronized(DatagramGeneratorFactory.class){
				newAllDatagramGeneratorInstance();
			}
		}
		
		//从缓存中获取
		Class<? extends IRequestParam> targerClass = param.getClass();
		DatagramGenerator<?> generator = matchedDatagramdGeneratorMap.get(targerClass);
		if(generator != null){
			return generator;
		}
		
		//查找父类匹配
		Class<?> clazz = targerClass;
		while(clazz != null){
            generator = datagramGeneratorMap.get(clazz);
            if(generator != null){
            	matchedDatagramdGeneratorMap.put(targerClass, generator);
            	break;
            }
            clazz = clazz.getSuperclass();
		}
		
		return generator;
	}

	
	/**
	 * 实例化所有的DatagramGenerator接口实现类
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static void newAllDatagramGeneratorInstance(){
		
		//获取所有DataParser接口实现类型
		Set<Class<DatagramGenerator>> classes = ScanPackageUtil.getClasses(DatagramGenerator.class.getPackage().getName(), DatagramGenerator.class);
		
		//实例化
		datagramGeneratorMap = new HashMap<Class<? extends IRequestParam>, DatagramGenerator<?>>();
		
		//遍历
		for(Class<DatagramGenerator> parserType: classes){
			DatagramGenerator<?> generator = newInstance(parserType);
			if(generator != null){
				Class<? extends IRequestParam> supportParamType = generator.supportsRequestParam();
				datagramGeneratorMap.put(supportParamType, generator);
			}
		}
		
	}
	
	
	/**
	 * 实例化DatagramGenerator对象
	 * @param generatorType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static DatagramGenerator<?> newInstance(Class<DatagramGenerator> generatorType){
		DatagramGenerator<?> generator = null;
		try {
			generator = generatorType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("++++ " + generatorType.getName() + "is not a default constructor", e);
		}
		
		return generator;
	}	
	
}
