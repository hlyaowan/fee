package com.aoyetech.fee.commons.cache.encrypt;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 * @since 2013-5-15
 * @author yi.yuy
 */
public class MD5 {

    public static String compute(String inStr) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");
        char[] charArray = inStr.toCharArray();

        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte) charArray[i];
        }

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
           int val = ((int) md5Bytes[i]) & 0xff;
           if (val < 16){
               hexValue.append("0");
           }
           hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    
    public static String md5Key(String inStr) throws NoSuchAlgorithmException {
        String md5=compute(inStr);
        md5=md5.substring(md5.length()-5);
        return md5.toUpperCase();
    }
    
    public static String md5Key(String inStr, int idxLeng) throws NoSuchAlgorithmException {
        String md5=compute(inStr);
        md5=md5.substring(md5.length()-idxLeng);
        return md5.toUpperCase();
    }

}
