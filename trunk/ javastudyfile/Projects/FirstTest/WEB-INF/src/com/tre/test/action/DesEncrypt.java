package com.tre.test.action;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class DesEncrypt {
	/**  
     * ALGORITHM 算法 <br>  
     * 可替换为以下任意一种算法，同时key值的size相应改变。  
     *   
     * <pre>  
     * DES                  key size must be equal to 56  
     * DESede(TripleDES)    key size must be equal to 112 or 168  
     * AES                  key size must be equal to 128, 192 or 256,but 192 and 256 bits may not be available  
     * Blowfish             key size must be multiple of 8, and can only range from 32 to 448 (inclusive)  
     * RC2                  key size must be between 40 and 1024 bits  
     * RC4(ARCFOUR)         key size must be between 40 and 1024 bits  
     * </pre>  
     *   
     * 在Key toKey(byte[] key)方法中使用下述代码  
     * <code>SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);</code> 替换  
     * <code>  
     * DESKeySpec dks = new DESKeySpec(key);  
     * SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);  
     * SecretKey secretKey = keyFactory.generateSecret(dks);  
     * </code>  
     */ 
	private static final String ALGORITHM = "DESede"; 
	
	/**
	 * 密钥
	 */
	private static final String ENCKEYSEED = "8WtAcJFMf9M"; 
	
	/**  
     * BASE64解码
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    public static byte[] decryptBASE64(String key) throws Exception {   
        return (new BASE64Decoder()).decodeBuffer(key);   
    }   
      
    /**  
     * BASE64编码  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    public static String encryptBASE64(byte[] key) throws Exception {   
        return (new BASE64Encoder()).encodeBuffer(key);   
    } 
    
    /**  
     * 生成密钥  
     *   
     * @param seed  
     * @return  
     * @throws Exception  
     */  
    private static String initKey() throws Exception {   
        SecureRandom secureRandom =  new SecureRandom(decryptBASE64(ENCKEYSEED));
  
        KeyGenerator kg = KeyGenerator.getInstance("DESede");   
        kg.init(secureRandom);   
  
        SecretKey secretKey = kg.generateKey();   
  
        return encryptBASE64(secretKey.getEncoded());   
    }
    
    /**  
     * 转换密钥<br>  
     *   
     * @param key  
     * @return  
     * @throws Exception  
     */  
    private static Key toKey(byte[] key) throws Exception {   
//    	  import javax.crypto.SecretKeyFactory;   
//    	  import javax.crypto.spec.DESKeySpec;  
    	
//        DESKeySpec dks = new DESKeySpec(key);   
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);   
//        SecretKey secretKey = keyFactory.generateSecret(dks);   
  
        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码   
        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);   
  
        return secretKey;   
    }   
    /**  
     * DES加密  
     *   
     * @param srcStr 
     * @return  
     * @throws Exception  
     */  
    public static String desEncrypt(String srcStr) throws Exception {
    	String strKey = initKey();
    	
    	Key k = toKey(decryptBASE64(strKey));
    	
        Cipher cipher = Cipher.getInstance(ALGORITHM);   
        cipher.init(Cipher.ENCRYPT_MODE, k);   
        
        byte[] strEnc = cipher.doFinal(srcStr.getBytes());
        return encryptBASE64(strEnc);
    }
    
    /**  
     * DES解密  
     *
     * @param srcStr  
     * @return  
     * @throws Exception  
     */  
    public static String desDecrypt(String srcStr) throws Exception {   
    	String strKey = initKey();
    	
    	Key k = toKey(decryptBASE64(strKey));
  
        Cipher cipher = Cipher.getInstance(ALGORITHM);   
        cipher.init(Cipher.DECRYPT_MODE, k);   
        
        byte[] str64Dec = decryptBASE64(srcStr);
        byte[] strDec = cipher.doFinal(str64Dec);
        return new String(strDec);  
    }
    
    /**
     * 根据传入的字符串生成其MD5码
     * @param plainText
     * @return
     */
	public static String getMd5(String plainText) {
		String pwd = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			pwd = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return pwd;
	}

	/**
	 * 取得一个理论上的唯一值
	 * @return 一个数字字符串
	 */
	public static String getUniqueId() {
		// 时间格式
		DateFormat format = new SimpleDateFormat("yyyyMMdd");

		// 获得当前时间
		Calendar nowTime = new GregorianCalendar();
		long totalMillis = nowTime.getTimeInMillis();
		String strTotalMillis = String.format("%014d", totalMillis);
		String strYMD = format.format(nowTime.getTime());
		
		// 生成5位随机数
		String strRandomNum = String.format("%04.0f", Math.random() * 10000);

		//年月日在存文件时使用
		return strYMD + strTotalMillis + strRandomNum;
	}
}
