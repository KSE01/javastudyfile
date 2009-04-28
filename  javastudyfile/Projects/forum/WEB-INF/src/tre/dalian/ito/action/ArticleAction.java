package tre.dalian.ito.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tre.dalian.ito.dao.ArticleDao;
import tre.dalian.ito.dao.Base;
import tre.dalian.ito.dto.ArticleDto;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ArticleDto> articleList;
	private String test;
	private int currentPage;
	private int shownum;
	public int getShownum() {
		return shownum;
	}
	public void setShownum(int shownum) {
		this.shownum = shownum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int pageCount;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<ArticleDto> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<ArticleDto> articleList) {
		this.articleList = articleList;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	@Override
	public String execute() throws Exception {
		this.articleList=new ArrayList<ArticleDto>();
		Base base=new Base();
		base.creatConnect();
		Connection con=base.databaseConnection;
		PreparedStatement pst=null;
		ResultSet rt=null;
		ArticleDao dao=new ArticleDao();
		pst=dao.getArticle(con,currentPage-1,shownum);
		rt=pst.executeQuery();
		while(rt.next()){
			ArticleDto articledto=new ArticleDto();
			articledto.setArticleid(rt.getInt("articleid"));
			articledto.setSubject(rt.getString("subject"));
			articledto.setReadnum(rt.getInt("readnum"));
			articledto.setReplynum(rt.getInt("replynum"));
			articledto.setAuthorid(rt.getString("authorid"));
			ResultSet reprt=null;
			PreparedStatement repst=null;
			repst=dao.getReply(con, rt.getInt("articleid"));
			reprt=repst.executeQuery();
			while(reprt.next()){
				articledto.setNewreply(reprt.getString("author"));
			}
			repst.close();
			reprt.close();
			articleList.add(articledto);
			//System.out.println(rt.getInt("articleid"));
		}
		//this.test="bb";
		pst.close();
		rt.close();
		pst=dao.getCount(con);
		rt=pst.executeQuery();
		while(rt.next()){
			this.pageCount=(rt.getInt("count")+shownum-1)/shownum;
		}
		pst.close();
		rt.close();
		base.closeConnect();
		return SUCCESS;
	}

}
