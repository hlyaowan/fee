package com.aoyetech.fee.web.app.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jInit extends HttpServlet {
    private static final long serialVersionUID = -4499302208753939187L;
    static Logger             logger           = LoggerFactory.getLogger(Log4jInit.class);

    public void init(ServletConfig config) throws ServletException {
        String prefix = config.getServletContext().getRealPath("/");
        String file = config.getInitParameter("log4j");
        String filePath = prefix + file;
        Properties props = new Properties();

        try {
            FileInputStream istream = new FileInputStream(filePath);
            props.load(istream);
            istream.close();

            String logFile = prefix + props.getProperty("log4j.appender.R.File");//设置路径
            props.setProperty("log4j.appender.R.File", logFile);

            // 装入log4j配置信息
            PropertyConfigurator.configure(props);
        } catch (IOException e) {
            logger.error("Could not read configuration file [" + filePath + "].");
            logger.error("Ignoring configuration file [" + filePath + "].");
            return;
        }
    }
}
