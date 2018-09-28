package com.gs.common.string;

/**
 * 字符串操作工具类
 *
 */
public class StringUtils {

    public static boolean isEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }

}
