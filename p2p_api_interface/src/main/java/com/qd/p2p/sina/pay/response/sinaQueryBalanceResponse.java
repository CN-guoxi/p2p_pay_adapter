package com.qd.p2p.sina.pay.response;

import com.qd.p2p.sina.pay.enums.Param;
import com.qd.p2p.sina.pay.enums.ParamType;

/**
 * 查询余额/基金份额
 */
@SuppressWarnings("serial")
public class sinaQueryBalanceResponse extends AbstractResponse {

    // 余额/基金份额，单位为：RMB Yuan。精确到小数点后两位。
    @Param(value="balance", type=ParamType.DOUBLE)
    private Double balance;

    //可用余额/基金份额，单位为：RMB Yuan。精确到小数点后两位。
    @Param(value="available_balance", type=ParamType.DOUBLE)
    private Double availableBalance;

    //存钱罐收益, 参数格式：昨日收益^最近一月收益^总收益。
    @Param("bonus")
    private String bonus;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
}
