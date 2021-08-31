package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/left.jsp");
  }

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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>欢迎来到星聊</title>\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"body-wrapper\">\r\n");
      out.write("  <!-- Wrapper for the radial gradient background -->\r\n");
      out.write("  <div id=\"sidebar\">\r\n");
      out.write("    \r\n");
      out.write("     ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"sidebar\">\r\n");
      out.write("    <div id=\"sidebar-wrapper\">\r\n");
      out.write("     <br/>\r\n");
      out.write("      \r\n");
      out.write("      <a href=\"#\">\r\n");
      out.write("      <span style=\"font-size: 30px;font-weight: bold;\">管理菜单</span>\r\n");
      out.write("      </a>\r\n");
      out.write("     \r\n");
      out.write("      \r\n");
      out.write("      <ul id=\"main-nav\">\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("        \r\n");
      out.write("         <li> <a href=\"#\" class=\"nav-top-item\">文章分类</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!fenleilist\">文章分类管理</a></li>\r\n");
      out.write("            <li><a href=\"method!fenleiadd\">添加文章分类</a></li>\r\n");
      out.write("        \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("         <li> <a href=\"#\" class=\"nav-top-item\">星座文章</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!xinwenlist\">文章管理</a></li>\r\n");
      out.write("            <li><a href=\"method!xinwenadd\">添加文章</a></li>\r\n");
      out.write("        \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li> <a href=\"#\" class=\"nav-top-item\">评价</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!pingjialist\">评价管理</a></li>\r\n");
      out.write("           \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li> <a href=\"#\" class=\"nav-top-item\">用户</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!userlist\">用户管理</a></li>\r\n");
      out.write("           \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        <li> <a href=\"#\" class=\"nav-top-item\">修改密码</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!passwordupdate\">修改密码</a></li>\r\n");
      out.write("           \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("         <li> <a href=\"#\" class=\"nav-top-item\">安全退出</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!loginout\">安全退出</a></li>\r\n");
      out.write("           \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <!-- End #sidebar -->");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("  <div id=\"main-content\">\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("    <h2>欢迎管理员");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("使用星聊管理系统</h2>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- End #main-content -->\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<!-- Download From www.exet.tk-->\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
