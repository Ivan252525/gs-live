package com.gs.common.date;

public enum DateStyle {

    YYYYMMDD("yyyyMMdd"),
    YYYYMMDDHHMMSS("yyyyMMddHHmmss"),

    YYYY_MM_DD("yyyy-MM-dd"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss");

    private String value;

    DateStyle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
