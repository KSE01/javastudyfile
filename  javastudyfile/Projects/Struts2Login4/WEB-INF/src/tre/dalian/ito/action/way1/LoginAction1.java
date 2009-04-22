package tre.dalian.ito.action.way1;

import java.util.Map;
import tre.dalian.ito.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction1 implements Action{	
	private User user;
  
	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

  @SuppressWarnings("unchecked")
  @Override
	public String execute() throws Exception{
	  	if("admin".equals(user.getUsername())
	  		&&"1234".equals(user.getPassword())){
	  		
	  		ActionContext context = ActionContext.getContext(); 
	  		Map request = (Map)context.get("request");
	  		Map session = context.getSession();
	  		Map application = context.getApplication();
      
	  		//在请求中放置欢迎信息
	  		request.put("greeting", "欢迎参加JAVA教育");      
      
	  		//在session中保存user对象
	  		session.put("user", user);
      
	  		//统计用户访问量，在application中保存用户访问量数据
	  		Integer count = (Integer)application.get("counter");
	  		if(null == count){
	  			count = 1;
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