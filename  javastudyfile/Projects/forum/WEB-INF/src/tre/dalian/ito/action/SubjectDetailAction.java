package tre.dalian.ito.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import tre.dalian.ito.service.DBJdbc;
import tre.dalian.ito.service.PageResultSet;
import tre.dalian.ito.service.PageableResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class SubjectDetailAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	Statement st;
	Statement st2;
	ResultSet rs;
	PageResultSet prs;
	HashMap<String, String> map;
	ArrayList<HashMap<String, String>> list;
	private String id;
	private String articlesubject;
	private String articlebody;
	private String articleauthorid;
	private String articlecreatedate;
	private String articleupdatetime;
	private int nowPage;
	private int pageCount;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public String getArticlecreatedate() {
		return articlecreatedate;
	}

	public void setArticlecreatedate(String articlecreatedate) {
		this.articlecreatedate = articlecreatedate;
	}

	public String getArticleupdatetime() {
		return articleupdatetime;
	}

	public void setArticleupdatetime(String articleupdatetime) {
		this.articleupdatetime = articleupdatetime;
	}

	public String getArticlesubject() {
		return articlesubject;
	}

	public void setArticlesubject(String articlesubject) {
		this.articlesubject = articlesubject;
	}

	public String getArticlebody() {
		return articlebody;
	}

	public void setArticlebody(String articlebody) {
		this.articlebody = articlebody;
	}

	public String getArticleauthorid() {
		return articleauthorid;
	}

	public void setArticleauthorid(String articleauthorid) {
		this.articleauthorid = articleauthorid;
	}

	public ArrayList<HashMap<String, String>> getList() {
		return list;
	}

	public void setList(ArrayList<HashMap<String, String>> list) {
		this.list = list;
	}

	public String execute() throws Exception {
			   StringBuffer sql = new StringBuffer();
			   sql.append("select article.subject,article.body,article.authorid,");
			   sql.append("article.createdate,article.updatetime,reply.id,reply.subject,");
			   sql.append("reply.body,reply.author,reply.createdate,reply.updatedate from ");
			   sql.append("article left join reply on article.id = reply.articleid where article.id="+getId());
			   
			   String sql2 = "UPDATE readnum SET num=(SELECT num FROM readnum WHERE articleid="+id+")+1 WHERE articleid="+id;
			   setId(id);
			   try {
			con = DBJdbc.open();
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			st.executeUpdate(sql2);
			rs = st.executeQuery(sql.toString());
			prs=new PageableResultSet(rs);
			if(getFlag()==null){
				prs.gotoPage(1);
			}else{
				if(getFlag().equals("F")){
					prs.gotoPage(1);
				}
				if(getFlag().equals("P")){
					prs.gotoPage(getNowPage()-1);
				}
				if(getFlag().equals("N")){
					prs.gotoPage(getNowPage()+1);
				}
				if(getFlag().equals("L")){
					prs.gotoPage(prs.getPageCount());
				}
			}
			setNowPage(prs.getNowPage());
			setPageCount(prs.getPageCount());
			list=new ArrayList<HashMap<String, String>>();
			setArticlesubject(rs.getString(1));
			//setArticlebody(htmlEncode(rs.getString(2)));
			setArticlebody(rs.getString(2));
			setArticleauthorid(rs.getString(3));
			setArticlecreatedate(rs.getString(4));
			setArticleupdatetime(rs.getString(5));
			if(rs.getString(6)!=null){
		//查询数据库中数据，存入集合中
		for (int i=1;i<=prs.getPageSize();i++){
			map = new HashMap<String, String>();
			map.put("replyid", rs.getString(6));
			map.put("replysubject", rs.getString(7));
			//map.put("replybody", htmlEncode(rs.getString(8)));
			map.put("replybody", rs.getString(8));
			map.put("replyauthor", rs.getString(9));
			map.put("replycreatedate", rs.getString(10));
			map.put("replyupdatedate", rs.getString(11));
			list.add(map);
			rs.next();
		}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBJdbc.close(rs, ps, con);
		}
		return SUCCESS;
	}
	
	public String htmlEncode(String str) {
		str = str.replace(">", "&gt;");
		str = str.replace("<", "&lt;");
		str = str.replace(" ", "&nbsp;");
		str = str.replace(String.valueOf((char) 32), "&nbsp;");
		str = str.replace(String.valueOf((char) 34), "&quot;");
		str = str.replace(String.valueOf((char) 39), "&#39;");
		str = str.replace(String.valueOf((char) 13), "");
		str = str.replace(
				String.valueOf((char) 10) + String.valueOf((char) 10),
				"</p><p>");
		str = str.replace(String.valueOf((char) 10), "<br />");
		return str;
	}
}
