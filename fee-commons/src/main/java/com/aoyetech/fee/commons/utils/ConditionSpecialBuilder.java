package com.aoyetech.fee.commons.utils;

import org.apache.commons.lang3.StringUtils;

public class ConditionSpecialBuilder {

    public static final String condition = "1=1";

    public static String buildSpeciaQuery(String subGoods) {
        String link = " and `idd` in (" + subGoods + ")";
        if (StringUtils.isNotBlank(subGoods)) {
            return condition.concat(link);
        } else {
            return condition;
        }
    }
}
