<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>欢迎来到星聊</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="resources/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>

<script language="javascript" type="text/javascript" src="js/showdate.js"></script>

<script type="text/javascript" language="javascript">
function checkform(){
	if(document.getElementById("xtitleid").value==""){
		
		alert('文章标题不能为空');
		return false;
	}
	
	
	return true;

}


</script>

</head>
<body>

<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  
  
  <%@ include file="../left.jsp" %>
  
  
  <div id="main-content">
    
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>${title }</h3>
        <ul class="content-box-tabs">
          
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        
        
        
      
        <div class="tab-content default-tab" id="tab1">
          <form action="${url }" method="post" onsubmit="return checkform()" enctype="multipart/form-data">
            <fieldset>
            <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
            <p>
              <label>文章分类</label>
             <select name="fid">
             <c:forEach items="${fenleilist}" var="fenlei">
              <option value="${fenlei.id }">${fenlei.fname }</option>
             </c:forEach>
            
             </select>
              
            </p>
            
            <p>
              <label>文章标题</label>
              <input class="text-input small-input" type="text" id="xtitleid" name="xtitle" />
              
            </p>
            
            <p>
              <label>文章图片</label>
              <input class="text-input small-input" name="uploadfile"  type="file"  id='uploadfileid' />
              
            </p>
            
            <p>
              <label>文章内容</label>
              <textarea rows="7" cols="50" name="xneirong"></textarea>
              
            </p>
            
          
            
         
            
           
              
            
            <p>
              <input class="button" type="submit" value="提交" />
              
              &nbsp;&nbsp;&nbsp;
              
              <input type="button" value="返回"  onclick="javascript:history.go(-1)" />
            </p>
            </fieldset>
            <div class="clear"></div>
            <!-- End .clear -->
          </form>
        </div>
        <!-- End #tab2 -->
      </div>
      <!-- End .content-box-content -->
    </div>
    
  
  </div>
  <!-- End #main-content -->
</div>


</body>

</html>
