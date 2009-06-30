package com.tre.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.tre.test.dto.ShowCodeTypeDTO;
import com.tre.test.server.DBHelper;
public class ShowCodeTypeDAO {
	public static ArrayList<ShowCodeTypeDTO> getCodeTypeInfo() throws SQLException{
		ArrayList<ShowCodeTypeDTO> dtoList = new ArrayList<ShowCodeTypeDTO>();
		DBHelper dbHelper = new DBHelper();
		Connection con = dbHelper.getConnection();
		Statement stmt = con.createStatement();
		String strSql = "SELECT TypeId, TypeName, Creator, CreateDate, ShowFlg FROM CodeType";
		ResultSet rs = stmt.executeQuery(strSql);
		while(rs.next()){
			ShowCodeTypeDTO tempDTO = new ShowCodeTypeDTO();
			tempDTO.setTypeId(rs.getString("TypeId"));
			tempDTO.setTypeName(rs.getString("TypeName"));
			tempDTO.setCreator(rs.getString("Creator"));
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy/MM/dd");
			tempDTO.setCreateDate(dformat.format(rs.getDate("CreateDate")));
			tempDTO.setShowFlg(rs.getString("ShowFlg"));
			dtoList.add(tempDTO);
		}
		con.close();
		return dtoList;
	}
}
