package com.aoyetech.fee.commons.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class OptionUtils {

    // option=price|bt|500,1000;county.city.id|eq|9;level|eq|AAAAA;
    public static Map analyse(String option) {
        Map map = new HashMap();
        if (StringUtils.isNotBlank(option)) {
            String[] options = option.split(";");
            for (String string : options) {
                if (StringUtils.isNotBlank(string)) {
                    String[] contents = string.split("\\|");
                    if (contents.length > 2) {
                        String key = contents[0];
                        if (StringUtils.isNotBlank(key)) {
                            if (StringUtils.equals(key, "price")) {
                                String[] prices = contents[2].split(",");
                                if (prices.length > 1) {
                                    map.put("lowprice", prices[0]);
                                    map.put("hightprice", prices[1]);
                                }
                            } else if (StringUtils.equals(key, "county.city.id")) {
                                map.put("cityId", contents[2]);
                            } else if (StringUtils.equals(key, "level")) {
                                map.put("level", contents[2]);
                            }
                        }
                    }
                }
            }
        }
        return map;
    }
    
    public static void main(String[] args) {
        String option="price|bt|500,1000;county.city.id|eq|9;level|eq|AAAAA";
        Map map =analyse(option);
        System.out.println(map.get("lowprice"));
        System.out.println(map.get("hightprice"));
        System.out.println(map.get("cityId"));
        System.out.println(map.get("level"));
    }
}
