package com.aoyetech.fee.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-3 下午2:51:27
 **/

public class ConfigKeeperUtils {

    private static final Log   logger       = LogFactory.getLog(ConfigKeeperUtils.class);

    public static final String LOCAL_IP;
    static {
        LOCAL_IP = getLocalAddress();
        final String msg = "LOCAL_IP: " + LOCAL_IP;
        logger.info(msg);
        System.out.println(msg);
    }

    static String[]            invalidChars = new String[] { ":", "\\?", "\\|", "\\\\", "/", "\\*" };
    static String[]            encodeChars  = new String[] { "_COMMA_", "_Q_MARK_", "_PIPE_",
            "_BACK_SLASH_", "_SLASH_", "_ASTERISK_" };
    static String[]            decodeChars  = new String[] { ":", "?", "|", "\\", "/", "*" };


    public static Timestamp getCurrentTime() {
        final Date date = new Date();
        return new Timestamp(date.getTime());
    }


    public static String encodeFNIfUnderWin(final String string) {
        if (!isWindowsOs()) {
            return string;
        }
        String encode = string;
        final String[] ss = invalidChars;
        final String[] sp = encodeChars;
        for (int i = 0; i < invalidChars.length; i++) {
            final String s = ss[i];
            final String p = sp[i];
            encode = encode.replaceAll(s, p);
        }
        return encode;
    }


    public static String decodeFnIfUnderWin(final String fn) {
        if (!isWindowsOs()) {
            return fn;
        }
        String decode = fn;
        final String[] ss = encodeChars;
        final String[] sp = invalidChars;
        for (int i = 0; i < invalidChars.length; i++) {
            final String s = ss[i];
            final String p = sp[i];
            decode = decode.replaceAll(s, p);
        }
        return decode;
    }


    public static boolean isWindowsOs() {
        return System.getProperty("os.name").contains("Windows");
    }


    public static void pause() {
        System.out.println("press ANY KEY to QUIT.");
        logger.warn("press ANY KEY to QUIT.");
        final Scanner scanner = new Scanner(System.in);
        scanner.next();
        scanner.close();
    }


    /**
     * 强制系统退出
     */
    public static void system_exit() {
        System.out.println("系统遇到严重错误,强制退出(exit)");
        logger.fatal("系统遇到严重错误,强制退出(exit)");
        System.exit(1);
    }


    /**
     * 解析类于2.0.4(major.minor.bug-fix这样的版本为数字)
     * 
     * @param version
     * @return
     */
    public static int getVersionNumber(final String version) {
        if (!StringUtils.hasText(version)) {
            return -1;
        }

        final String[] vs = version.split("\\.");
        int sum = 0;
        for (int i = 0; i < vs.length; i++) {
            try {
                sum = (sum * 10) + Integer.parseInt(vs[i]);
            } catch (final Exception e) {
            }
        }
        return sum;
    }


    private static String getLocalAddress() {

        try {
            // 遍历网卡，查找一个非回路ip地址并返回
            final Enumeration<NetworkInterface> enumeration = NetworkInterface
                    .getNetworkInterfaces();
            InetAddress ipv6Address = null;
            while (enumeration.hasMoreElements()) {
                final NetworkInterface networkInterface = enumeration.nextElement();
                final Enumeration<InetAddress> en = networkInterface.getInetAddresses();
                while (en.hasMoreElements()) {
                    final InetAddress address = en.nextElement();
                    if (!address.isLoopbackAddress() && address.isSiteLocalAddress()) {
                        if (address instanceof Inet6Address) {
                            ipv6Address = address;
                        } else {
                            // 优先使用ipv4
                            return normalizeHostAddress(address);
                        }
                    }

                }

            }
            // 没有ipv4，再使用ipv6
            if (ipv6Address != null) {
                return normalizeHostAddress(ipv6Address);
            }
            final InetAddress localHost = InetAddress.getLocalHost();
            return normalizeHostAddress(localHost);
        } catch (final Exception e) {
            return "127.0.0.1";
        }
    }


    private static String normalizeHostAddress(final InetAddress localHost) {
        if (localHost instanceof Inet6Address) {
            return "[" + localHost.getHostAddress() + "]";
        } else {
            return localHost.getHostAddress();
        }
    }


    public abstract static class LineHandle {
        public abstract void process(String line);


        public boolean isBreak() {
            return false;
        }
    }


    public static void forEachLine(final String string, final LineHandle handle) {
        BufferedReader br = new BufferedReader(new StringReader(string));
        try {
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    handle.process(line);
                    if (handle.isBreak()) {
                        break;
                    }
                }
            } catch (final Exception e) {
                logger.error("read line failed", e);
            }

        } finally {
            try {
                br.close();
            } catch (final IOException e) {
                // ignore
            }
            br = null;
        }
    }


    /**
     * 移除集合中的null元素
     * 
     * @param collection
     */
    public static <C extends Collection<T>, T> C removeNull(final C collection) {
        if (collection == null) {
            return collection;
        }

        final Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            final T listener = iterator.next();
            if (listener == null) {
                iterator.remove();
            }
        }
        return collection;
    }


}
