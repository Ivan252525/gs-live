package com.gs.exception.message;

public enum ErrorInfo {

    // 操作性错误
    MISS_PARAM(1001, "参数缺失或参数格式错误"),

    // 业务错误
    USER_NOT_FOUND(2001, "用户不存在"),
    WRONG_PASSWORD(2002, "密码错误"),
    NOT_LOGIN(2003, "用户未登录"),
    LOGIN_EXPIRES(2004, "登录信息过期"),

    // 数据库等错误
    UNKNOWN_ERROR(3001, "系统错误");

    private int code;
    private String desc;

    ErrorInfo(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
