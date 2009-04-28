package tre.dalian.ito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tre.dalian.ito.dto.UserDTO;

public class UserDAO {

	public static PreparedStatement findName(Connection argConnection,
			UserDTO userdto) throws SQLException {

		//
		PreparedStatement pstmt = null;

		//  
		String statement1 = "SELECT userid,username,password FROM bbs_user ";

		//  
		StringBuffer whereStatement = null;

		//
		whereStatement = new StringBuffer("WHERE userid = '"
				+ userdto.getUserid() + "' AND deleteflag = 0");

		statement1 += whereStatement;

		//
		pstmt = argConnection.prepareStatement(statement1,
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// 
		return pstmt;
	}

	public static PreparedStatement checkUserRegister(Connection argConnection,
			UserDTO userdto) throws SQLException {

		//
		PreparedStatement pstmt = null;

		//  
		String statement1 = "SELECT userid FROM bbs_user ";

		//  
		StringBuffer whereStatement = null;

		//
		whereStatement = new StringBuffer("WHERE userid = '"
				+ userdto.getUserid() + "' AND deleteflag = 0");

		statement1 += whereStatement;

		//
		pstmt = argConnection.prepareStatement(statement1,
				ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// 
		return pstmt;
	}
	
	public static PreparedStatement userRegister(Connection argConnection,
			UserDTO userdto) throws SQLException {

		PreparedStatement pstmt = null;
		//  
		String statement1 = "INSERT INTO bbs_user (" + "  userid" + " ,username"
			    + " ,password" + " ,deleteflag" + " ,createdate"
				+ " )" + " VALUES ( " + "? " + " ,? " +  " ,? " + " ,? "
				+ " ,? " + ")";
		pstmt = argConnection.prepareStatement(statement1);
		int parameterIndex = 1;
		// 
		if (!"".equals(userdto.getUserid())) {
			pstmt.setString(parameterIndex, userdto.getUserid());
			parameterIndex++;
		}

		if (userdto.getUsername().trim() != "") {
			pstmt.setString(parameterIndex, userdto.getUsername());
			parameterIndex++;
		}

		if (!"".equals(userdto.getPassword())) {
			pstmt.setString(parameterIndex, userdto.getPassword());
			parameterIndex++;
		}

		pstmt.setInt(parameterIndex, 0);
		parameterIndex++;

		pstmt.setTimestamp(parameterIndex, userdto.getCreatedate());
		parameterIndex++;

		return pstmt;
	}

}
