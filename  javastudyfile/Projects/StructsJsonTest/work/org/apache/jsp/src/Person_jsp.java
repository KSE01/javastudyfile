package org.apache.jsp.src;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Person_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function createxmlhttp()\r\n");
      out.write("{\r\n");
      out.write("\t\t//xmlhttpクラスを作成\r\n");
      out.write("\t\tvar xmlhttp = false;\r\n");
      out.write("\t\ttry\t\r\n");
      out.write("\t\t{\t\r\n");
      out.write("\t\t\t//サーバーに「ＨTTP」リクエストを発送するために、「XMLHttpRequest」クラスを創建しました\r\n");
      out.write("  \t\txmlhttp = new ActiveXObject(\"Msxml2.XMLHTTP\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcatch (e) \r\n");
      out.write("\t\t{\r\n");
      out.write("   \t\ttry \r\n");
      out.write("   \t\t{\r\n");
      out.write("   \t\t\t//サーバーに「ＨTTP」リクエストを発送するために、「XMLHttpRequest」クラスを創建しました\r\n");
      out.write("    \t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("   \t\t} \r\n");
      out.write("   \t\tcatch (e) \r\n");
      out.write("   \t\t{\r\n");
      out.write("    \t\txmlhttp = false;\r\n");
      out.write("   \t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif (!xmlhttp && typeof XMLHttpRequest != 'undefined') \r\n");
      out.write("\t{\r\n");
      out.write("\t\t\txmlhttp = new XMLHttpRequest();\r\n");
      out.write("\t    if (xmlhttp.overrideMimeType)\r\n");
      out.write("   \t\t{\r\n");
      out.write("  \t\t\txmlhttp.overrideMimeType('text/xml');\r\n");
      out.write("   \t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\treturn xmlhttp;\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function showJson()\r\n");
      out.write("{\r\n");
      out.write("\tvar xmlhttp = createxmlhttp();\r\n");
      out.write("    xmlhttp.onreadystatechange=requestdata;\r\n");
      out.write("    var url = \"JsonTest.action\";\r\n");
      out.write("\txmlhttp.open(\"GET\",url,true);\r\n");
      out.write("\txmlhttp.setRequestHeader(\"If-Modified-Since\",\"0\");\r\n");
      out.write("\txmlhttp.setRequestHeader(\"Content-Type\",\"application/x-www-form-urlencoded\");\r\n");
      out.write("\txmlhttp.send(null);\r\n");
      out.write("\tfunction requestdata()\r\n");
      out.write("\t{\r\n");
      out.write("   \t\tif (xmlhttp.readyState == 4)\r\n");
      out.write("   \t\t{\r\n");
      out.write("       \t\tif (xmlhttp.status == 200)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("               \t\t//alert(xmlhttp.responseText);\r\n");
      out.write("           \t\tvar jsobj = eval('('+xmlhttp.responseText+')')\r\n");
      out.write("           \t\tvar htmlobj = document.getElementById(\"jsTest\");\r\n");
      out.write("           \t\tvar ULobj = document.createElement(\"UL\");\r\n");
      out.write("           \t\t\r\n");
      out.write("           \t\tvar Liobj = document.createElement(\"Li\");\r\n");
      out.write("           \t\tLiobj.innerText = jsobj.name\r\n");
      out.write("           \t\tULobj.appendChild(Liobj);\r\n");
      out.write("           \t\t\r\n");
      out.write("           \t\tvar Liobj1 = document.createElement(\"Li\");\r\n");
      out.write("           \t\tLiobj1.innerText = jsobj.PersonCode\r\n");
      out.write("           \t\tULobj.appendChild(Liobj1);\r\n");
      out.write("\r\n");
      out.write("           \t\tvar Liobj2 = document.createElement(\"Li\");\r\n");
      out.write("           \t\tvar ULobj1 = document.createElement(\"UL\");\r\n");
      out.write("           \t\tfor(i=0;i<jsobj.personList.length;i++)\r\n");
      out.write("           \t\t{\r\n");
      out.write("               \t\tvar Li = document.createElement(\"Li\");\r\n");
      out.write("               \t\tLi.innerText = jsobj.personList[i];\r\n");
      out.write("               \t\tULobj1.appendChild(Li);\r\n");
      out.write("           \t\t}\r\n");
      out.write("           \t\tLiobj2.appendChild(ULobj1);\r\n");
      out.write("           \t\tULobj.appendChild(Liobj2);\r\n");
      out.write("           \t\t\r\n");
      out.write("           \t\thtmlobj.appendChild(ULobj);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form>\r\n");
      out.write("<input type=\"button\" onclick=\"showJson()\" value=\"OK\">\r\n");
      out.write("<div id=\"jsTest\"></div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
