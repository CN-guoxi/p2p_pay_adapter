package com.qd.p2p.baofoo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.qd.p2p.baofoo.util.Log;

public class ConfigurationConsts {
	
	private static final String PREFIX = "baofoo.";
	
	//版本号
	public static String VERSION;
	
	//宝付商户号
	public static String MERCHANT_ID;
	
	//终端号
	public static String TERMINAL_ID;
	
	//数据类型
	public static String DATA_TYPE = "xml";
	
	//加密键密码
	public static String KEY_PWD;
	
	//宝付URL域名
	public static String DOMAIN;

	//充值手续费
	public static String FEE;

	//费用承担方(宝付收取的费用)
	public static String FEE_TAKEN_ON;

	//充值页面资源请求url
	public static String PAGE_URL;
	
	/**
	 * 初始化属性域信息
	 * @param props
	 */
	public static void init(Properties props){
		String currentField = null;
		List<String> emptyFields = new ArrayList<String>();
		try {
			Field[] fields = ConfigurationConsts.class.getDeclaredFields();
			for(Field f: fields){
				currentField = StringUtils.lowerCase(f.getName());
				
				//过滤掉final属性
				if((f.getModifiers() & Modifier.FINAL) != 0){
					continue;
				}
				
				//获取配置文件中的属性值
				Object value = props.get(PREFIX + currentField);
				if(value == null){
					emptyFields.add(currentField);
				}
				//设置属性值
				f.set(null, String.valueOf(value));
			}
		} catch (Exception e) {
			Log.info("++++ 获取属性文件信息发生错误, 当前错误的键为：" + currentField, e);
			e.printStackTrace();
		}finally{
			if(!emptyFields.isEmpty()){
				Log.info("++++ 获取属性文件信息，还没有设置的属性有：" + Arrays.toString(emptyFields.toArray()));
			}
		}
	}
}
