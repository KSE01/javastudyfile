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
//			// 获得当前时间
//			int max=1;
//			int min = 10000;
//			for(int i=0;i<100;i++){
//				// 时间格式
//				DateFormat format = new SimpleDateFormat("yyyyMMdd");
//
//				// 获得当前时间
//				Calendar nowTime = new GregorianCalendar();
//				long totalMillis = nowTime.getTimeInMillis();
//				String strTotalMillis = String.format("%014d", totalMillis);
//				String strYMD = format.format(nowTime.getTime());
//				
//				// 生成5位随机数
//				String strRandomNum = String.format("%04.0f", Math.random() * 10000);
//
//				// 最后的生成的唯一值 因为上面对总秒数格式化后前面有0 因此在最前面增加一个1
//				String a = strYMD + strTotalMillis + strRandomNum;
//				
////				String a = "1"+strTotalMillis + strRandomNum;
//				System.out.println(a);
//				
//			}
			
			///////////////////////////////////
			String asd = "wangwentao";
			
			String aaa = DesEncrypt.desEncrypt(asd);
			System.out.println(aaa);
			
			String aab = DesEncrypt.desDecrypt(aaa);
			System.out.println(aab);
			
			String aac = DesEncrypt.getMd5(asd);
			System.out.println(aac);
			
			System.out.println(DesEncrypt.getUniqueId());
			
			
		} catch (java.lang.Exception e){
			System.out.println(e.getMessage()+"w");
		}
		
	}

}
