package com.qd.p2p.sina.pay.response;


import java.io.Serializable;

import com.qd.p2p.sina.pay.IResponse;

/**
 * 该接口扩展了IResponse接口功能，提供IResponse中属性为实体类型的解析。
 * 如果一个IResponse实现类中需要获取List<Entity>的属性，则需要实现IEntityResponse接口
 * 	如下：
 *     @Param(value="detail_list", type=ParamType.ENTITY)
 *     List<Entity> list;
 * 
 * 这样会通过DefaultEntityParamTypeParser解析器将detail_list对应的数据，解析成List<Entity>
 * 
 * @author linya 2015-12-23
 * @see QueryAccountDetailsResponse
 * @see DefaultEntityParamTypeParser
 */
public interface IEntityResponse extends IResponse{

	//实体数据分隔符
	String DATA_SPLITER = "|";
	
	//属性数据分隔符
	String FEILED_SPLITER = "^";
	
	/**
	 * 获取IEntityResponse中，具体关联的IEntity实体对象
	 * @return
	 */
	Class<? extends IEntity> getEntityClass();
	
	/**
	 * 定义需要解析的属性列表
	 * @return
	 */
	String[] getPlaceholderFields();
	
	/**
	 * IResponse实体类接口
	 */
	interface IEntity extends Serializable{
		
	}
}
