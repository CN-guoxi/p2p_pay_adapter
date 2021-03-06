package com.qd.p2p.baofoo.enums;

/**
 * 宝付资金托管充值状态
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-04-12
 */
public enum RechargeState {

    PROCESSING(0, "处理中"),
    SUCCESS(1, "成功");

    int state;
    String name;

    RechargeState(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public static String getName(int state) {
        for (RechargeState entry : RechargeState.values()) {
            if (entry.state == state) {
                return entry.name;
            }
        }
        return "";
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }

}
