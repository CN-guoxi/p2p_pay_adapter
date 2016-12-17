package com.qd.p2p.baofoo.impl;

import java.io.FileNotFoundException;

import org.apache.commons.lang3.StringUtils;

import com.qd.p2p.adapter.enums.ResponseStatus;
import com.qd.p2p.baofoo.ConfigurationConsts;
import com.qd.p2p.baofoo.HttpPostHandler;
import com.qd.p2p.baofoo.IRequestHandler;
import com.qd.p2p.baofoo.IRequestParam;
import com.qd.p2p.baofoo.IResponse;
import com.qd.p2p.baofoo.RequestHandlerException;
import com.qd.p2p.baofoo.enums.ResponseCode;
import com.qd.p2p.baofoo.parser.DataParser;
import com.qd.p2p.baofoo.parser.DataParserFactory;
import com.qd.p2p.baofoo.parser.DataType;
import com.qd.p2p.baofoo.util.Log;

/**
 * 宝付请求处理器
 * <p>
 * <p>
 * 由于存在网络原因，所以标记了请求的响应状态ResponseStatus
 * </p>
 *
 * @author linya
 */
public class DefaultRequestHandler implements IRequestHandler {

    /**
     * 提交请求
     *
     * @param requestParam
     * @param responseClass
     * @return
     */
    public <T extends IResponse> T submit(IRequestParam requestParam, Class<T> responseClass) {

        T response = null;
        try {

            //获取数据解析器
            String type = ConfigurationConsts.DATA_TYPE;
            DataType dataType = DataType.getDataType(type);
            DataParser dataParser = DataParserFactory.getDataParser(requestParam, dataType);

            //待加密数据内容
            String content = dataParser.parseRequest(requestParam);

            //响应结果
            String responseString = HttpPostHandler.request(requestParam, content, dataType);

            // 将响应数据封装成Response实例
            if (StringUtils.isNotBlank(responseString)) {
                response = dataParser.parseResponse(responseString, responseClass);
                String errorMessage = ResponseCode.getErrorMessageByCode(response.getCode());
                if(errorMessage != null){
                	response.setMsg(errorMessage);
                }
            } else {
                processException(null, responseClass);
            }

        } catch (RequestHandlerException e) {
            Log.error("++++ submit request exception: " + ", url: " + requestParam.getUrlSuffix() + " request param object: " + requestParam.getClass().getName(), e);
            e.printStackTrace();
            response = processException(e, responseClass);
        }

        return response;
    }

    /**
     * 异常处理,标记接口请求状态
     *
     * @param exception
     * @param responseClass
     * @return
     */
    public <T extends IResponse> T processException(Exception exception, Class<T> responseClass) {
        T response = null;
        try {
            response = responseClass.newInstance();
            if (exception != null) {
                Throwable th = exception.getCause();
                if (th instanceof FileNotFoundException) {
                    response.setStatus(ResponseStatus.FAILURE);
                } else {
                    response.setStatus(ResponseStatus.UN_KNOW);
                }
            } else {
                response.setStatus(ResponseStatus.UN_KNOW);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
