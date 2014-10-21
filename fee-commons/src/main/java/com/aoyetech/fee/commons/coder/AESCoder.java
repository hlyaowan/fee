package com.aoyetech.fee.commons.coder;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AESCoder extends Coder{
	public static final String ALGORITHM = "AES";
	public static final String PROVIDER  = "BC";
	
	static{
		initProvider();
	}
	/**
	 * 注册Provider
	 */
	public static void initProvider(){
		Security.addProvider(new BouncyCastleProvider());
	}
	
	/**
	 * 验证Provider
	 */
	public static void ensureProvider(){
		if(null == Security.getProvider(PROVIDER)){
			Security.addProvider(new BouncyCastleProvider());
		}
	}
	
	/**
	 * 解密
	 * @param raw 密码
	 * @param encrypted 加密内容
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptAES128(byte[] raw, byte[] encrypted)
			throws Exception {
		ensureProvider();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM, PROVIDER);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}
}
