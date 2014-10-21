/*
 * 
 */
// Created on 2013-3-25


package com.aoyetech.fee.commons.utils;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * @author joe.chen
 *
 */
public abstract class UUIDUtils {

    public static String getUUID() {
        return StringUtils.replace(UUID.randomUUID().toString(), "-", StringUtils.EMPTY);
    }
    
    public static String get16UUID() {
        return RandomStringUtils.randomAlphanumeric(16);
    }
}
