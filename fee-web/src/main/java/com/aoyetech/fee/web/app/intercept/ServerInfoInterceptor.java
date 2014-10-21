package com.aoyetech.fee.web.app.intercept;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aoyetech.fee.domain.webserver.WebServerInfo;

public class ServerInfoInterceptor implements HandlerInterceptor {

    private static final  Logger logger = LoggerFactory.getLogger(ServerInfoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
                                                                                                                        throws Exception {
        String show_serverInfo = request.getParameter("show_serverInfo");
        if (StringUtils.isNotBlank(show_serverInfo)) {
            logger.debug(show_serverInfo);
            try {
                WebServerInfo serverInfo = new WebServerInfo();
                InetAddress addr = InetAddress.getLocalHost();
                serverInfo.setServerIp(addr.getHostAddress());
                serverInfo.setServerName(addr.getHostName());
                model.getModelMap().addAttribute(WebServerInfo.JSON_ROOT_NAME, serverInfo);
            } catch (UnknownHostException e) {
                System.out.println("get server message error !" + e);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
                                                                                                                       throws Exception {
    }

}
