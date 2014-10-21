/*
 * 
 */
// Created on 2013-3-24

package com.aoyetech.fee.web.app.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.aoyetech.fee.commons.utils.ExceptionHelper;
import com.aoyetech.fee.domain.error.Error;
import com.aoyetech.fee.statuscode.BusinessCode;
import com.aoyetech.fee.throwable.AOException;
import com.aoyetech.fee.throwable.BOException;
import com.aoyetech.fee.throwable.ParameterException;

/**
 * @author joe.chen
 */
@Component
public class OpenAPIHandlerExceptionResolver implements HandlerExceptionResolver, Ordered {

    private static final Logger LOG   = LoggerFactory.getLogger(OpenAPIHandlerExceptionResolver.class);

    private static final int    ORDER = LOWEST_PRECEDENCE + 1;

    @Autowired
    private ExceptionHelper     exceptionHelper;

    @Override
    public int getOrder() {
        return ORDER;
    }
 
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        Map<String, Object> model = new HashMap<String, Object>(1);
        LOG.error(ex.getMessage());

        if (ex instanceof AOException) {
            AOException tmpThrowable = (AOException) ex;

            Error error = new Error(tmpThrowable.getCode(), tmpThrowable.getMsg());
            model.put("response", error);
            return new ModelAndView("error/app_error", model);
        } else if (ex instanceof BOException) {
            BOException tmpThrowable = (BOException) ex;
            Error error = new Error(tmpThrowable.getCode(), tmpThrowable.getMsg());
            model.put("response", error);
            return new ModelAndView("error/app_error", model);

        } else if (ex instanceof ParameterException) {
            ParameterException tmpThrowable = (ParameterException) ex;
            Error error = new Error(tmpThrowable.getCode(), tmpThrowable.getMsg());
            model.put("response", error);
            return new ModelAndView("error/app_error", model);
        } else if (ex instanceof PropertyAccessException || ex instanceof ServletRequestBindingException) {
            Error error = new Error(BusinessCode.PARAM_ERROR, exceptionHelper.getResultMsg(BusinessCode.PARAM_ERROR));
            model.put("response", error);
            return new ModelAndView("error/app_error", model);
        } else if (ex instanceof HttpRequestMethodNotSupportedException) {
            Error error = new Error(BusinessCode.REQ_PROTOCAL_ERR,
                                    exceptionHelper.getResultMsg(BusinessCode.REQ_PROTOCAL_ERR));
            model.put("response", error);
            return new ModelAndView("error/app_error", model);
        }
        model.put("response", Error.SYS_ERROR);
        return new ModelAndView("error/sys_error", model);

    }
}
