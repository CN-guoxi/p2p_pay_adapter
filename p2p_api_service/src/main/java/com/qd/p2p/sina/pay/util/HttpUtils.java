package com.qd.p2p.sina.pay.util;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.qd.p2p.sina.pay.Constant;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Map;

/**
 *
 */
public class HttpUtils {

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static Map<String, Object> sendPost(String url, String param, String charset) {
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        Map<String, Object> resultMap = Maps.newHashMap();
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();  // 打开和URL之间的连接
            conn.setRequestProperty("accept", "*/*");  // 设置通用的请求属性
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            printWriter = new PrintWriter(conn.getOutputStream()); // 获取URLConnection对象对应的输出流
            printWriter.print(param); // 发送请求参数
            printWriter.flush();// flush输出流的缓冲
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream())); // 定义BufferedReader输入流来读取URL的响应
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            String result = URLDecoder.decode(sb.toString(), charset);
            resultMap.put("req_status", Constant.SUCCESS);

            // 返回的是否是html
            if (result.contains("doctype html")) {
                resultMap.put("req_html", result);
            } else {
                Gson gson = new Gson();
                resultMap = gson.fromJson(result, Map.class);
            }
            resultMap.put("req_status", Constant.SUCCESS);
        } catch (SocketTimeoutException e) {
            resultMap.put("req_status", Constant.TIME_OUT);

            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } catch (Exception e) {
            resultMap.put("req_status", Constant.UNKNOWN_ERROR);

            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } finally { // 使用finally块来关闭输出流、输入流
            IOUtils.closeQuietly(printWriter);
            IOUtils.closeQuietly(bufferedReader);
        }
        return resultMap;
    }
}