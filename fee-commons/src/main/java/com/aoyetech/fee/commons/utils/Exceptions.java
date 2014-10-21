package com.aoyetech.fee.commons.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-6 下午2:42:20
 **/

public abstract class Exceptions {

    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
