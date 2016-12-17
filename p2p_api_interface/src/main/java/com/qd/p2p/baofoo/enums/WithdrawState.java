package com.qd.p2p.baofoo.enums;

/**
 * 宝付资金托管提现状态
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-04-12
 */
public enum WithdrawState {

    FAIL(-1, "失败"),
    INIT(0, "初始化"),
    SUCCESS(1, "成功"),
    PROCESSING(5, "转账处理中");

    int state;
    String name;

    WithdrawState(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public static String getName(int state) {
        for (WithdrawState entry : WithdrawState.values()) {
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
