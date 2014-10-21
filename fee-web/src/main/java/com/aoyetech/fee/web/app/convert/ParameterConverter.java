/*
 * 
 */
// Created on 2013-8-7

package com.aoyetech.fee.web.app.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aoyetech.fee.commons.utils.ExceptionHelper;

/**
 * @author joe.chen
 */
public abstract class ParameterConverter {

    protected static final Logger logger = LoggerFactory.getLogger(ParameterConverter.class);

    @Autowired
    protected ExceptionHelper     exceptionHelper;
}
