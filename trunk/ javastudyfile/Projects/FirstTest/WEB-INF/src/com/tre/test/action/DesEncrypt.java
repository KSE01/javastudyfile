package com.tre.test.action;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.SecureRandom;
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
    //private static final String ALGORITHM = "DES"; 
    public static final String ALGORITHM = "DESede"; 
    /**
     * 密钥
     * 可随便定义更改
     */
    private static final String ENCKEY = "8WtAcJFMf9M"; 
    //public static final String ALGORITHM = "DESede";   
    
    @SuppressWarnings("unchecked")
	public static String getStrFromObj(Map obj) throws Exception {
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        String strValue = baos.toString("ISO-8859-1");
        String encodedValue = java.net.URLEncoder.encode(strValue,"UTF-8");
        return encodedValue;
    }
    
	@SuppressWarnings("unchecked")
	public static Map getObjFromStr(String str) throws Exception {
	    String decoderValue = java.net.URLDecoder.decode(str,"UTF-8");
	    //Cart result = new Cart();
	    ByteArrayInputStream bais = new ByteArrayInputStream(decoderValue.getBytes("ISO-8859-1"));
	    ObjectInputStream ios = new ObjectInputStream(bais);
	    return (Map) ios.readObject();
    }
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
     * 如果没有定义则使用默认的字符串生成密钥
     * @return  
     * @throws Exception  
     */  
    public static String initKey() throws Exception {   
        return initKey(ENCKEY);   
    }   
  
    /**  
     * 生成密钥  
     *   
     * @param seed  
     * @return  
     * @throws Exception  
     */  
    public static String initKey(String seed) throws Exception {   
        SecureRandom secureRandom = null;   
  
        if (seed != null) {   
            secureRandom = new SecureRandom(decryptBASE64(seed));   
        } else {   
            secureRandom = new SecureRandom();   
        }   
  
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);   
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
     * 加密  
     *   
     * @param srcStr 
     * @return  
     * @throws Exception  
     */  
    public static String encrypt(String srcStr) throws Exception {
    	String strKey = initKey();
    	
    	Key k = toKey(decryptBASE64(strKey));
    	
        Cipher cipher = Cipher.getInstance(ALGORITHM);   
        cipher.init(Cipher.ENCRYPT_MODE, k);   
        
        byte[] strEnc = cipher.doFinal(srcStr.getBytes());
        return encryptBASE64(strEnc);
    }
    
    /**  
     * 解密  
     *
     * @param srcStr  
     * @return  
     * @throws Exception  
     */  
    public static String decrypt(String srcStr) throws Exception {   
    	String strKey = initKey();
    	
    	Key k = toKey(decryptBASE64(strKey));
  
        Cipher cipher = Cipher.getInstance(ALGORITHM);   
        cipher.init(Cipher.DECRYPT_MODE, k);   
        
        byte[] str64Dec = decryptBASE64(srcStr);
        byte[] strDec = cipher.doFinal(str64Dec);
        return new String(strDec);  
    }     
}
