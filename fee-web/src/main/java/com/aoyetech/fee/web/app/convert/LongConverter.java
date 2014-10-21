/*
 * 
 */
// Created on 2013-8-7

package com.aoyetech.fee.web.app.convert;

import org.springframework.core.convert.converter.Converter;

import com.aoyetech.fee.statuscode.BusinessCode;
import com.aoyetech.fee.throwable.ParameterException;


/**
 * @author joe.chen
 */
public class LongConverter extends ParameterConverter implements Converter<String, Long> {

    @Override
    public Long convert(String source) {
        Long result = null;
        try {
            result = new Long(source);
        } catch (Exception ex) {
            logger.error("spring mvc request parameter converter is error!", ex);
            throw new ParameterException(BusinessCode.PARAM_ERROR,
                                         exceptionHelper.getResultMsg(BusinessCode.PARAM_ERROR));
        }
        return result;
    }
}
