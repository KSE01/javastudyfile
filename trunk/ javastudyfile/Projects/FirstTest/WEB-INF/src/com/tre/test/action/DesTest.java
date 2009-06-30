package com.tre.test.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DesTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try{	
			///////////////////////////////////
			List<String> list = new ArrayList<String>();
			list.add("wer1");
			list.add("wer2");
			list.add("wer3");
			list.add("wer4");
			list.add(null);
			Map<String, List<String>> mapList = new HashMap<String, List<String>>(); 
			mapList.put("wang", list);
			
			String strObj = DesEncrypt.getStrFromObj(mapList);
			System.out.println("序列化   "+strObj);
			
			System.out.println("原始数据        "+strObj);
			
			String strEnc = DesEncrypt.encrypt(strObj);			
			System.out.println("加密后数据   "+strEnc);

			String strDec = DesEncrypt.decrypt(strEnc);	
			System.out.println("解密后数据   "+strDec);
			
			Map<String, List<String>> mapsd = new HashMap<String, List<String>>(); 
			mapsd = DesEncrypt.getObjFromStr(strDec);
			List<String> alsd = mapsd.get("wang");
			System.out.println("反序列化   "+alsd.size());
			
		} catch (java.lang.Exception e){
			System.out.println(e.getMessage()+"w");
		}
		
	}

}
