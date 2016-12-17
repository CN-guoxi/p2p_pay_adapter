package com.qd.p2p.adapter.response;

import com.qd.p2p.adapter.AbstractResponse;

/**
 * 响应-查询业务数据导出到Excel
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-04-08
 */
public class ExportP2PBusinessToExcelResponse extends AbstractResponse {

    // 导出的Excel文件路径
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}
