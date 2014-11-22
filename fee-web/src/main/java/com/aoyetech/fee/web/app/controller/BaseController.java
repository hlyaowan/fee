package com.aoyetech.fee.web.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 跨域处理基类
 * 
 * @author Administrator
 * 
 */
@Controller
public class BaseController {

    private static final String inj_str = "'@ and @exec@insert @select @delete @update @count@ * @%@chr@mid@master@truncate@char@declare@;@ or @lock table@grant@drop @ascii";

    // url加载类
    private static Properties   path    = null;

    protected void out(String str, HttpServletResponse response) {
        try {
            response.setContentType("application/x-javascript");
            response.setCharacterEncoding("UTF-8");
            // response.setDateHeader("Expires", 0);
            PrintWriter out = response.getWriter();
            out.println(str);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param map
     * @param list
     *            参数不能同时传值
     */
    protected void out(Map map, List list, HttpServletRequest request, HttpServletResponse response) {
        String res = "";
        if (map != null && map.size() != 0) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.putAll(map);
            res = jsonObj.toString();
        } else if (list != null && list.size() != 0) {
            JSONArray jsonarr = new JSONArray();
            jsonarr.addAll(list);
            res = jsonarr.toString();
        }
        outDomainJson(res, request, response);

    }

    /**
     * jquery 跨域调用
     * 
     * @param str
     */
    protected void outDomainJson(String str, HttpServletRequest request,
                                 HttpServletResponse response) {
        String jsoncallback = request.getParameter("callback");
        if (!StringUtils.isEmpty(jsoncallback)) {
            str = jsoncallback + "(" + str + ")";
        }
        out(str, response);
    }

    protected void printMsg(String returnCode, String errorNo, String errorInfo,
                            HttpServletResponse response) {
        out("{\"returnCode\":\"" + returnCode + "\",\"errorNo\":\"" + errorNo
            + "\",\"errorInfo\":\"" + errorInfo + "\"}", response);
    }

    /**
     * sql注入过滤处理
     * 
     * @param value
     * @return
     */
    private static String fiterSQL(String value) {
        value = value.toLowerCase();
        String inj_stra[] = inj_str.split("@");
        for (int i = 0; i < inj_stra.length; i++) {
            if (value.indexOf(inj_stra[i]) >= 0) {
                value = value.replace(inj_stra[i], "");
                break;
            }
        }
        return value;
    }

    /**
     * 脚本注入过滤处理
     * 
     * @param value
     * @return
     */
    public static String fiterScript(String value) {
        value = value.toLowerCase();
        value = value.replace("script", "");
        value = value.replace("<", "");
        value = value.replace(">", "");
        value = value.replace("%", "");
        value = value.replace("/", "");
        value = value.replace("\"", "");
        return value;
    }

    /**
     * 获取返回值
     * 
     * @param name
     *            获取参数的名字
     * @return 默认返回Null
     */
    public String getParamFromRequest(String name, HttpServletRequest request) {
        try {
            String value = request.getParameter(name);
            if (StringUtils.isNotBlank(value)) {
                // 防sql注入
                value = fiterSQL(value);
                // 防脚本注入 过滤script关键字
                value = fiterScript(value);
                return value;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取path.properties的中值 path.properties 中放各种配置url
     */
    public String getPath(String key, Object... values) {
        if (StringUtils.isBlank(key))
            return "";
        String proStr = path.getProperty(key);
        if (!StringUtils.isBlank(proStr) && values != null && values.length > 0) {
            int valuesLen = values.length;
            String[] valueStrs = new String[valuesLen];
            for (int i = 0; i < valuesLen; i++) {
                valueStrs[i] = String.valueOf(values[i]);
            }
            return MessageFormat.format(proStr, valueStrs);
        }
        return proStr;
    }

    /** 获取前端Urlrewriter后地址 */
    public String getFrontPathUrlrewriterBaseUrl() {
        String baseUrl = path.getProperty("frontPath_urlRewriter_baseUrl");
        return baseUrl;
    }

    /** 获取前端地址 */
    public String getFrontPathBaseUrl() {
        String baseUrl = path.getProperty("frontPath_baseUrl");
        return baseUrl;
    }

    /** 获取动态地址 */
    public String getDynamicPathBaseUrl() {
        String baseUrl = path.getProperty("dynamicPath_baseUrl");
        return baseUrl;
    }

}
