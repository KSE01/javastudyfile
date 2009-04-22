package tre.dalian.ito.action.way2;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import tre.dalian.ito.model.User;
import com.opensymphony.xwork2.Action;

public class LoginAction4 implements Action,
						ServletRequestAware, ServletContextAware{
	private User user;
	private HttpServletRequest request;
	private ServletContext context;

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}
  
	@Override
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}

	@Override
	public void setServletContext(ServletContext context){
		this.context = context;
	}

	@Override
	public String execute() throws Exception{
		if ("admin".equals(user.getUsername())
				&& "1234".equals(user.getPassword())){
			
			HttpSession session = request.getSession();
			//在请求中放置欢迎信息
			request.setAttribute("greeting", "欢迎参加JAVA教育");

			//在session中保存user对象
			session.setAttribute("user", user);

			//统计用户访问量，在application中保存用户访问量数据
			Integer count = (Integer) context.getAttribute("counter");
			if (null == count){
				count = 1;
			} else{
				count++;
			}
			context.setAttribute("counter", count);

			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
