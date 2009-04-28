package tre.dalian.ito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ArticleDao {
	public PreparedStatement getArticle(Connection con ,int currentPage,int shownum) throws Exception{
		StringBuffer asql=new StringBuffer();
		asql.append("select article.id as articleid,article.subject as subject, ").
		append("article.authorid as authorid,readnum.num as readnum ,replynum.num as replynum " )
		.append(" from article " )
		.append(" left outer join readnum ")
		.append(" on article.id=readnum.articleid " )
		.append(" left outer join replynum " )
		.append(" on article.id=replynum.articleid ")
		.append(" ORDER BY updatetime desc limit "+shownum+" offset ").append(currentPage*shownum);
		String sql=asql.toString();
		PreparedStatement sta=con.prepareStatement(sql);
		return sta;
	}
	public PreparedStatement getCount(Connection con)throws Exception{
		String sql=("select count(*) from article as count");
		PreparedStatement pst=con.prepareStatement(sql);
		return pst;
	}
	public PreparedStatement getReply(Connection con ,int articleid)throws Exception{
		String sql="select author from reply where articleid="+articleid;
			sql+="order by updatedate desc limit 1";
		PreparedStatement pst=con.prepareStatement(sql);
		return pst;
	}
}
