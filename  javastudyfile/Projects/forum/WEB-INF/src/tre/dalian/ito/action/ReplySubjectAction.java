package tre.dalian.ito.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tre.dalian.ito.service.DBJdbc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReplySubjectAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement st;
	ResultSet rs;
	private String replySubject;
	private String replyBody;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReplySubject() {
		return replySubject;
	}

	public void setReplySubject(String replySubject) {
		this.replySubject = replySubject;
	}

	public String getReplyBody() {
		return replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}

	@Override
	public String execute() throws Exception {
		// 返信
		StringBuffer sql1 = new StringBuffer();
		sql1.append("INSERT INTO reply( articleid, subject, body, author, createdate,updatedate)VALUES ('");
		sql1.append(getId());
		sql1.append("','");
		sql1.append(getReplySubject());
		sql1.append("','");
		sql1.append(getReplyBody());
		sql1.append("','");
		sql1.append(ActionContext.getContext().getSession().get("userid").toString());
		sql1.append("', (SELECT LOCALTIMESTAMP(0)),(SELECT LOCALTIMESTAMP(0)))");
		String sql2 = "UPDATE replynum SET num=(SELECT num FROM replynum WHERE articleid="+id+")+1 WHERE articleid="+id;
		setId(getId());
		try {
			con = DBJdbc.open();
			st = con.createStatement();
			st.executeUpdate(sql1.toString()); //数据库更新操作1
			st.executeUpdate(sql2);//数据库更新操作2
			con.commit(); //事务提交
		} catch (SQLException e) {
			e.printStackTrace();
			if(con!=null){
				con.rollback(); //操作不成功则回滚
				}
		} finally {
			// 关闭
			DBJdbc.close(rs, st, con);
		}
		return SUCCESS;
	}
}
