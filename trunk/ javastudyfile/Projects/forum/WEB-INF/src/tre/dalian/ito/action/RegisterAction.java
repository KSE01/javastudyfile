package tre.dalian.ito.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import tre.dalian.ito.dao.UserDAO;
import tre.dalian.ito.dto.UserDTO;
import tre.dalian.ito.service.Check;
import tre.dalian.ito.service.DBJdbc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	UserDTO userDTO = new UserDTO();
	Check checkType = new Check();
	private String registerUserId;
	private String registerUserName;
	private String emailId;
	private String registerPassword;
	private String checkRegisterPassword;
	private String checkUserId;
	private String errorMessage;

	public String getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
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

	public String getRegisterUserName() {
		return registerUserName;
	}

	public void setRegisterUserName(String registerUserName) {
		this.registerUserName = registerUserName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRegisterPassword() {
		return registerPassword;
	}

	public void setRegisterPassword(String registerPassword) {
		this.registerPassword = registerPassword;
	}

	public String getCheckRegisterPassword() {
		return checkRegisterPassword;
	}

	public void setCheckRegisterPassword(String checkRegisterPassword) {
		this.checkRegisterPassword = checkRegisterPassword;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		userDTO.setUserid(registerUserId);
		userDTO.setUsername(registerUserName);
		userDTO.setPassword(registerPassword);
		userDTO.setEmail(emailId);
		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		userDTO.setCreatedate(new java.sql.Timestamp(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").parse(currentTime).getTime()));
		// con.setAutoCommit(false);
		try {
			con = DBJdbc.open();
			ps = UserDAO.userRegister(con, userDTO);
			ps.executeUpdate();
			addActionMessage("注册成功了，请赶紧登陆吧");
			// con.commit();
			ActionContext.getContext().getSession().put("userid", registerUserId);
			ActionContext.getContext().getSession().put("username", registerUserName);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return INPUT;
		} finally {
			// 关闭
			DBJdbc.close(rs, ps, con);
		}
	}
}
