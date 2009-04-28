package tre.dalian.ito.dto;

public class ArticleDto {
	private int articleid;
	private String subject;
	private String authorid;
	private int replynum;
	private int readnum;
	private String newreply;
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthorid() {
		return authorid;
	}
	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public int getReadnum() {
		return readnum;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	public String getNewreply() {
		return newreply;
	}
	public void setNewreply(String newreply) {
		this.newreply = newreply;
	}
	
	

}
