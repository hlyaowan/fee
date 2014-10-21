/*
 * 
 */
// Created on 2013-3-22

package com.aoyetech.fee.biz.ao.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * @author joe.chen
 */
@Transactional(TransactionMode.COMMIT)
public abstract class BaseTest extends UnitilsJUnit4 {

    @SpringApplicationContext({ "classpath:test-spring-all.xml" })
    protected ApplicationContext  applicationContext;

    protected static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

}
