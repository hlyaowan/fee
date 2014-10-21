package com.aoyetech.fee.commons.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DateUtil {

    /** 默认日期格式 */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    private static final String DEFAULT_TIMESTAMP = "yyyyMMddHHmmssSSS";

    public static String getCurrentTime() {
        SimpleDateFormat format = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        format.applyPattern("yyyyMMddHHmmss");
        String timeStr = format.format(new Date());
        return timeStr;
    }

    public static String getCurrentTimestamp() {
        SimpleDateFormat format = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        format.applyPattern("yyyy-MM-dd HH:mm:ss");
        String timeStr = format.format(new Date());
        return timeStr;
    }

    /****
     * 根据格式获取时间
     * 
     * @param formatStr 如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getCurrentTimestamp(String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        format.applyPattern(formatStr);
        String timeStr = format.format(new Date());
        return timeStr;
    }

    /**
     * 将Timestamp转换成指定的日期格式
     * 
     * @param formatStr 默认 yyyy-MM-dd HH:mm:ss)
     * @param dateSource 源日期 Timestamp)
     * @return
     */
    public static String getTimeByFomat(String formatStr, Timestamp dateSource) {
        if (StringUtils.isBlank(formatStr)) {// 容错处理
            formatStr = DEFAULT_PATTERN;
        }
        if (dateSource == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(dateSource);
    }

    /**
     * 将Timestamp转换成默认的日期格式 "yyyy-MM-dd HH:mm:ss"
     * 
     * @return 格式化的描述时间字符串
     */
    public static String getTimeByFomat(Timestamp dateSource) {
        return getTimeByFomat(DEFAULT_PATTERN, dateSource);
    }

    /**
     * 将Timestamp转换成指定的日期格式
     * 
     * @param fomatStr "yyyy年MM月dd日 HH:mm:ss")
     * @param dateSource 源日期 Date)
     * @return
     */
    public static String getTimeByFomat(String fomatStr, Date dateSource) {
        if (dateSource == null) {// 容错处理
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat("", Locale.SIMPLIFIED_CHINESE);
        format.applyPattern(fomatStr);
        return format.format(dateSource);
    }

    /****
     * 将日期字符串按照指定的日期格式输出
     * 
     * @param formatStr 如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getTimeByFormat(String time, String formatStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_PATTERN);
        if (StringUtils.isNotBlank(formatStr)) {
            format.applyPattern(formatStr);
        }
        return StringUtils.isNotBlank(time) ? format.format(format.parse(time)) : "";
    }

    /****
     * 将日期字符串按照特定的格式("yyyy-MM-dd HH:mm:ss")输出
     * 
     * @param formatStr 如："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getTimeByFormat(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_PATTERN);
        return StringUtils.isNotBlank(time) ? format.format(format.parse(time)) : "";
    }

    /**
     * 验证时间(long类型)是否在开始时间(1970-01-01 00:00:00)和当前时间范围内
     * 
     * @param time 需要验证的时间 long
     * @return 在返回true，否则false
     */
    public static boolean whetherValidDate(long time) {
        long beginDate = -28800000l;// 电脑的开始时间 1970-01-01 00:00:00
        long endDate = System.currentTimeMillis();// 电脑当前时间
        if (time > beginDate && time <= endDate) {
            return true;
        }
        return false;
    }
    
    /**
     * 字符串时间穿换成时间戳
     * @param timestamp
     * @return
     */
    public static long getLongDate(String timestamp) {
    	SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIMESTAMP);
    	try {
    		Date d = formatter.parse(timestamp);
			return d.getTime();
		} catch (ParseException e) {
			return 0;
		}
    }
    
    /**
     * 判断是否超时
     * @param timestamp
     * @param limit
     * @return
     */
    public static boolean isTimeout(String timestamp, long limit){
    	long ts = 0;
    	long now = System.currentTimeMillis();
    	if (timestamp.length() == DEFAULT_TIMESTAMP.length()) {
    		ts = getLongDate(timestamp);
    	} else {
    		ts = Long.parseLong(timestamp);
    	}
    	return Math.abs(ts - now) > limit;
    }
    
    public static String getNextWeek() {
    	Calendar calendar =Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
    	calendar.add(Calendar.WEEK_OF_YEAR, 1);
    	SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIMESTAMP);
    	return formatter.format(calendar.getTime());
    }
    
    public static String getNextMonth() {
    	Calendar calendar =Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
    	calendar.add(Calendar.MONTH, 1);
    	SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIMESTAMP);
    	return formatter.format(calendar.getTime());
    }
    
    public static Date getCurrentDate(String dstr){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
        Date date=null;
        try {
            date=sdf.parse(dstr);
        } catch (ParseException e) {
            e.printStackTrace();
        } 
        return date;
    }
    
    public static void main(String[] args) {
    	System.out.println(getCurrentDate("2014-07-26"));
    }
    
    public static final String  YYYY_MM_DD = "yyyy-MM-dd";
    
    public static final String  YYYY_MM_DD_HH_DD_SS = "yyyy-MM-dd HH:mm:ss";//HH是24小时制，hh是12小时制
    
    public static final String  YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";//HH是24小时制，hh是12小时制
    
    public static final String  YYYYMMDDHHDDSS = "yyyyMMddHHmmss";
    
    public static final String YYYYMMDD = "yyyyMMdd";

    public DateUtil() {
    }

    /**
     * 默认格式化时间格式
     * 
     * @param date
     * @param style
     * @return
     */
    public static String format(Date date) {
        return format(date, YYYY_MM_DD);
    }

    /**
     * 根据style格式化时间格式
     * 
     * @param date
     * @param style
     * @return
     */
    public static String format(Date date, String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    /**
     * 时间格式的字符串转成Date对象
     * 
     * @param date
     * @param style
     * @return
     */
    public static Date parse(String date, String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        if (date == null) {
            return null;
        }
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 时间格式的字符串转成Date对象
     * 把2014-08-04上午09点30分这样
     * @param date
     * @param style
     * @return
     */
    public static Date parseTo(String date, String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        if (date == null) {
            return null;
        }
        try {
            String str1 = "";
            if(StringUtils.indexOf(date, "上午")>0){
                str1 = date.replaceAll("上午", " ");
            }else if(StringUtils.indexOf(date, "下午")>0){
                str1 = date.replaceAll("下午", " ");
            }else{
                return null;
            }
            String str2 = str1.replace("点", ":");
            String str3 = str2.replace("分", "");
            return sdf.parse(str3);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * 获取当前时间
     * @param style格式化 的样式
     * @return
     */
    public static String getCurrentDates(String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style);
        try {
            return sdf.format(new Date());
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * 是今天
     * @param date
     * @return
     * @author bangis.wangdf at 2012-8-14
     */
    public static boolean isToday(Date date){
        if (date == null) {
            return false;
        }
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        Calendar datec = Calendar.getInstance();
        datec.setTime(date);
        if (today.get(Calendar.YEAR) != datec.get(Calendar.YEAR)) {
            return false;
        }
        if (today.get(Calendar.MONTH) != datec.get(Calendar.MONTH)) {
            return false;
        }
        if (today.get(Calendar.DAY_OF_MONTH) != datec.get(Calendar.DAY_OF_MONTH)) {
            return false;
        }
        return true;
    }
    /**
     * 是今天
     * @param date
     * @return
     * @author bangis.wangdf at 2012-8-14
     */
//    public static boolean isToday(String date){
//        if (date == null) {
//            return false;
//        }
//        return StringUtils.equals(getCurrentDate(YYYYMMDD),date);
//    }

    /**
     * @param date
     * @param month
     * @return
     * @author bangis.wangdf at 2012-8-15
     */
    public static Date addMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
    
    /**
     * 两个日期间隔多少个月
     * @param date1
     * @param date2
     * @return
     * @author longjian.huanglj
     * @Created at 2012-8-29
     */
    public static int getMonthsBetween(Date date1, Date date2){
        Date startDate = date1;
        Date endDate = date2;
        if(date1.after(date2)){
            startDate = date2;
            endDate = date1;
        }
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(startDate);
        calStart.add(Calendar.HOUR_OF_DAY, 0);
        calStart.add(Calendar.MINUTE, 0);
        calStart.add(Calendar.SECOND, 0);
        
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(endDate);
        calEnd.add(Calendar.HOUR_OF_DAY, 0);
        calEnd.add(Calendar.MINUTE, 0);
        calEnd.add(Calendar.SECOND, 0);
        
        int n = 0;
        while(!calStart.after(calEnd)){
            n++;
            calStart.add(Calendar.MONTH, 1); 
        }
        return n - 1;
    }
    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        }
        Calendar cald = Calendar.getInstance();
        cald.setTime(date);
        cald.add(Calendar.DAY_OF_YEAR, days);
        return cald.getTime();
    }
    
}
