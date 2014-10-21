package com.aoyetech.fee.commons.cache.encrypt;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;


public class Md5Encrypt implements CacheEncrypt {

    private static final byte[] convert = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
            'f'                        };

    public String encrypt(String key) {

        if (StringUtils.isBlank(key)) return null;
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(key.getBytes("UTF-8"));
            byte[] hash = digest.digest();
            byte[] key_hash = new byte[hash.length * 2];
            for (int i = 0, j = 0; i < hash.length; i++) {
                int cur = hash[i] + ((hash[i] < 0) ? 256 : 0);
                int high = cur >>> 4;
                int low = cur & 15;
                key_hash[j++] = convert[high];
                key_hash[j++] = convert[low];
            }
            return new String(key_hash);
        } catch (Exception e) {
            return key;
        }
    }

}
