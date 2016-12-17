package com.qd.p2p.baofoo.enums;

/**
 * 宝付资金托管账户类型
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-04-13
 */
public enum AccountType {

    NORMAL(0, "普通用户"),
    MERCHANT(1, "商户号");

    int type;
    String name;

    AccountType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(int type) {
        for (AccountType entry : AccountType.values()) {
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
