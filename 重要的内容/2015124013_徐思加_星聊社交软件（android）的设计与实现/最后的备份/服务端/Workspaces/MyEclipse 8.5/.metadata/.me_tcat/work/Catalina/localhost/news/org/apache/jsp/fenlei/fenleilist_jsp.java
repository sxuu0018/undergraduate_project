package org.apache.jsp.fenlei;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class fenleilist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/fenlei/../left.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
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
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"body-wrapper\">\r\n");
      out.write("  <!-- Wrapper for the radial gradient background -->\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  ");
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
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <div id=\"main-content\">\r\n");
      out.write("    <!-- Main Content Section with everything -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- Page Head -->\r\n");
      out.write("    \r\n");
      out.write("    <!-- End .shortcut-buttons-set -->\r\n");
      out.write("    <div class=\"clear\"></div>\r\n");
      out.write("    <!-- End .clear -->\r\n");
      out.write("    <div class=\"content-box\">\r\n");
      out.write("      <!-- Start Content Box -->\r\n");
      out.write("      <div class=\"content-box-header\">\r\n");
      out.write("        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"clear\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End .content-box-header -->\r\n");
      out.write("      <div class=\"content-box-content\">\r\n");
      out.write("        <div class=\"tab-content default-tab\" id=\"tab1\">\r\n");
      out.write("          <!-- This is the target div. id must match the href of this div's tab -->\r\n");
      out.write("          \r\n");
      out.write("         \r\n");
      out.write("            <div>\r\n");
      out.write("           <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" method=\"post\">\r\n");
      out.write("             <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url2 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("add\"><span style=\"font-size: 20px;font-weight: bold;\">添加文章分类</span></a>\r\n");
      out.write("         文章分类名：<input type=\"text\" name=\"fname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fname}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("            <input type=\"submit\" value=\"查询\" />\r\n");
      out.write("            </form>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("              </div>\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("              <tr>\r\n");
      out.write("               \r\n");
      out.write("                 <th>文章分类名</th>\r\n");
      out.write("              \r\n");
      out.write("               \r\n");
      out.write("                <th>操作</th>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            \r\n");
      out.write("            <tbody>\r\n");
      out.write("            \r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("              \r\n");
      out.write("                \r\n");
      out.write("            <tfoot>\r\n");
      out.write("              <tr align=\"center\" >\r\n");
      out.write("                <td colspan=\"15\"  >\r\n");
      out.write("                  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageinfo}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </tfoot>\r\n");
      out.write("            \r\n");
      out.write("          </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("      \r\n");
      out.write("      </div>\r\n");
      out.write(" \r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /fenlei/fenleilist.jsp(87,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/fenlei/fenleilist.jsp(87,12) '${list}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /fenlei/fenleilist.jsp(87,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("bean");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("              <tr>\r\n");
          out.write("                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.fname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("         \r\n");
          out.write("                  \r\n");
          out.write("               \r\n");
          out.write("                <td>\r\n");
          out.write("                 \r\n");
          out.write("                  <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url2 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("update3?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" ><img src=\"resources/images/icons/pencil.png\" />查看</a> \r\n");
          out.write("                  <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url2 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("update?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" ><img src=\"resources/images/icons/pencil.png\" />修改</a> \r\n");
          out.write("                  <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url2 }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("delete?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" onclick=\" return confirm('确定要删除吗?'); \"><img src=\"resources/images/icons/cross.png\" />删除</a>\r\n");
          out.write("                  \r\n");
          out.write("                  \r\n");
          out.write("                  </td>\r\n");
          out.write("                 \r\n");
          out.write("              </tr>\r\n");
          out.write("              ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
