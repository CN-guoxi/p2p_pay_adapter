package com.qd.p2p.baofoo.param;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ParameterAdapter;
import com.qd.p2p.adapter.param.ExportP2PBusinessToExcelParameter;
import com.qd.p2p.baofoo.ServiceStrategy;
import com.qd.p2p.baofoo.enums.Strategy;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.23查询EXCEL导出 请求参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@Strategy(ServiceStrategy.EXPORT_P2P_BUSINESS_TO_EXCEL)
@XStreamAlias("custody_req")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=ExportP2PBusinessToExcelParameter.class)
public class BaofooExportP2PBusinessToExcelParam extends AbstractRequestParam implements IExcelRequestParam, ParameterAdapter<ExportP2PBusinessToExcelParameter> {

    // 查询开始时间毫秒数，查询周期最多为3天
    @XStreamAlias("start_time")
    private Long startTime;

    // 查询结束时间毫秒数，查询周期最多为3天
    @XStreamAlias("end_time")
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

    @Override
    public void adapter(ExportP2PBusinessToExcelParameter t) {
        this.startTime = t.getStartTime();
        this.endTime = t.getEndTime();
    }
}
