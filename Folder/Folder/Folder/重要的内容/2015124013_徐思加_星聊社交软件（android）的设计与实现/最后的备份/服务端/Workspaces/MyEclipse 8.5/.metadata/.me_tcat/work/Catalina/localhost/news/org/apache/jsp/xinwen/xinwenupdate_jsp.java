package org.apache.jsp.xinwen;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class xinwenupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/xinwen/../left.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
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
      out.write("<script language=\"javascript\" type=\"text/javascript\" src=\"js/showdate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\r\n");
      out.write("function checkform(){\r\n");
      out.write("\tif(document.getElementById(\"xtitleid\").value==\"\"){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\talert('新闻标题不能为空');\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
      out.write("         <li> <a href=\"#\" class=\"nav-top-item\">新闻分类</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!fenleilist\">新闻分类管理</a></li>\r\n");
      out.write("            <li><a href=\"method!fenleiadd\">添加新闻分类</a></li>\r\n");
      out.write("        \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("         <li> <a href=\"#\" class=\"nav-top-item\">新闻</a>\r\n");
      out.write("          <ul>\r\n");
      out.write("            <li><a href=\"method!xinwenlist\">新闻管理</a></li>\r\n");
      out.write("            <li><a href=\"method!xinwenadd\">添加新闻</a></li>\r\n");
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
      out.write("    \r\n");
      out.write("    <div class=\"clear\"></div>\r\n");
      out.write("    <!-- End .clear -->\r\n");
      out.write("    <div class=\"content-box\">\r\n");
      out.write("      <!-- Start Content Box -->\r\n");
      out.write("      <div class=\"content-box-header\">\r\n");
      out.write("        <h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("        <ul class=\"content-box-tabs\">\r\n");
      out.write("          \r\n");
      out.write("        </ul>\r\n");
      out.write("        <div class=\"clear\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End .content-box-header -->\r\n");
      out.write("      <div class=\"content-box-content\">\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("      \r\n");
      out.write("        <div class=\"tab-content default-tab\" id=\"tab1\">\r\n");
      out.write("          <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${url }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" method=\"post\" onsubmit=\"return checkform()\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("            <!-- Set class to \"column-left\" or \"column-right\" on fieldsets to divide the form into columns -->\r\n");
      out.write("            <p>\r\n");
      out.write("              <label>新闻分类</label>\r\n");
      out.write("             <select name=\"fid\">\r\n");
      out.write("             ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            \r\n");
      out.write("             </select>\r\n");
      out.write("              \r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("              <label>新闻标题</label>\r\n");
      out.write("              <input class=\"text-input small-input\" type=\"text\" id=\"xtitleid\" name=\"xtitle\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.xtitle }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("              \r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("              <label>新闻图片</label>\r\n");
      out.write("              <img src=\"");
      out.print(basePath );
      out.write("uploadfile/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.pic }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" width=\"100\" height=\"100\" />\r\n");
      out.write("              \r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("              <label>重新上传图片</label>\r\n");
      out.write("              <input class=\"text-input small-input\" name=\"uploadfile\"  type=\"file\"  id='uploadfileid' />\r\n");
      out.write("              \r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("              <label>新闻内容</label>\r\n");
      out.write("              <textarea rows=\"7\" cols=\"50\" name=\"xneirong\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.xneirong }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("              \r\n");
      out.write("            </p>\r\n");
      out.write("            \r\n");
      out.write("          \r\n");
      out.write("            \r\n");
      out.write("         \r\n");
      out.write("            \r\n");
      out.write("           \r\n");
      out.write("              \r\n");
      out.write("            \r\n");
      out.write("            <p>\r\n");
      out.write("              <input class=\"button\" type=\"submit\" value=\"提交\" />\r\n");
      out.write("              \r\n");
      out.write("              &nbsp;&nbsp;&nbsp;\r\n");
      out.write("              \r\n");
      out.write("              <input type=\"button\" value=\"返回\"  onclick=\"javascript:history.go(-1)\" />\r\n");
      out.write("            </p>\r\n");
      out.write("            </fieldset>\r\n");
      out.write("            <div class=\"clear\"></div>\r\n");
      out.write("            <!-- End .clear -->\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End #tab2 -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- End .content-box-content -->\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- End #main-content -->\r\n");
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
    // /xinwen/xinwenupdate.jsp(81,13) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/xinwen/xinwenupdate.jsp(81,13) '${fenleilist}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${fenleilist}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /xinwen/xinwenupdate.jsp(81,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("fenlei");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("              <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fenlei.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write(' ');
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write(' ');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fenlei.fname }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("             ");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /xinwen/xinwenupdate.jsp(82,44) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bean.fenlei.id==fenlei.id }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("selected");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
