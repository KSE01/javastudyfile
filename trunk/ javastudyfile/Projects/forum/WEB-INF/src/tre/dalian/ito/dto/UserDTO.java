package tre.dalian.ito.dto;

public class UserDTO {

	private String userid;
	private String username;
	private String email;
	private String password;
	private int deleteflag;
	private java.sql.Timestamp createdate;
	private java.sql.Timestamp deletedate;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}

	public java.sql.Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.sql.Timestamp createdate) {
		this.createdate = createdate;
	}

	public java.sql.Timestamp getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(java.sql.Timestamp deletedate) {
		this.deletedate = deletedate;
	}

}
