package tre.dalian.ito.action.way1;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import tre.dalian.ito.model.User;

import com.opensymphony.xwork2.Action;

public class LoginAction2 implements Action,
					RequestAware,SessionAware,ApplicationAware{	
	
	private User user;
	private Map request;
	private Map session;
	private Map application;
  
	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	@Override
	public void setRequest(Map request){
		this.request = request;
	}

	@Override
	public void setSession(Map session){
		this.session = session;
	}

	@Override
	public void setApplication(Map application){
		this.application = application;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception{
		if("admin".equals(user.getUsername())
			&&"1234".equals(user.getPassword())){ 
      
			//在请求中放置欢迎信息
			request.put("greeting", "欢迎参加JAVA教育");
      
			//在session中保存User对象
			session.put("user", user);
      
			//统计用户访问量，在application中保存用户访问量数据
			Integer count = (Integer)application.get("counter");
			if(null == count){
				count=1;
			}else{
				count++;
			}
			
			application.put("counter", count);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

}
