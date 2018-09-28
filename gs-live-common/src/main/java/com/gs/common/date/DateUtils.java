package com.gs.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 将时间类型转换成指定格式的字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        return getDateFormat(format).format(date);
    }

    /**
     * 将时间类型转换成指定格式的字符串
     *
     * @param date
     * @param dateStyle
     * @return
     */
    public static String dateToString(Date date, DateStyle dateStyle) {
        return getDateFormat(dateStyle.getValue()).format(date);
    }

    /**
     * 将指定格式的字符串转换成时间类型
     *
     * @param date
     * @param format
     * @return
     */
    public static Date stringToDate(String date, String format) {
        try {
            return getDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将指定格式的字符串转换成时间类型
     *
     * @param date
     * @param dateStyle
     * @return
     */
    public static Date stringToDate(String date, DateStyle dateStyle) {
        try {
            return getDateFormat(dateStyle.getValue()).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取offset天后的时间（offset可为负数）
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date getNextDay(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, offset);
        return calendar.getTime();
    }

    /**
     * 获取offset月后的时间（offset可为负数）
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date getNextMonth(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, offset);
        return calendar.getTime();
    }

    /**
     * 获取offset年后的时间（offset可为负数）
     *
     * @param date
     * @param offset
     * @return
     */
    public static Date getNextYear(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, offset);
        return calendar.getTime();
    }

}
