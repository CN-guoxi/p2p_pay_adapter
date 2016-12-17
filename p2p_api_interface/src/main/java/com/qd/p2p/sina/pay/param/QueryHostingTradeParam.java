package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.Strategy;
import org.apache.commons.lang3.StringUtils;

/**
 * 托管交易查询
 */
@Strategy(ServiceStrategy.QUERY_HOSTING_TRADE)
public class QueryHostingTradeParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0255462554236673741746L;

    /**用户标识信息*/
    @Param(value = "identity_id")
    private String identityId;

    /**用户标识类型*/
    @Param(value = "identity_type")
    private String identityType;

    /**交易订单号*/
    @Param(value = "out_trade_no")
    private String outTradeNo;

    /**开始时间*/
    @Param("start_time")
    private String startTime;

    /**结束时间*/
    @Param("end_time")
    private String endTime;

    /**扩展信息*/
    @Param("extend_param")
    private String extendParam;

    /**页号*/
    @Param("page_no")
    private String pageNo;

    /**每页大小*/
    @Param("page_size")
    private String pageSize;

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExtendParam() {
        return extendParam;
    }

    public void setExtendParam(String extendParam) {
        this.extendParam = extendParam;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 约束性判断，子类实现
     *
     * @return
     */
    @Override
    public boolean restrictCheck() {
        if(StringUtils.isEmpty(outTradeNo))
        {
            return StringUtils.isNotEmpty(startTime)&&StringUtils.isNotEmpty(endTime);
        } else {
            return true;
        }
    }
}