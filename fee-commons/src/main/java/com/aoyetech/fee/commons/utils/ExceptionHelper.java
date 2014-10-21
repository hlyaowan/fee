/*
 * 
 */
// Created on 2013-3-24

package com.aoyetech.fee.commons.utils;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author joe.chen
 */
@Component
public class ExceptionHelper {

    private static Properties CONSTANT;

    @PostConstruct
    public void init() {
        ClassLoader cl = ExceptionHelper.class.getClassLoader();
        InputStream is = null;
        try {
            is = cl.getResourceAsStream("bussiness_code.properties");
            CONSTANT = new Properties();
            CONSTANT.load(is);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception ignore) {
                }
            }
        }
    }

    public String getResultMsg(int code) {
        return getResultMsg(String.valueOf(code));
    }

    /**
     * 替换{[0][1][...]}占位符,例如：您好{0}，欢迎登陆
     * 
     * @param code
     * @param args
     * @return 替换后的字符串
     */
    public String getResultMsg(int code, String... args) {
        String msg = getResultMsg(code);
        Object[] objs = args;
        return MessageFormat.format(msg, objs);
    }

    public String getResultMsg(String code) {
        return CONSTANT.getProperty(code, StringUtils.EMPTY);
    }

}
