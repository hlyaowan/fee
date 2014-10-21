package com.aoyetech.fee.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {

    /***
     * 判断是否邮箱类型
     * 
     * @return
     */
    public static boolean IsEmailType(String email) {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        return b;
    }

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

}
