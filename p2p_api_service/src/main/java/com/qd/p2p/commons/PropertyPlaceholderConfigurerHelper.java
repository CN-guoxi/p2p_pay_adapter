package com.qd.p2p.commons;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.qd.p2p.sina.pay.util.DataUtils;

/**
 * 该类继承了PropertyPlaceholderConfigurer，用来使用Spring注入属性文件，在原来功能的基础上，暴露了属性值的获取。
 * @author linya 2016-02-18
 */
public class PropertyPlaceholderConfigurerHelper extends PropertyPlaceholderConfigurer{

	private static Properties exposedProperties;
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		exposedProperties = props;
	}
	
	public static Properties getProperties(){
		return exposedProperties;
	}
	
	private static String getRawValue(String key){
		String value = null;
		if(exposedProperties != null){
			value = exposedProperties.getProperty(key, "");
		}
		return value;
	}
	
	public static String getValue(String key){
		return DataUtils.toString(getRawValue(key));
	}
	
	public static boolean getBooleanValue(String key){
		return DataUtils.toBoolean(getRawValue(key));
	}
	
	public static int getIntegerValue(String key){
		return DataUtils.toInt(getRawValue(key));
	}
	
	public static long getLongValue(String key){
		return DataUtils.toLong(getRawValue(key));
	}
	
}
