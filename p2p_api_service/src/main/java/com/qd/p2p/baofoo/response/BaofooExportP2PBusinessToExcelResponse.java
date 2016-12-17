package com.qd.p2p.baofoo.response;

import com.qd.p2p.adapter.AdaptePlatform;
import com.qd.p2p.adapter.Adapted;
import com.qd.p2p.adapter.ResponseAdapter;
import com.qd.p2p.adapter.response.ExportP2PBusinessToExcelResponse;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 4.23查询EXCEL导出 返回参数
 *
 * @author Kaiju Zhao
 * @version V1.0.0
 * @date 2016-4-5
 */
@XStreamAlias("crs")
@Adapted(value= AdaptePlatform.BAOFOO, adaptedClass=ExportP2PBusinessToExcelResponse.class)
public class BaofooExportP2PBusinessToExcelResponse extends AbstractResponse implements ResponseAdapter<ExportP2PBusinessToExcelResponse> {

    // 导出的Excel文件路径
    @XStreamAlias("file_path")
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public ExportP2PBusinessToExcelResponse adapter() {
        ExportP2PBusinessToExcelResponse item = new ExportP2PBusinessToExcelResponse();
        item.setFilePath(this.getFilePath());
        item.setResponseCode(this.getCode());
        item.setResponseMsg(this.getMsg());
        item.setStatus(getStatus());
        return item;
    }

}
