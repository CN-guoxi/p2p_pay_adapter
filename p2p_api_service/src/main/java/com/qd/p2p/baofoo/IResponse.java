package com.qd.p2p.baofoo;

import java.io.Serializable;

import com.qd.p2p.adapter.enums.ResponseStatus;

/**
 * 定义请求响应接口
 *
 * @author linya 2015-11-30
 */
public interface IResponse extends Serializable {

    /**
     * 请求是否成功
     * @return
     */
    boolean success();
    
    /**
     * 请求状态
     * @return
     */
    ResponseStatus getStatus();
    
    /**
     * 请求状态
     * @param status
     */
    void setStatus(ResponseStatus status);
    
    /**
     * 获取错误码
     * @return
     */
    String getCode();
    
    /**
     * 设置错误消息
     * @param msg
     */
    void setMsg(String msg);
}
