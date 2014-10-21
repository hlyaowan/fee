package com.aoyetech.fee.commons.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-19 下午2:41:38
 **/

public abstract class NoExceptionRunnable implements Runnable {

    private static final Log logger = LogFactory.getLog(NoExceptionRunnable.class);

    private final String     errmsg;
    private final Log        log;


    public NoExceptionRunnable(final String errmsg, final Log log) {
        this.errmsg = errmsg;
        this.log = log;
    }


    public NoExceptionRunnable(final String errmsg) {
        this(errmsg, logger);
    }


    public NoExceptionRunnable() {
        this("Unexpect error", logger);
    }


    @Override
    public void run() {
        try {
            this.run0();
        } catch (final Throwable e) {
            this.log.error(this.errmsg, e);
        }
    }


    protected abstract void run0() throws Exception;

}
