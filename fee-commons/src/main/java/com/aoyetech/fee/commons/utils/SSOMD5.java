/*
 * 
 */
// Created on 2013-5-17

package com.aoyetech.fee.commons.utils;

import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author joe.chen
 */
public class SSOMD5 {

    private static Logger logger = LoggerFactory.getLogger(SSOMD5.class);

    public static String byteArrayToHexString(byte byteArray[]) {
        StringBuffer strHex = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++)
            strHex.append(byteToHexString(byteArray[i]));

        return strHex.toString();
    }

    private static String byteToHexString(byte bt) {
        int i = bt;
        if (i < 0) i += 256;
        int j = i / 16;
        int k = i % 16;
        return hexDigits[j] + hexDigits[k];
    }

    public static String MD5Encode(String strOrigin) {
        String strAim = null;
        try {
            strAim = new String(strOrigin);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            strAim = byteArrayToHexString(messageDigest.digest(strAim.getBytes()));
        } catch (Exception exception) {
        }
        return strAim;
    }

    public static String MD5EncodeByParameter(List<String> parameterList) {
        String strAim = null;
        try {
            // 排序
            Collections.sort(parameterList);
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < parameterList.size(); i++) {
                buffer.append(parameterList.get(i));
            }
            logger.info("MD5String=" + buffer.toString());
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            strAim = byteArrayToHexString(messageDigest.digest(buffer.toString().getBytes()));
        } catch (Exception exception) {
        }
        return strAim;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"                       };
}
