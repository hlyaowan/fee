package com.aoyetech.fee.web.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.aoyetech.fee.biz.useext.UserExtManager;
import com.aoyetech.fee.biz.user.UserManager;
import com.aoyetech.fee.commons.utils.DateUtil;
import com.aoyetech.fee.commons.utils.ExceptionHelper;
import com.aoyetech.fee.domain.base.Message;
import com.aoyetech.fee.domain.ext.UserExtDO;
import com.aoyetech.fee.domain.user.UserInfoDO;
import com.aoyetech.fee.statuscode.BusinessCode;
import com.aoyetech.fee.web.app.utils.ServletUtils;

@Controller
public class UserController {

    @Autowired
    private UserManager      userManager;

    @Autowired
    private UserExtManager   userExtManager;

    @Autowired
    private ExceptionHelper  exceptionHelper;


    @RequestMapping(value = { "/user/getuserinfo.json" })
    public void getuserinfo(@RequestParam(value = "id", required = false)
    String username, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        String object = StringUtils.EMPTY;
        UserInfoDO userInfoDO = userManager.getUserInfo(username);
        object = JSON.toJSONString(userInfoDO);
        ServletUtils.renderJson(response, object);
    }

    /***
     * 注册接口
     * @param userId
     * @param key
     * @param cpId
     * @param cpServiceId
     * @param channelId
     * @param p
     * @param region
     * @param contentInfo
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = { "/user/register.json" })
    public void register(@RequestParam(value = "userId", required = false)
    String userId, @RequestParam(value = "key", required = false)
    String key, @RequestParam(value = "cpId", required = false)
    String cpId, @RequestParam(value = "cpServiceId", required = false)
    String cpServiceId, @RequestParam(value = "channelId", required = false)
    String channelId, @RequestParam(value = "p", required = false)
    String p, @RequestParam(value = "region", required = false)
    String region, @RequestParam(value = "contentInfo", required = false)
    String contentInfo, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        //http://202.85.214.90:81/?userId=1124433646&key=JS000e43297002913643937660951&cpId=772319&cpServiceId=700214722000&channelId=40204000&p=
        Message message = new Message();
        //判断用户是否存在
        UserExtDO airUserExtDO = new UserExtDO();
        airUserExtDO.setAuthId(userId);
        airUserExtDO = userExtManager.getUserExtInfo(airUserExtDO);
        if (airUserExtDO == null) {
            //插入基本表
            UserInfoDO userInfoDO = new UserInfoDO();
            userInfoDO.setCurrentblackstage(0);
            userInfoDO.setHistorynum(0);
            userInfoDO.setIntegral(0);
            userInfoDO.setIsblackstateunlock(0);
            userInfoDO.setIsnewplayer(0);
            userInfoDO.setMasonry(0);
            userInfoDO.setName(StringUtils.trim(userId));
            userInfoDO.setPassword("");
            userInfoDO.setPetone(0);
            userInfoDO.setPettwo(0);
            userInfoDO.setPetthree(0);
            userInfoDO.setPetfour(0);
            userInfoDO.setPetfour(0);
            userInfoDO.setPetfive(0);
            userInfoDO.setPetsix(0);
            userInfoDO.setPlanegrade(0);
            userManager.insertUser(userInfoDO);
            // 插入扩展表
            airUserExtDO = new UserExtDO();
            airUserExtDO.setAddTime(DateUtil.getCurrentTimestamp());
            airUserExtDO.setAuthId(StringUtils.trim(userId));
            airUserExtDO.setChannelId(channelId);
            airUserExtDO.setContentInfo(contentInfo);
            airUserExtDO.setCpId(cpId);
            airUserExtDO.setCpServiceId(cpServiceId);
            airUserExtDO.setCraftName(StringUtils.EMPTY);
            airUserExtDO.setDriverName(StringUtils.EMPTY);
            airUserExtDO.setKeymd5(key);
            airUserExtDO.setMobile(StringUtils.EMPTY);
            airUserExtDO.setPersonName(StringUtils.EMPTY);
            airUserExtDO.setUserId(0);
            airUserExtDO.setRegion(region);
            int isSuccess = userExtManager.insertUserExt(airUserExtDO);

            if (isSuccess > 0) {
                message.setStatus(BusinessCode.NORMAL);
                message.setMessage(exceptionHelper.getResultMsg(BusinessCode.NORMAL));
            } else {
                message.setStatus(BusinessCode.ORDER_FAIL);
                message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
            }
        } else {
            message.setStatus(BusinessCode.USER_EXIST);
            message.setMessage(exceptionHelper.getResultMsg(BusinessCode.USER_EXIST));
        }

        String responsemess = JSON.toJSONString(message);
        ServletUtils.renderJson(response, responsemess);
    }
    
    @RequestMapping(value = { "/user/modify_user_data.json" })
    public void modifyUserData(@RequestParam(value = "userId", required = false)String userId,
                               @RequestParam(value = "integral", required = false)Integer integral,
                               @RequestParam(value = "planeGrade", required = false)Integer planeGrade,
                               @RequestParam(value = "masonry", required = false)Integer masonry,
                               @RequestParam(value = "historyNum", required = false)Integer historyNum,
                               @RequestParam(value = "petOne", required = false)Integer petOne,
                               @RequestParam(value = "petTwo", required = false)Integer petTwo,
                               @RequestParam(value = "petThree", required = false)Integer petThree,
                               @RequestParam(value = "petFour", required = false)Integer petFour,
                               @RequestParam(value = "petFive", required = false)Integer petFive,
                               @RequestParam(value = "petSix", required = false)Integer petSix,
                               @RequestParam(value = "currentBlackStage", required = false)Integer currentBlackStage,
                               @RequestParam(value = "isBlackStateUnlock", required = false)Integer isBlackStateUnlock,
                               @RequestParam(value = "isNewPlayer", required = false)Integer isNewPlayer,
                               @RequestParam(value = "craftName", required = false)String craftName,
                               @RequestParam(value = "driverName", required = false)String driverName,
                               @RequestParam(value = "personName", required = false)String personName,
                               HttpServletRequest request, HttpServletResponse response, ModelMap model){

        Message message = new Message();
        //更新扩展表
        UserExtDO airUserExtDO = new UserExtDO();
        airUserExtDO.setAuthId(StringUtils.trim(userId));
        airUserExtDO.setCraftName(craftName);
        airUserExtDO.setDriverName(driverName);
        airUserExtDO.setPersonName(personName);
        userExtManager.updateUserExt(airUserExtDO);
        //更新用户表
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setCurrentblackstage(currentBlackStage);
        userInfoDO.setHistorynum(historyNum);
        userInfoDO.setIntegral(integral);
        userInfoDO.setIsblackstateunlock(isBlackStateUnlock);
        userInfoDO.setIsnewplayer(isNewPlayer);
        userInfoDO.setMasonry(masonry);
        userInfoDO.setName(StringUtils.trim(userId));
        userInfoDO.setPetone(petOne);
        userInfoDO.setPettwo(petTwo);
        userInfoDO.setPetthree(petThree);
        userInfoDO.setPetfour(petFour);
        userInfoDO.setPetfive(petFive);
        userInfoDO.setPetsix(petSix);
        userInfoDO.setPlanegrade(historyNum);
        int isSuccess = userManager.updateUser(userInfoDO);
        if(isSuccess==1){
            message.setStatus(BusinessCode.NORMAL);
            message.setMessage(exceptionHelper.getResultMsg(BusinessCode.NORMAL));
        }else{
            message.setStatus(BusinessCode.OPRATE_ERROR);
            message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
        }
        String obj =JSON.toJSONString(message);
        ServletUtils.renderJson(response, obj);
    }
}