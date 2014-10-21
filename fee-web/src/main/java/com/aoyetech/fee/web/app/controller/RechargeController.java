package com.aoyetech.fee.web.app.controller;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.aoyetech.fee.biz.rechage.AirRechargeManager;
import com.aoyetech.fee.commons.constant.PayConstant;
import com.aoyetech.fee.commons.utils.ExceptionHelper;
import com.aoyetech.fee.domain.base.Message;
import com.aoyetech.fee.domain.recharge.AirRechargeDO;
import com.aoyetech.fee.domain.recharge.ResultMessage;
import com.aoyetech.fee.statuscode.BusinessCode;
import com.aoyetech.fee.web.app.utils.ServletUtils;
import com.aoyetech.feecommons.page.PagerConstant;

@Controller
public class RechargeController {

    @Autowired
    private AirRechargeManager  airRechargeManager;

    @Autowired
    private ExceptionHelper     exceptionHelper;

    private static final Logger LOGGER = LoggerFactory.getLogger(RechargeController.class);

    @RequestMapping(value = { "/recharge/get_recharge_list.json" })
    public void getRechargeList(@RequestParam(value = "page", required = false, defaultValue = "1")
    Integer page, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        if (page == null || page < 1) {
            page = PagerConstant.DEFAULTSTART;
        }
        int start = (page - 1) * PagerConstant.PAGESIZE;
        String object = StringUtils.EMPTY;
        List<AirRechargeDO> airRechargeDOs = airRechargeManager.getAirRechargeList(start,
            PagerConstant.PAGESIZE);
        object = JSON.toJSONString(airRechargeDOs);
        ServletUtils.renderJson(response, object);
    }

    @RequestMapping(value = { "/recharge/get_recharge_image.json" })
    public void getRechargeImage(@RequestParam(value = "userId", required = false, defaultValue = "1")
                                 String userId,
                                 @RequestParam(value = "rechargeId", required = false, defaultValue = "1")
                                 String rechargeId, HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model) {
        ResultMessage message = new ResultMessage();
        /***
         * 提交的xml格式内容<?xml version='1.0' encoding='UTF-8'?><request><msgType>WebGameBuyToolReq</msgType><versionId>01</versionId><userId>1124433646</userId><cpId>772530</cpId><cpServiceId>653020082266</cpServiceId><consumeCode>000082265005</consumeCode><channelId>10558000</channelId><transIDO>77253020140416110623925739</transIDO></request>
         */
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<request>");
        sb.append("<msgType>WebGameBuyToolReq</msgType>");
        sb.append("<versionId>01</versionId>");
        sb.append("<userId>" + userId + "</userId>");
        sb.append("<cpId>710587</cpId>");
        sb.append("<cpServiceId>658720071768</cpServiceId>");
        sb.append("<consumeCode>000071767001</consumeCode>");
        sb.append("<channelId>10558000</channelId>");
        sb.append("<transIDO>77253020140416110623925739</transIDO>");
        sb.append("</request>");
        /***
         * 响应消息体：<?xml version="1.0" encoding="UTF-8"?>
            <response>
              <msgType>WebGameBuyToolRsp</msgType>
              <hRet>1</hRet>
              <status>2800</status>
              <confirmId>04341d51e0c7444299ab703ec85f4bb4</confirmId>
              <picVCodeURL>http://wap.cmgame.com:8080/portalone/WebGameQueryPicVcode?confirmId=04341d51e0c7444299ab703ec85f4bb4</picVCodeURL>
            </response>
         */
        String content = doHttpPost(PayConstant.NewJIFEIURL, sb.toString());
        LOGGER.warn("[RechargeController] getRechargeImage result xml is :"+content);
        if (StringUtils.isNotBlank(content)) {
            try {
                Document document = DocumentHelper.parseText(content);// 将字符串转为XML
                Element rootElt = document.getRootElement(); // 获取根节点
                String hRet = rootElt.elementTextTrim("hRet");
                String status = rootElt.elementTextTrim("status");
                String confirmId = rootElt.elementTextTrim("confirmId");
                String picVCodeURL = rootElt.elementTextTrim("picVCodeURL");
                if (StringUtils.equals(hRet, "1") || StringUtils.equals(hRet, "3")) {
                    if (StringUtils.equals(status, "2800")) {
                        message.setStatus(BusinessCode.NORMAL);
                        message.setMessage(exceptionHelper.getResultMsg(BusinessCode.NORMAL));
                        message.setPicVCodeURL(picVCodeURL);
                        message.setConfirmId(confirmId);
                    } else {
                        message.setStatus(BusinessCode.OPRATE_ERROR);
                        message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
                    }
                } else {
                    message.setStatus(BusinessCode.OPRATE_ERROR);
                    message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
                }
            } catch (DocumentException e) {
                message.setStatus(BusinessCode.OPRATE_ERROR);
                message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
                LOGGER.error("getRechargeImage parse error", e);
            }
        } else {
            message.setStatus(BusinessCode.OPRATE_ERROR);
            message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
        }
        String messagejson = JSON.toJSONString(message);
        ServletUtils.renderJson(response, messagejson);
    }

