package com.qd.p2p.baofoo.enums;

/**
 * 宝付资金托管用户状态
 *
 * @author Kaiju Zhao
 * @version 1.0.0
 * @date 2016-04-12
 */
public enum UserState {

    LOGOUT(-1, "已注销"),
    UNAUTHORIZED(0, "未授权"),
    NORMAL(1, "正常");

    int state;
    String name;

    UserState(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public static String getName(int state) {
        for (UserState entry : UserState.values()) {
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
