package com.aoyetech.fee.commons.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-12-3 上午9:49:45
 **/

public class MD5 {

    private static final Log               log     = LogFactory.getLog(MD5.class);
    private static char[]                  digits  = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f'     };

    private static Map<Character, Integer> rDigits = new HashMap<Character, Integer>(16);
    static {
        for (int i = 0; i < digits.length; ++i) {
            rDigits.put(digits[i], i);
        }
    }

    private static MD5                     me      = new MD5();
    private MessageDigest                  mHasher;
    private final ReentrantLock            opLock  = new ReentrantLock();


    private MD5() {
        try {
            this.mHasher = MessageDigest.getInstance("md5");
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static MD5 getInstance() {
        return me;
    }


    public String getMD5String(final String content) {
        return this.bytes2string(this.hash(content));
    }


    public String getMD5String(final byte[] content) {
        return this.bytes2string(this.hash(content));
    }


    public byte[] getMD5Bytes(final byte[] content) {
        return this.hash(content);
    }


    /**
     * 对字符串进行md5
     * 
     * @param str
     * @return md5 byte[16]
     */
    public byte[] hash(final String str) {
        this.opLock.lock();
        try {
            final byte[] bt = this.mHasher.digest(str.getBytes(Constants.ENCODE));
            if ((null == bt) || (bt.length != 16)) {
                throw new IllegalArgumentException("md5 need");
            }
            return bt;
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException("unsupported utf-8 encoding", e);
        } finally {
            this.opLock.unlock();
        }
    }


    /**
     * 对二进制数据进行md5
     * 
     * @param str
     * @return md5 byte[16]
     */
    public byte[] hash(final byte[] data) {
        this.opLock.lock();
        try {
            final byte[] bt = this.mHasher.digest(data);
            if ((null == bt) || (bt.length != 16)) {
                throw new IllegalArgumentException("md5 need");
            }
            return bt;
        } finally {
            this.opLock.unlock();
        }
    }


    /**
     * 将一个字节数组转化为可见的字符串
     * 
     * @param bt
     * @return
     */
    public String bytes2string(final byte[] bt) {
        final int l = bt.length;

        final char[] out = new char[l << 1];

        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = digits[(0xF0 & bt[i]) >>> 4];
            out[j++] = digits[0x0F & bt[i]];
        }

        if (log.isDebugEnabled()) {
            log.debug("[hash]" + (new String(out)));
        }

        return new String(out);
    }


    /**
     * 将字符串转换为bytes
     * 
     * @param str
     * @return byte[]
     */
    public byte[] string2bytes(final String str) {
        if (null == str) {
            throw new NullPointerException("参数不能为空");
        }
        if (str.length() != 32) {
            throw new IllegalArgumentException("字符串长度必须是32");
        }
        final byte[] data = new byte[16];
        final char[] chs = str.toCharArray();
        for (int i = 0; i < 16; ++i) {
            final int h = rDigits.get(chs[i * 2]).intValue();
            final int l = rDigits.get(chs[(i * 2) + 1]).intValue();
            data[i] = (byte) (((h & 0x0F) << 4) | (l & 0x0F));
        }
        return data;
    }
}
