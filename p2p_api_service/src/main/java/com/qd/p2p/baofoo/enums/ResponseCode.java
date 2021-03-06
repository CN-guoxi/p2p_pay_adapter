package com.qd.p2p.baofoo.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 宝付资金托管返回码
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-4-5
 */
public enum ResponseCode {

    CSD000("处理成功"),
    CSD333("处理失败"),
    CSD001("系统参数传入错误"),
    CSD002("系统参数缺省或请求参数不符合要求"),
    CSD003("验签失败"),
    CSD004("XML参数解析错误"),
    CSD005("宝付账户不存在"),
    CSD006("该商户不支持资金托管"),
    CSD007("该指令已存在"),
    CSD008("商户下尚无用户"),
    CSD009("该会员已注销资当前商户资金托管"),

    BD001("该宝付账户已经被绑定"),
    BD002("实名认证失败"),
    BD003("未进行实名验证"),
    BD004("平台绑定码验证失败"),
    BD005("绑定账号与账号类型不匹配"),
    BD006("信息发送失败"),
    BD007("邮箱，暂不支持，请使用手机号"),
    BD008("身份证号、姓名不能为空"),
    BD009("该会员已经存在"),

    RQ001("指令错误：每次只支持一个action"),
    RQ002("请确认该还款人的唯一性。"),
    RQ003("余额不足"),
    RQ004("单号不能重复"),
    RQ005("只能有一个借款人"),
    RQ006("满标金额，与投资金额不一致"),

    SQ002("当前用户资金托管-未授权，需先开通授权"),

    PW001("该会员不支持提现服务"),
    PW002("该会员不支持充值服务"),
    PW003("无效的手续费"),
    PW004("提现失败"),

    EX001("系统异常"),
    EX002("数据库操作异常"),
    EX003("宝付处理失败,请重试"),
    EX004("HTTP请求异常"),
    
    Z0001("HTTP请求超时"),
    Z0002("HTTP请求异常"),
    
    BD0004("客官您受累，此次绑卡失败，请确认您在银行柜面预留的手机号码与本次操作输入的一致！谢谢！");

    String msg;

    ResponseCode(String msg){
        this.msg = msg;
    }

    public static String getErrorMessageByCode(String code){
    	
    	if(StringUtils.isBlank(code)){
    		return CSD333.msg;
    	}
    	
    	for(ResponseCode responseCode: ResponseCode.values()){
    		if(responseCode.name().equalsIgnoreCase(code)){
    			return responseCode.msg;
    		}
    	}
    	return null;
    }
}
