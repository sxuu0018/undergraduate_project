package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.util.Util;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Util.init(request);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>星聊管理系统</title>\r\n");
      out.write("<!--                       CSS                       -->\r\n");
      out.write("<!-- Reset Stylesheet -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/reset.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<!-- Main Stylesheet -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/style.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/invalid.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<!--                       Javascripts                       -->\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/scripts/jquery-1.3.2.min.js\"></script>\r\n");
      out.write("<!-- jQuery Configuration -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/scripts/simpla.jquery.configuration.js\"></script>\r\n");
      out.write("<!-- Facebox jQuery Plugin -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/scripts/facebox.js\"></script>\r\n");
      out.write("<!-- jQuery WYSIWYG Plugin -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/scripts/jquery.wysiwyg.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("function checkform(){\r\n");
      out.write("\t\r\n");
      out.write("\t \r\n");
      out.write("\t    if (document.getElementById('usernameid').value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"账户不能为空\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("    if (document.getElementById('passwordid').value==\"\")\r\n");
      out.write("\t{\r\n");
      out.write("\t\talert(\"密码不能为空\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function register(){\r\n");
      out.write("\t\r\n");
      out.write("\t \r\n");
      out.write("\t    window.location.href='register.jsp';\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body id=\"login\">\r\n");
      out.write("<div id=\"login-wrapper\" class=\"png_bg\">\r\n");
      out.write("  <div id=\"login-top\">\r\n");
      out.write("    <h1></h1>\r\n");
      out.write("  \r\n");
      out.write("    <!--<a href=\"#\">  -->\r\n");
      out.write("    <span style=\"font-size: 40px;font-weight: bold;\">星聊管理系统</span>\r\n");
      out.write("    <!-- </a> --> </div>\r\n");
      out.write("  <!-- End #logn-top -->\r\n");
      out.write("  <div id=\"login-content\">\r\n");
      out.write("  \r\n");
      out.write("     <form method=\"post\"   action=\"method!login\" onsubmit=\"return checkform()\">\r\n");
      out.write("      \r\n");
      out.write("      <p>\r\n");
      out.write("        <label>账户：</label>\r\n");
      out.write("        <input class=\"text-input\" type=\"text\" name=\"username\" id=\"usernameid\"/>\r\n");
      out.write("      </p>\r\n");
      out.write("      <div class=\"clear\"></div>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label>密码：</label>\r\n");
      out.write("        <input class=\"text-input\" type=\"password\" name=\"password\" id=\"passwordid\"/>\r\n");
      out.write("      </p>\r\n");
      out.write("      <div class=\"clear\"></div>\r\n");
      out.write("      <p>\r\n");
      out.write("        <label> \r\n");
      out.write("        \r\n");
      out.write("     \r\n");
      out.write("        </label>\r\n");
      out.write("         <input class=\"button\" type=\"submit\" value=\"登 录\" />\r\n");
      out.write("      </p>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- End #login-content -->\r\n");
      out.write("</div>\r\n");
      out.write("<!-- End #login-wrapper -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
