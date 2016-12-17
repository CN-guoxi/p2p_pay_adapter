package com.qd.p2p.sina.pay.param;

import com.qd.p2p.sina.pay.ServiceStrategy;
import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;
import com.qd.p2p.sina.pay.enums.Strategy;
import org.apache.commons.lang3.StringUtils;

/**
 * 托管退款查询
 */
@Strategy(ServiceStrategy.QUERY_HOSTING_REFUND)
public class QueryHostingRefundParam extends AbstractRequestParam {

    @Param(enabled = false)
    private static final long serialVersionUID = 0x2b6656c4f6efc3e6L;

    /**用户标识信息*/
    @Param(value = "identity_id", required = true)
    private String identityId;

    /**用户标识类型*/
    @Param(value = "identity_type", required = true)
    private String identityType;

    /**退款订单号*/
    @Param("out_trade_no")
    private String outTradeNo;

    /**开始时间*/
    @Param("start_time")
    private String startTime;

    /**结束时间*/
    @Param("end_time")
    private String endTime;

    /**扩展信息*/
    @Param("extend_param")
    private String extendParaml;

    /**页号*/
    @Param(value = "page_no", type = ParamType.INT)
    private int pageNo;

    /**每页大小*/
    @Param(value = "page_size", type = ParamType.INT)
    private int pageSize;

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

    public String getExtendParaml() {
        return extendParaml;
    }

    public void setExtendParaml(String extendParaml) {
        this.extendParaml = extendParaml;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
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