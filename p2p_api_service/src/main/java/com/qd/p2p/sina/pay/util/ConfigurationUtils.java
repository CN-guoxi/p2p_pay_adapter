package com.qd.p2p.sina.pay.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

public class ConfigurationUtils implements ApplicationContextAware{

	private static String propertiesFiles;
	
	private static Properties props;
	
	private static void init(){
		
		if(!StringUtils.hasText(propertiesFiles)){
			return;
		}
		
		String[] properties = propertiesFiles.split(",");
		
		if(props == null){
			props = new Properties();
		}
		
		InputStream is = null;
		try {
			for(String p: properties){
				is = Thread.currentThread().getContextClassLoader().getResourceAsStream(p);
				props.load(is);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(is != null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//初始化配置对象
		ConfigurationConsts.init(props);
	}
	
	public static String get(String key){
		return props.getProperty(key);
	}
	
	public static String get(String key, String def){
		return props.getProperty(key, def);
	}
	
	public void setPropertiesFiles(String propertiesFiles) {
		ConfigurationUtils.propertiesFiles = propertiesFiles;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		init();
	}

}
