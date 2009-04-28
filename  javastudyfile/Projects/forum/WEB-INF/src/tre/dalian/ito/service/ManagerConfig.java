/**---------------------------------------------------------------
 *
 *
 *赵圣龙
 *  2009/04/14                    1.00   
 * 	2009/04/15                    2.00   
 * 
 *---------------------------------------------------------------
 */
package tre.dalian.ito.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ManagerConfig {
	private static final String ManagerDirectoryFile = "jdbc.properties";
	private static Properties p;
	private ManagerConfig(){
		InputStream i = null;
		p = null;
		i = this.getClass().getClassLoader().getResourceAsStream(
				ManagerDirectoryFile);

		if (i == null) {
			System.out.println("jdbc.properties未找到");
		} else {
			try {
				p = new Properties();
				p.load(i);
				i.close();
				
			} catch (IOException e) {
				p = null;
			} finally {
				i = null;
			}

		}
	}

	
	
	public static String getUrl(){
		new ManagerConfig();
		return p.getProperty("url");
	}
	public static String getName(){
		new ManagerConfig();
		return p.getProperty("name");
	}
	public static String getPass(){
		new ManagerConfig();
		return p.getProperty("pass");
	}
	public static String getDriver(){
		new ManagerConfig();
		return p.getProperty("driver");
	}

}
