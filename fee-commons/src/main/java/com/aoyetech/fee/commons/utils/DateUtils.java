/*
 * 
 */
// Created on 2013-4-3

package com.aoyetech.fee.commons.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author joe.chen
 */
public abstract class DateUtils {

    public static final Logger logger            = Logger.getLogger(DateUtils.class);

    public static final String DEFAULT_DATE      = "yyyyMMdd";
    public static final String DEFAULT_TIMESTAMP = "yyyyMMddHHmmssSSS";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DEFAULT_DATETIME  = "yyyy-MM-dd HH:mm:ss";

    public static Timestamp getDateTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setNanos(0);
        return timestamp;
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATETIME);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String parseDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATETIME);
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getStringDate(java.sql.Timestamp time) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIMESTAMP);
        String dateString = formatter.format(time);
        return dateString;
    }

    public static String getMerDate(java.sql.Timestamp time) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE);
        String dateString = formatter.format(time);
        return dateString;
    }

    public static long getLongDate(String timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIMESTAMP);
        try {
            Date d = formatter.parse(timestamp);
            return d.getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

    public static boolean isTimeout(long timestamp, long limit) {
        return isTimeout(String.valueOf(timestamp), limit);
    }

    public static boolean isTimeout(String timestamp, long limit) {
        long ts = 0;
        long now = System.currentTimeMillis();
        if (timestamp.length() == DEFAULT_TIMESTAMP.length()) {
            ts = getLongDate(timestamp);
        } else {
            ts = Long.parseLong(timestamp);
        }
        return Math.abs(ts - now) > limit;
    }

    public static Timestamp parseDataTime(String dataTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME);
        try {
            return new Timestamp(sdf.parse(dataTime).getTime());
        } catch (ParseException e) {

        }
        return null;
    }

    /**
     * 取得下一天开始unix time
     * 
     * @return
     */
    public static long getNextDayUnixTime() {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis() / 1000;
    }

    /**
     * 取得下一月开始unix time
     * 
     * @return
     */
    public static long getNextMonthUnixTime() {
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis() / 1000;
    }

    /**
     * 格式化时间
     * 
     * @param Date 传过来的时间
     * @param format 格式化字符串 例如 "yyyy-MM-dd HH:MM:ss"
     * @return String 格式化好的字符串 例如"2010-12-18 17:12:33"
     */
    public static String formatDate(Date date, String format) {
        String dateString = "";
        try {
            final SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            dateString = simpleFormat.format(date);
        } catch (Exception ex) {
            logger.error("formatDate:" + "Format date error!", ex);
        }
        return dateString;
    }
    
    public static Long getLinuxTime(String dateFormat){
    	SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATETIME);
    	try {
			Date date =sdf.parse(dateFormat);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return 0L;
    }

    public static void main(String[] args) {
        System.out.println(getLinuxTime("2014-08-02 17:00:57"));
    }

}
