package com.qd.p2p.adapter.param;

import com.qd.p2p.adapter.AbstractParameter;

/**
 * 请求参数-查询业务数据导出到Excel
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class ExportP2PBusinessToExcelParameter extends AbstractParameter {

    // 查询开始时间毫秒数，查询周期最多为3天
    private Long startTime;

    // 查询结束时间毫秒数，查询周期最多为3天
    private Long endTime;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

}
