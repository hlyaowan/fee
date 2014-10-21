/*
 * 
 */
// Created on 2013-7-15

package com.aoyetech.fee.web.app.convert;

import org.springframework.core.convert.converter.Converter;

import com.aoyetech.fee.statuscode.BusinessCode;
import com.aoyetech.fee.throwable.ParameterException;



/**
 * @author joe.chen
 */
public class IntegerConverter extends ParameterConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        Integer result = null;
        try {
            result = new Integer(source);
        } catch (Exception ex) {
            logger.error("spring mvc request parameter converter is error!", ex);
            throw new ParameterException(BusinessCode.PARAM_ERROR,
                                         exceptionHelper.getResultMsg(BusinessCode.PARAM_ERROR));
        }
        return result;
    }

}