    @RequestMapping(value = { "/recharge/pay_confirm.json" })
    public void payConfirm(@RequestParam(value = "answer", required = false)
    String answer, @RequestParam(value = "confirmId", required = false, defaultValue = "1")
    String confirmId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        Message message = new Message();
        /***
         * 请求xml内容：<?xml version="1.0" encoding="UTF-8"?><request><msgType>WebGameBuyToolConfirmReq</msgType><versionId>01</versionId><confirmId>04341d51e0c7444299ab703ec85f4bb4</confirmId><picVCode>5341</picVCode></request>
         */
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<request>");
        sb.append("<msgType>WebGameBuyToolConfirmReq</msgType>");
        sb.append("<confirmId>" + confirmId + "</confirmId>");
        sb.append("<picVCode>" + answer + "</picVCode>");
        sb.append("</request>");
        String resultXml = doHttpPost(PayConstant.NewJIFEIURL, sb.toString());
        LOGGER.warn("[RechargeController] payConfirm result xml is :"+resultXml);
        /***
         * 返回xml：<?xml version="1.0" encoding="UTF-8"?>
            <response>
              <msgType>WebGameBuyToolConfirmRsp</msgType>
              <hRet>0</hRet>
              <status>1800</status>
              <balance>6</balance>
              <point>10</point>
            </response>
         */
        if (StringUtils.isNotBlank(resultXml)) {
            try {
                Document document = DocumentHelper.parseText(resultXml);// 将字符串转为XML
                Element rootElt = document.getRootElement(); // 获取根节点
                String hRet = rootElt.elementTextTrim("hRet");
                String status = rootElt.elementTextTrim("status");
                if (StringUtils.equals(hRet, "1") || StringUtils.equals(hRet, "3")
                    || StringUtils.equals(hRet, "0")) {
                    if (StringUtils.equals(status, "1800")||StringUtils.equals(status, "1801")) {
                        message.setStatus(BusinessCode.NORMAL);
                        message.setMessage(exceptionHelper.getResultMsg(BusinessCode.NORMAL));
                    } else {
                        message.setStatus(BusinessCode.OPRATE_ERROR);
                        message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
                    }
                } else {
                    if (StringUtils.isNotBlank(status)) {
                        message.setStatus(Integer.parseInt(status));
                        message.setMessage("移动错误状态码，请查询移动状态码的错误原因");
                    } else {
                        message.setStatus(BusinessCode.OPRATE_ERROR);
                        message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
                    }
                }
            } catch (DocumentException e) {
                message.setStatus(BusinessCode.OPRATE_ERROR);
                message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
                LOGGER.error("getRechargeImage parse error", e);
            }
        } else {
            message.setStatus(BusinessCode.OPRATE_ERROR);
            message.setMessage(exceptionHelper.getResultMsg(BusinessCode.OPRATE_ERROR));
        }
        String messagejson = JSON.toJSONString(message);
        ServletUtils.renderJson(response, messagejson);
    }

    public static String doHttpPost(String URL, String xmlInfo) {
        LOGGER.warn("发起的数据:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream instr = null;
        java.io.ByteArrayOutputStream out = null;
        try {
            URL url = new URL(URL);
            URLConnection urlCon = url.openConnection();
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            urlCon.setUseCaches(false);
            urlCon.setRequestProperty("Content-Type", "text/xml");
            urlCon.setRequestProperty("Content-length", String.valueOf(xmlData.length));
            urlCon.setConnectTimeout(3 * 1000);
            urlCon.setReadTimeout(10 * 1000);
            DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());
            printout.write(xmlData);
            printout.flush();
            printout.close();
            instr = urlCon.getInputStream();
            byte[] bis = IOUtils.toByteArray(instr);
            String ResponseString = new String(bis, "UTF-8");
            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                LOGGER.error("doHttpPost xml empty" + xmlInfo);
            }
            return ResponseString;

        } catch (Exception e) {
            LOGGER.warn("返回数据为 Exception:", e);
            return "0";
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                instr.close();
            } catch (Exception ex) {
                return "0";
            }
        }
    }
}
