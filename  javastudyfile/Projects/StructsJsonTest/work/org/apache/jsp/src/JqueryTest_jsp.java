package org.apache.jsp.src;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class JqueryTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=windows-31j");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-31j\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.3.1.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\r\n");
      out.write("\t$('#showjquery').click(function(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\turl:\"JsonTest.action\",\r\n");
      out.write("\t\t\t\tsuccess:function(data)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\tvar jsobj = eval('('+data+')');\r\n");
      out.write("\t\t\t\t\tvar name = jsobj.name;\r\n");
      out.write("\t\t\t\t\tvar code = jsobj.personCode;\r\n");
      out.write("\t\t\t\t\tvar str = \"<UL> <Li>\"+name+\"</Li><Li>\"+code+\"</Li>\";\r\n");
      out.write("\t\t\t\t\tvar liststr = \"<li><UL>\";\r\n");
      out.write("\t\t\t\t\tfor(i=0;i<jsobj.personList.length;i++)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tliststr += \"<Li>\";\r\n");
      out.write("\t\t\t\t\t\tliststr += jsobj.personList[i];\r\n");
      out.write("\t\t\t\t\t\tliststr += \"</Li>\"\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tliststr += \"</UL></Li>\";\r\n");
      out.write("\t\t\t\t\tstr = str + liststr + \"</UL>\"\r\n");
      out.write("\t\t\t\t\t$('#jsTest').append(str);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t});\t\r\n");
      out.write("\t\t});\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<input id=\"showjquery\" type=\"button\" value=\"OK\">\r\n");
      out.write("\t<div id=\"jsTest\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
