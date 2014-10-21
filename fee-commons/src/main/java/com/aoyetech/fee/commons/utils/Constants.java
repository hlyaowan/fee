package com.aoyetech.fee.commons.utils;

import java.io.File;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-3 上午9:55:54
 **/

public class Constants {

    public static final String ENCODE                          = "GBK";

    public static final String BASE_DIR                        = "configkeeper-data";

    public static final String DATAID                          = "dataId";

    public static final String GROUP                           = "group";

    public static final String LINE_SEPARATOR                  = Character.toString((char) 1);

    public static final String WORD_SEPARATOR                  = Character.toString((char) 2);

    public static final String HTTP_PROTOCOL_PREFIX            = "http://";

    public static final String SERVER_BASE_URL                 = "/configkeeper-server";

    public static final String SERVER_NODES_FILENAME           = "ServerNodes";
    /**
     * 默认分组名
     */
    public static final String DEFAULT_GROUP                   = "DEFAULT_GROUP";

    public static final String CONTENT_MD5                     = "Content-MD5";

    public static final String CLIENT_VERSION_HEADER           = "Client-Version";

    public static final String ACCEPT_ENCODING                 = "Accept-Encoding";

    public static final String PROBE_MODIFY_REQUEST            = "Probe-Modify-Request";

    public static final String UNKNOWN_CLIENT_VERSION          = "unknown-client-version";

    public static final String EMPTY                           = "";

    public static final int    DEFAULT_SERVER_PORT             = 61234;


    //------------------client------------------------//
    /**
     * 客户端数据的根目录,绝对路径
     */
    public static final String CLIENT_LOCAL_ROOT_PATH          = System.getProperty("user.home")
                                                                       + File.separator
                                                                       + "configkeeper";

    /**
     * 客户端本地配置项数据的目录名称
     */
    public static final String CLIENT_LOCAL_CONFIG_BASEDIR     = BASE_DIR;

    /**
     * 客户端本地配置项数据的绝对路径
     */
    public static final String CLIENT_LOCAL_CONFIG_BASEPATH    = CLIENT_LOCAL_ROOT_PATH
                                                                       + File.separator
                                                                       + CLIENT_LOCAL_CONFIG_BASEDIR;

    /**
     * 客户端snapshot配置项数据的绝对路径
     */
    public static final String CLIENT_SNAPSHOT_CONFIG_BASEPATH = CLIENT_LOCAL_ROOT_PATH
                                                                       + File.separator
                                                                       + "snapshot";
    //    /**
    //     * 客户端监控本地文件的时间间隔,单位毫秒
    //     */
    //    public static final String CLIENT_LOCAL_WATCH_INTERVAL_TIME = System.getProperty(
    //                                                                        "file.watch.interval",
    //                                                                        "5000");


    /**
     * 保存configkeeper server地址的绝对路径
     */
    public static final String CLIENT_SERVER_NODE_FILE         = CLIENT_LOCAL_ROOT_PATH
                                                                       + File.separator
                                                                       + SERVER_NODES_FILENAME;

    /**
     * 保存地址服务器的绝对路径
     */
    public static final String CLIENT_ADDRESS_SERVER_FILE      = CLIENT_LOCAL_ROOT_PATH
                                                                       + File.separator
                                                                       + "addressserver";

    /**
     * 客户端检查配置的时间间隔，秒
     */
    public static final int    CLIENT_POLLING_INTERVAL_TIME    = 15;


}
