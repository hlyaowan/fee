package com.aoyetech.fee.commons.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-25 下午4:32:10
 **/

@Documented
@Target({ TYPE, FIELD, METHOD })
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
}
