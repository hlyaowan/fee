/*
 * 
 */
// Created on 2013-5-10

package com.aoyetech.fee.commons.utils;

/**
 * @author joe.chen
 */
public abstract class TyydUrlBuilder {

    private static final String WAP_CONTENT_URL = "http://wapread.189.cn/goBookInfo.action?bookId=";

    private static final String WAP_CHAPTER_URL = "http://wapread.189.cn/goChapterContent.action?bookId=";
    
    private static final String WAP_MONTH_URL = "http://wapread.189.cn/baoyueInfoListAction.action?monthProductId=";

    public static String buildWapContentUrl(Long bookId) {
        return WAP_CONTENT_URL.concat(bookId.toString());
    }

    public static String buildWapChapterUrl(Long bookId, Long chapterId) {
        return WAP_CHAPTER_URL.concat(bookId.toString()).concat("&chapterId=").concat(chapterId.toString());
    }
    
    public static String buildMonthWapUrl(Long monthId){
        return WAP_MONTH_URL.concat(monthId.toString());
    }
}
