package com.qd.p2p.baofoo.enums;

/**
 * 宝付资金托管业务查询类型
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-04-12
 */
public enum P2pBizType {

    TENDER(1, "投标"),
    FULL(2, "满标"),
    FLOW(3, "流标"),
    REPAY(4, "还款"),
    RECHARGE(5, "充值"),
    WITHDRAW(6, "提现"),
    TRANSFER(7, "转账"),
    USER(8, "用户信息");

    int type;
    String name;

    P2pBizType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(int type) {
        for (P2pBizType entry : P2pBizType.values()) {
            if (entry.type == type) {
                return entry.name;
            }
        }
        return "";
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
