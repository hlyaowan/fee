package com.aoyetech.fee.commons.utils;
//package com.aoyetech.air.commons.utils;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//import javax.annotation.PostConstruct;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ConstantHelper {
//
//    private static Properties CONSTANT;
//
//    @PostConstruct
//    public void init() {
//        ClassLoader cl = ConstantHelper.class.getClassLoader();
//        InputStream is = null;
//        try {
//            is = cl.getResourceAsStream("bussiness_constant.properties");
//            CONSTANT = new Properties();
//            CONSTANT.load(is);
//        } catch (Exception ex) {
//            throw new IllegalArgumentException(ex);
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (Exception ignore) {
//                }
//            }
//        }
//    }
//
//    public static int getConstant(String code) {
//        return Integer.parseInt(getResultMsgInfo(code));
//    }
//
//    public static String getResultMsgInfo(String code) {
//        return CONSTANT.getProperty(code, StringUtils.EMPTY);
//    }
//
//}
