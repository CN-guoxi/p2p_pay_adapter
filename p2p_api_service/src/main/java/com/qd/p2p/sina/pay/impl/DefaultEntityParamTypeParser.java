package com.qd.p2p.sina.pay.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.qd.p2p.sina.pay.IParamTypeParser;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.response.IEntityResponse;
import com.qd.p2p.sina.pay.response.IEntityResponse.IEntity;
import com.qd.p2p.sina.pay.util.DataUtils;

/**
 * IEntityResponse接口的解析处理，
 * 对IResponse中@param(type=ParamType.ENTITY)的属性进行解析处理
 * 
 * @author linya
 */
public class DefaultEntityParamTypeParser implements IParamTypeParser{
	
	 private static final Logger log = Logger.getLogger(DefaultEntityParamTypeParser.class);
	
	//实体数据分隔符|
	String DATA_SPLITER = "\\|";
	
	//属性数据分隔符
	String FEILED_SPLITER = "\\^";
	
	IParamTypeParser paramTypeParser = new PrimitiveParamTypeParser();

	/**
	 * 只支持IResponse中@param(type=ParamType.ENTITY)属性的解析
	 * @param paramType
	 * @return
	 */
	@Override
	public boolean supports(ParamType paramType) {
		return ParamType.ENTITY.equals(paramType);
	}

	@Override
	public Object parse(ParamType paramType, Object value, Object attachmentObject) {
		if(!(attachmentObject instanceof IEntityResponse)){
			throw new IllegalArgumentException("++++ attachmentObject is not a subclass of IEntityResponse");
		}
		IEntityResponse entityResponse = (IEntityResponse) attachmentObject;
		Class<? extends IEntityResponse.IEntity> entityClass = entityResponse.getEntityClass();
		return convert2Entites(value, entityResponse.getPlaceholderFields(), entityClass);
	}
	
	protected <T extends IEntity> List<T> convert2Entites(Object dataList, String[] placeholderFields, Class<T> entityClass) {
		
		String data = DataUtils.toString(dataList);
		if(StringUtils.isEmpty(data)){
			return Collections.emptyList();
		}
		
		//获取每个Entity数据
		String[] rows = data.split(DATA_SPLITER);
		
		//获取对应的Method
		Method[] writeMethods = new Method[placeholderFields.length];
		Field[] fields = new Field[placeholderFields.length];
		String currentFieldName = null;
		try {
			for(int i = 0; i < placeholderFields.length; i ++){
				currentFieldName = placeholderFields[i];
				fields[i] = entityClass.getDeclaredField(currentFieldName);
				PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(entityClass, currentFieldName);
				writeMethods[i] = pd.getWriteMethod();
			}
		} catch (Exception e) {
			log.info("++++ 解析响应发生错误：" + entityClass.getSimpleName() + ",错误字段：" + currentFieldName);
			e.printStackTrace();
		}
		
		//构建Entity
		List<T> list = new ArrayList<T>();
		for(String row: rows){
			String[] attributeValues = row.split(FEILED_SPLITER);
			T entity = populateEntity(writeMethods, fields,  attributeValues, entityClass);
			list.add(entity);
		}
		
		return list;
	}

	protected <T extends IEntity> T populateEntity(Method[] writeMethods, Field[] fields, String[] attributeValues, Class<T> entityClass){
		T entity = null;
		Field f = null;
		try {
			entity = entityClass.newInstance();
			for(int i = 0; i < fields.length; i ++){
				f = fields[i];
				Param param = f.getAnnotation(Param.class);
				ParamType type;
				if(param != null){
					type = param.type();
				}else{
					type = ParamType.STRING;
				}
				Object val = paramTypeParser.parse(type, attributeValues[i], null);
				Method method = writeMethods[i];
				method.invoke(entity, val);
			}
		} catch (Exception e) {
			log.info("++++ 解析响应发生错误：" + entityClass.getSimpleName() + ", 属性：" + f.getName());
		}
		
		return entity;
	}

}
