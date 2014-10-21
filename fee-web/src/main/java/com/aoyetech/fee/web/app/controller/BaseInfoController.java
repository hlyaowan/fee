package com.aoyetech.fee.web.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.aoyetech.fee.biz.baseinfo.AirBaseInfoManager;
import com.aoyetech.fee.domain.baseinfo.AirBaseInfoDO;
import com.aoyetech.fee.domain.user.UserInfoDO;
import com.aoyetech.fee.web.app.utils.ServletUtils;

@Controller
public class BaseInfoController {

    @Autowired
    private AirBaseInfoManager airBaseInfoManager;

    @RequestMapping(value = { "/user/getBaseInfoList.json" })
    public void getuserinfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        List<AirBaseInfoDO> airBaseInfoDOs = airBaseInfoManager.getAirBaseInfoList(null);
        String airBaseInfoList = JSON.toJSONString(airBaseInfoDOs);
        ServletUtils.renderJson(response, airBaseInfoList);
    }
}
