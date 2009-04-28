package tre.dalian.ito.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBJdbc{
	private static Connection con = null;
	private static final String URL = ManagerConfig.getUrl();
	private static final String NAME = ManagerConfig.getName();
	private static final String PASS = ManagerConfig.getPass();
	private static final String DRIVER = ManagerConfig.getDriver();

	public DBJdbc() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection open() throws SQLException {
			con = DriverManager.getConnection(URL, NAME, PASS);
		return con;
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection con) throws SQLException {
		
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
	
	}
	public static void close(ResultSet rs,Statement st,Connection con) throws SQLException {
		
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (st != null) {
			st.close();
			st = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}

}
}