package com.tre.test.action;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ThreeDesEncrypt {
	private static final String Algorithm = "DESede";
	// 24字节的密钥
	private static final String key = "ABCDEFGHIJKLMNOPQRSTUVWX";
	// 定义 加密算法,可用 DES,DESede,Blowfish
	// keybyte为加密密钥，长度为24字节
	// src为被加密的数据缓冲区（源）
	public static byte[] encryptMode(byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	public static String encryptModea(byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			byte[] retByte = c1.doFinal(src);
			return new String(retByte);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	// keybyte为加密密钥，长度为24字节
	// src为加密后的缓冲区
	public static byte[] decryptMode(byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(key.getBytes(), Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 添加新安全算法,如果用JCE就要把它添加进去
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		
		
		String szSrc = "This is a 3DES test. 测试 2200826";
		System.out.println("加密前的字符串:" + szSrc);
		byte[] encoded = encryptMode(szSrc.getBytes());
		
		String enss = encryptModea(szSrc.getBytes());
		System.out.println("加密后的字符串aa:" + enss);
		
		System.out.println("加密后的字符串:" + new String(encoded));
		byte[] srcBytes = decryptMode(encoded);
		byte[] sssss = enss.getBytes();
		byte[] srcBytess = decryptMode(sssss);
		System.out.println("解密后的字符串aa:" + (new String(srcBytess)));
		System.out.println("解密后的字符串:" + (new String(srcBytes)));
	}

}
