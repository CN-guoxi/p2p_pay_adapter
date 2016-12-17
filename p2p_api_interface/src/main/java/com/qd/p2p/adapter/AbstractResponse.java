package com.qd.p2p.adapter;

import com.qd.p2p.adapter.enums.ResponseStatus;

public abstract class AbstractResponse implements Response {

    /**
     * 请求状态
     */
    ResponseStatus status;

    /**
     * 响应码
     */
    String responseCode;

    /**
     * 响应消息
     */
    String responseMsg;


    @Override
    public boolean isSuccess() {
        return ResponseStatus.SUCCESS.equals(status);
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


}
