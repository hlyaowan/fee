/*
 * 
 */
// Created on 2013-5-15

package com.tyyd.open.api.commons.coder.test;

import com.aoyetech.fee.commons.coder.PBECoder;

/**
 * @author joe.chen
 */
public class CoderUserIdTest {

    private static final byte[] SALT = { '0', '1', '2', '3', '4', '5', '6', '7' };

    public static void main(String[] args) throws Exception {
        String uid = PBECoder.encryptBASE64(PBECoder.encrypt("210000065466299".getBytes(), "tonr", SALT));
        byte[] uidb = uid.getBytes();
        uidb = PBECoder.decrypt(PBECoder.decryptBASE64(uid), "tonr", SALT);
        System.out.println(new String(uidb));

        System.out.println(uid);
    }
}
