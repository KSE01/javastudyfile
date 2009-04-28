package tre.dalian.ito.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import tre.dalian.ito.dao.UserDAO;
import tre.dalian.ito.dto.UserDTO;

import com.opensymphony.xwork2.ActionSupport;

public class Check extends ActionSupport {
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	DBJdbc jdbc = new DBJdbc();
	UserDTO userDTO = new UserDTO();
	private String registerUserId;
	private String checkUserId;
	private String errorMessage;
	private String registerPassword;

	public String getRegisterPassword() {
		return registerPassword;
	}

	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRegisterUserId() {
		return registerUserId;
	}

	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}

	public String getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
	}

	public String checkUser() {

		userDTO.setUserid(registerUserId);
		try {
			if (!checkType(registerUserId)) {
				errorMessage = "用户名只能由数字、字母和下划线组成";
				return SUCCESS;
			}
			con = jdbc.open();
			ps = UserDAO.checkUserRegister(con, userDTO);
			rs = ps.executeQuery();
			if (rs.next()) {
				errorMessage = registerUserId + "已经被注册，请换个用户名";
				return SUCCESS;
			}
			return SUCCESS;
			// con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "服务器异常，请刷新页面再试";
			return SUCCESS;
		}
	}

	public String checkPassword() {

		if (!checkType(registerPassword)) {
			errorMessage = "用户名只能由数字、字母和下划线组成";
		}
		return SUCCESS;
	}

	public boolean checkType(String name) {
		if(name.length() == 0){
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!Character.isDigit(ch) && !Character.isLetter(ch) && ch != '_' && ch != ' '){
				return false;
			}
		}
		return true;
	}
}
