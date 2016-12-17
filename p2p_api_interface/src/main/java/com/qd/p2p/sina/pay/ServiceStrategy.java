package com.qd.p2p.sina.pay;

public enum ServiceStrategy {

    //2.1	创建激活会员
    CREATE_ACTIVATE_MEMBER("创建激活会员","create_activate_member"),
  
    //2.2	设置实名信息
    SET_REAL_NAME("设置实名信息", "set_real_name"),
    
    //2.3	绑定认证信息
    BINDING_VERIFY("设置实名信息", "binding_verify"),

    //2.4	解绑认证信息
    UNBINDING_VERIFY("解绑认证信息", "unbinding_verify"),
    
    //2.5	查询认证信息
    QUERY_VERIFY("查询认证信息", "query_verify"),

    //2.6	绑定银行卡
    BINDING_BANK_CARD("绑定银行卡", "binding_bank_card"),
    
    //2.7	绑定银行卡推进
    BINDING_BANK_CARD_ADVANCE("", "binding_bank_card_advance"),

    //2.8	解绑银行卡
    UNBINDING_BANK_CARD("解绑银行卡", "unbinding_bank_card"),

    //2.9	查询银行卡
    QUERY_BANK_CARD("查询银行卡", "query_bank_card"),

    //2.10	查询余额/基金份额
    QUERY_BALANCE("查询余额/基金份额", "query_balance"),

    //2.11	查询收支明细
    QUERY_ACCOUNT_DETAILS("查询收支明细", "query_account_details"),
    
    //2.12	冻结余额
    BALANCE_FREEZE("冻结余额", "balance_freeze"),
    
    //2.13	解冻余额
    BALANCE_UNFREEZE("解冻余额", "balance_unfreeze"),
    
    //2.14	请求审核企业会员资质
    AUDIT_MEMBER_INFOS("请求审核企业会员资质", "audit_member_infos"),
    
    //2.17	sina页面展示用户信息
    SHOW_MEMBER_INFOS_SINA("sina页面展示用户信息", "show_member_infos_sina"),
    
    //2.18	查询冻结解冻结果
    QUERY_CTRL_RESULT("查询冻结解冻结果", "query_ctrl_result"),

    //3.1	创建托管代收交易
    CREATE_HOSTING_COLLECT_TRADE("创建托管代收交易", "create_hosting_collect_trade"),
    
    //3.2	创建托管代付交易
    CREATE_SINGLE_HOSTING_PAY_TRADE("创建托管代付交易", "create_single_hosting_pay_trade"),
    
    //3.4	托管交易支付
    PAY_HOSTING_TRADE("托管交易支付", "pay_hosting_trade"),
    
    //3.5	支付结果查询
    QUERY_PAY__RESULT("支付查询", "query_pay_result"),
    
    //3.6	托管交易查询
    QUERY_HOSTING_TRADE("托管交易查询", "query_hosting_trade"),

    //3.8	托管退款
    CREATE_HOSTING_REFUND("托管退款", "create_hosting_refund"),

    //3.9	托管退款查询
    QUERY_HOSTING_REFUND("托管退款查询", "query_hosting_refund"),
    
    //3.10	托管充值
    CREATE_HOSTING_DEPOSIT("充值", "create_hosting_deposit"),
    
    //3.11	托管充值查询
    QUERY_HOSTING_DEPOSIT("托管充值查询", "query_hosting_deposit"),
        
    //3.12	托管提现
    CREATE_HOSTING_WITHDRAW("充值提现", "create_hosting_withdraw"),
    
    //3.13	托管提现查询
    QUERY_HOSTING_WITHDRAW("托管提现查询", "query_hosting_withdraw"),
    
    //3.14	转账接口
    CREATE_HOSTING_TRANSFER("转账接口", "create_hosting_transfer"),
    
    //3.15	支付推进
    ADVANCE_HOSTING_PAY("支付推进", "advance_hosting_pay"),
    
    //5.1	存钱罐基金收益率查询
    QUERY_FUND_YIELD("存钱罐基金收益率查询", "query_fund_yield");

    String serviceCnName;        //服务名称
    String serviceEnName;        //服务编号

    ServiceStrategy(String serviceChName, String serviceEnName) {
        this.serviceCnName = serviceChName;
        this.serviceEnName = serviceEnName;
    }

    public String getServiceEnName() {
        return serviceEnName;
    }
}
