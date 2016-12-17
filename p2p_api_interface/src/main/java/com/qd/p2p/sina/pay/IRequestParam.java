package com.qd.p2p.sina.pay;

import java.io.Serializable;
import java.util.Map;

/**
 * 定义查询参数接口
 *
 * @author linya 2015-11-27
 */
public interface IRequestParam extends Serializable {
    /**
     * 将RequestParam对象的属性处理成Map
     * 如果属性没有加@Param注解，则按照属性名作为key，
     * 如果属性设置了@Param注解并且enabled为true，则按注解作为key。（enabled=false，表示该属性不加入Map参数）
     */
    Map<String, Object> toMap();

    /**
     * 获取服务名
     */
    String getServiceName();

    /**
     * 获取服务名
     */
    boolean isMember();

    /**
     * 参数判断
     */
    boolean checkParameter();

}
