package tre.dalian.ito.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tre.dalian.ito.service.DBJdbc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewSubjectAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	private String subject;
	private String body;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String execute() throws Exception {
		StringBuffer sql1 = new StringBuffer();
		sql1.append("INSERT INTO article(subject, body, authorid, createdate,updatetime) VALUES ('");
		sql1.append(getSubject());
		sql1.append("','");
		sql1.append(getBody());
		sql1.append("','");
		sql1.append(ActionContext.getContext().getSession().get("userid").toString());
		sql1.append("', (SELECT LOCALTIMESTAMP(0)),(SELECT LOCALTIMESTAMP(0)))");
		
		String sql2 = "INSERT INTO readnum(articleid, num) VALUES ((SELECT Max(id) FROM article),0)";
		
		String sql3 = "INSERT INTO replynum(articleid, num) VALUES ((SELECT Max(id) FROM article),0)";
		
		try {
			con = DBJdbc.open();
			st = con.createStatement();
			st.executeUpdate(sql1.toString());//数据库更新操作1
			st.executeUpdate(sql2);//数据库更新操作2
			st.executeUpdate(sql3);//数据库更新操作3
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
