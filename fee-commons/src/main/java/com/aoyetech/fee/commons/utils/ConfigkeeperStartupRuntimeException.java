package com.aoyetech.fee.commons.utils;

/**
 * 表示启动时有问题
 * 
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-14 下午5:53:51
 **/

public class ConfigkeeperStartupRuntimeException extends RuntimeException {

    public ConfigkeeperStartupRuntimeException(final String string) {
        super(string);
    }

    private static final long serialVersionUID = 1L;

}
