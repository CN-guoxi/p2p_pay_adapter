package com.qd.p2p.baofoo.enums;

/**
 * 宝付资金托管费用收取方类型
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-04-13
 */
public enum FeeTakenOnType {

    PAYER(0, "付款方"),
    PAYEE(1, "收款方");

    int type;
    String name;

    FeeTakenOnType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(int type) {
        for (FeeTakenOnType entry : FeeTakenOnType.values()) {
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
