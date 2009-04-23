package com.tre.test.server;

import java.sql.*;

public class DBHelper {

	private Connection con = null;

	public String GetConnectionString() throws Exception {
		XmlRead xmlRead = new XmlRead("\\NewFile.xml");
		String url = xmlRead.GetNodeVal("/root/DataBase/url");
		String serverName = xmlRead.GetNodeVal("/root/DataBase/serverName");
		String dbName = xmlRead.GetNodeVal("/root/DataBase/dbName");
		String portNum = xmlRead.GetNodeVal("/root/DataBase/portNumber");
		String userName = xmlRead.GetNodeVal("/root/DataBase/userName");
		String passWord = xmlRead.GetNodeVal("/root/DataBase/passWord");

		return url + serverName + ":" + portNum + ";databaseName=" + dbName
				+ ";user=" + userName + ";password=" + passWord + ";";
	}

	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(GetConnectionString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public ResultSet getResultSet(String sql) {
		ResultSet rs = null;
		try {
			if (con != null) {
				Statement stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
			} else {
				throw new Exception("没有可用的连接");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getResultSet(Statement stmt,String sql) {
		ResultSet rs = null;
		try {
			if (con != null) {
				rs = stmt.executeQuery(sql);
			} else {
				throw new Exception("没有可用的连接");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getResultSet(PreparedStatement pstmt) {
		ResultSet rs = null;
		try {
			if (con != null) {
				rs = pstmt.executeQuery();
			} else {
				throw new Exception("没有可用的连接");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public PreparedStatement getPreparedStatement(String sql){
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public void closeConnection() {
		try {
			if (con != null) {
				con.close();
			}
			con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
