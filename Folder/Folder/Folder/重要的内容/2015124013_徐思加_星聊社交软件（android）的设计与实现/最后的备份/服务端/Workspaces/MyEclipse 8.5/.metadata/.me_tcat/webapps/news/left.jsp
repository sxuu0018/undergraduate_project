<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="sidebar">
    <div id="sidebar-wrapper">
     <br/>
      
      <a href="#">
      <span style="font-size: 30px;font-weight: bold;">管理菜单</span>
      </a>
     
      
      <ul id="main-nav">
        
        
    
        
         <li> <a href="#" class="nav-top-item">文章分类</a>
          <ul>
            <li><a href="method!fenleilist">文章分类管理</a></li>
            <li><a href="method!fenleiadd">添加文章分类</a></li>
        
          </ul>
        </li>
        
        
         <li> <a href="#" class="nav-top-item">星座文章</a>
          <ul>
            <li><a href="method!xinwenlist">文章管理</a></li>
            <li><a href="method!xinwenadd">添加文章</a></li>
        
          </ul>
        </li>
        
        <li> <a href="#" class="nav-top-item">评价</a>
          <ul>
            <li><a href="method!pingjialist">评价管理</a></li>
           
          </ul>
        </li>
        
        <li> <a href="#" class="nav-top-item">用户</a>
          <ul>
            <li><a href="method!userlist">用户管理</a></li>
           
          </ul>
        </li>
       
        
       
        
        <li> <a href="#" class="nav-top-item">修改密码</a>
          <ul>
            <li><a href="method!passwordupdate">修改密码</a></li>
           
          </ul>
        </li>
        
         <li> <a href="#" class="nav-top-item">安全退出</a>
          <ul>
            <li><a href="method!loginout">安全退出</a></li>
           
          </ul>
        </li>
      </ul>
    </div>
  </div>

  
 
  
  
  
  <!-- End #sidebar -->