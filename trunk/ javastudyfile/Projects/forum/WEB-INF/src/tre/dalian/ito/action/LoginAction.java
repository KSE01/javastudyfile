package tre.dalian.ito.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tre.dalian.ito.dao.UserDAO;
import tre.dalian.ito.dto.UserDTO;
import tre.dalian.ito.service.Check;
import tre.dalian.ito.service.DBJdbc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1962703713208767166L;
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	private String txtEmployeeCD;

	private String txtPassword;
	
	List<String> list = new ArrayList<String>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getTxtEmployeeCD() {
		return txtEmployeeCD;
	}

	public void setTxtEmployeeCD(String txtEmployeeCD) {
		this.txtEmployeeCD = txtEmployeeCD;
	}

	public String getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		UserDTO userDTO = new UserDTO();
		Check check = new Check();
		userDTO.setPassword(txtPassword);
		userDTO.setUserid(txtEmployeeCD);
		//检查用户名和密码是否符合要求。
		/*
		if(!check.checkType(txtEmployeeCD)){
			addFieldError("txtEmployeeCD", "用户名只能由数字、字母和 '_' 组成");
			return INPUT;
		}
		
		if(!check.checkType(txtPassword)){
			addFieldError("txtPassword","密码只能由数字、字母和 '_' 组成");
			return INPUT;
		}
		*/
		if(!check.checkType(txtEmployeeCD)||!check.checkType(txtPassword)){
			addActionError( "用户密码不正确");
			return INPUT;
		}
		try{
			con=DBJdbc.open();
			ps=UserDAO.findName(con, userDTO);
			rs = ps.executeQuery();
			if(rs.next()){
				if(txtPassword.equals(rs.getString("password"))){
					ActionContext.getContext().getSession().put("userid", rs.getString("userid"));
					ActionContext.getContext().getSession().put("username", rs.getString("username"));
					return SUCCESS;
				}
				else{
					addActionError( "用户密码不正确");
					return INPUT;
				}
			}
			else{
				addActionMessage("你还没有注册，点击这里进行注册。");
				return INPUT;
			}
			}catch(SQLException e){
				e.printStackTrace();
				return INPUT;
			}finally{
				//关闭
				DBJdbc.close(rs, ps, con);	
			}
	}
}
