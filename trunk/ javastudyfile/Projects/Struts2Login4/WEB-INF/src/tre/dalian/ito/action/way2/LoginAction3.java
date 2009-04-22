package tre.dalian.ito.action.way2;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import tre.dalian.ito.model.User;

import com.opensymphony.xwork2.Action;

public class LoginAction3 implements Action
{	
  private User user;
  
  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  @Override
  public String execute() throws Exception
  {
    if("admin".equals(user.getUsername()) && "1234".equals(user.getPassword()))
    {
      HttpServletRequest request = ServletActionContext.getRequest();       
      HttpSession session = request.getSession();
      ServletContext context = ServletActionContext.getServletContext();      
      
      /*ActionContext ctx = ActionContext.getContext();
      HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);        
      HttpSession session = request.getSession();
      ServletContext context = (ServletContext)ctx.get(ServletActionContext.SERVLET_CONTEXT);*/
      
      //在请求中放置欢迎信息
      request.setAttribute("greeting", "欢迎参加JAVA教育");
      
      //在session中保存User对象
      session.setAttribute("user", user);
      
      //统计用户访问量，在application中保存用户访问量数据
      Integer count = (Integer)context.getAttribute("counter");
      if(null == count)
        count=1;
      else
        count++;
      context.setAttribute("counter", count);
      
      return SUCCESS;
    }
    else
    {
      return ERROR;
    }
  }
}
