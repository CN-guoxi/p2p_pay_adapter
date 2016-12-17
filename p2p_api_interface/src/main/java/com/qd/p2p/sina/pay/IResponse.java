package com.qd.p2p.sina.pay;

import java.io.Serializable;

/**
 * 定义请求响应接口
 *
 * @author linya 2015-11-30
 */
public interface IResponse extends Serializable {

    /**
     * 获取请求状态
     * @return
     */
    String getReqStatus();
    
    void setReqStatus(String status);

    /**
     * 获取响应信息
     * @return
     */
    String getResponseMessage();

    /**
     * 获取响应码
     * @return
     */
    String getResponseCode();
    
    /**
     * 请求是否成功
     * @return
     */
    boolean success();
}
