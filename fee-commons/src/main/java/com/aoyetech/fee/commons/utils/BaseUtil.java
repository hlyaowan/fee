package com.aoyetech.fee.commons.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseUtil {

    public static String random(int n) {

        Random ran = new Random();
        if (n == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        int bitField = 0;
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                int k = ran.nextInt(10);
                if ((bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    chs[i] = (char) (k + '0');
                    break;
                }
            }
        }
        return new String(chs);
    }

    public static String getTypeName(int type) {
        switch (type) {
            case 1:
                return "贝竹门票";
            case 2:
                return "自有门票";
            case 3:
                return "深大门票";

            default:
                return "自有门票";
        }
    }
    
	

}
