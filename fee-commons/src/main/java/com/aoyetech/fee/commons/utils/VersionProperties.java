package com.aoyetech.fee.commons.utils;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-18 下午4:52:50
 **/

public class VersionProperties {
    private static final Log logger  = LogFactory.getLog(VersionProperties.class);

    public static String     VERSION = "1.0.0";

    static {
        InputStream in = null;
        try {
            in = VersionProperties.class.getClassLoader().getResourceAsStream("version.properties");
            final Properties props = new Properties();
            props.load(in);
            VERSION = props.getProperty("version");
        } catch (final Throwable e) {
            logger.warn("load version failed." + e.getMessage());
        } finally {
            IOUtils.closeQuietly(in);
        }

        if (logger.isInfoEnabled()) {
            logger.info("ConfigkeeperLib-Version:" + VERSION);
        }

    }
}
