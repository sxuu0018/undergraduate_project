package com.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FenleiDao;
import com.dao.PingjiaDao;
import com.dao.UserDao;
import com.dao.XinwenDao;
import com.model.Fenlei;
import com.model.Pingjia;
import com.model.User;
import com.model.Xinwen;
import com.util.Pager;
import com.util.Util;

public class ManageAction {

	private String url = "./";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 获取请求对象
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}

	// 获取响应对象
	public HttpServletResponse getResponse() {
		HttpServletResponse response = ServletActionContext.getResponse();
		return response;
	}

	// 获取session对象
	public HttpSession getSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;
	}

	// 获取输出对象
	public PrintWriter getPrintWriter() {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return writer;
	}

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 用户登录
	public void login() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.selectBean(" where username='" + username
				+ "' and password='" + password + "' and deletestatus=0");

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			writer
					.print("<script language='javascript'>alert('登录成功');window.location.href='index.jsp';</script>");
		} else {
			writer
					.print("<script language='javascript'>alert('登录失败');window.location.href='login.jsp';</script>");
		}

	}

	// 退出
	public void loginout() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();

		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("dorms");
		writer
				.print("<script language='javascript'>alert('退出成功');window.location.href='login.jsp';</script>");
	}

	// 修改密码
	public String passwordupdate() {
		this.setUrl("password.jsp");
		return "success";
	}

	public void passwordupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();

		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User bean = userDao.selectBean(" where username='" + user.getUsername()
				+ "' and password = '" + password1 + "' and deletestatus=0");
		if (bean != null) {
			bean.setPassword(password2);
			userDao.updatebean(bean);
			session.removeAttribute("user");
			writer
					.print("<script language='javascript'>alert('更新成功,请重新登录');window.location.href='login.jsp'</script>");
		} else {
			writer
					.print("<script language='javascript'>alert('原密码输入有误!请重新输入');window.location.href='method!passwordupdate';</script>");
		}

	}

	private FenleiDao fenleiDao;

	public FenleiDao getFenleiDao() {
		return fenleiDao;
	}

	public void setFenleiDao(FenleiDao fenleiDao) {
		this.fenleiDao = fenleiDao;
	}
	
	
	
	//新闻分类列表
	public String fenleilist() {
		HttpServletRequest request = this.getRequest();
		
		String fname = request.getParameter("fname");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (fname != null && !"".equals(fname)) {
			sb.append(" fname like '%" + fname + "%' ");
			sb.append(" and ");

			request.setAttribute("fname", fname);
		}

		sb.append(" deletestatus=0  order by id desc ");
		String where = sb.toString();

		int pagesize = 10;
		int currentpage = 1;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = fenleiDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		List<Fenlei> list = fenleiDao.selectBeanlist((currentpage - 1)* pagesize, pagesize, where);
		
		request.setAttribute("list", list);
		
		String pagerinfo = Pager.getPagerNormal((int) total, pagesize,currentpage, "method!fenleilist", "总共有" + total + "条记录");
		
		request.setAttribute("pageinfo", pagerinfo);
		
		this.setUrl("fenlei/fenleilist.jsp");
		request.setAttribute("url", "method!fenleilist");
		request.setAttribute("url2", "method!fenlei");
		request.setAttribute("title", "新闻分类管理");
		
		return "success";

	}

	

	//跳转到添加新闻分类页面
	public String fenleiadd() {
		HttpServletRequest request = this.getRequest();
		request.setAttribute("url", "method!fenleiadd2");
		request.setAttribute("title", "添加新闻分类");
		this.setUrl("fenlei/fenleiadd.jsp");
		return "success";
	}
	

	//添加新闻分类操作
	public void fenleiadd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		
		String fname = request.getParameter("fname");
		
		
		
		Fenlei bean = new Fenlei();
		bean.setFname(fname);
		
		fenleiDao.insertbean(bean);
		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!fenleilist';</script>");
		
		
		
	}

	//跳转到修改新闻分类页面
	public String fenleiupdate() {
		HttpServletRequest request = this.getRequest();
		
		
		Fenlei bean = fenleiDao.selectBean(" where id = " + request.getParameter("id"));
		request.setAttribute("bean", bean);
		
		request.setAttribute("url", "method!fenleiupdate2?id="+bean.getId());
		request.setAttribute("title", "修改新闻分类");
		
		this.setUrl("fenlei/fenleiupdate.jsp");
		return "success";

	}

	//修改新闻分类操作
	public void fenleiupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String fname = request.getParameter("fname");
		
		
		Fenlei bean = fenleiDao.selectBean(" where id = " + request.getParameter("id"));
		
		bean.setFname(fname);

		
		fenleiDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!fenleilist';</script>");
	}
	

	// 删除新闻分类的操作
	public void fenleidelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		

		Fenlei bean = fenleiDao.selectBean(" where id = " + request.getParameter("id"));
		bean.setDeletestatus(1);
		fenleiDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!fenleilist';</script>");

	}

	
	//跳转到查看新闻分类页面
	public String fenleiupdate3() {
		HttpServletRequest request = this.getRequest();

		request.setAttribute("title", "查看新闻分类");
		
		Fenlei bean = fenleiDao.selectBean(" where id = " + request.getParameter("id"));
		request.setAttribute("bean", bean);
		
		this.setUrl("fenlei/fenleiupdate3.jsp");
		return "success";

	}


	
	private XinwenDao xinwenDao;

	public XinwenDao getXinwenDao() {
		return xinwenDao;
	}

	public void setXinwenDao(XinwenDao xinwenDao) {
		this.xinwenDao = xinwenDao;
	}
	
	
	
	//新闻列表
	public String xinwenlist() {
		HttpServletRequest request = this.getRequest();
		
		String xtitle = request.getParameter("xtitle");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (xtitle != null && !"".equals(xtitle)) {
			sb.append(" xtitle like '%" + xtitle + "%' ");
			sb.append(" and ");

			request.setAttribute("xtitle", xtitle);
		}

		sb.append(" deletestatus=0  order by id desc ");
		String where = sb.toString();

		int pagesize = 10;
		int currentpage = 1;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = xinwenDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		List<Xinwen> list = xinwenDao.selectBeanlist((currentpage - 1)* pagesize, pagesize, where);
		
		request.setAttribute("list", list);
		
		String pagerinfo = Pager.getPagerNormal((int) total, pagesize,currentpage, "method!xinwenlist", "总共有" + total + "条记录");
		
		request.setAttribute("pageinfo", pagerinfo);
		
		this.setUrl("xinwen/xinwenlist.jsp");
		request.setAttribute("url", "method!xinwenlist");
		request.setAttribute("url2", "method!xinwen");
		request.setAttribute("title", "新闻管理");
		
		return "success";

	}

	

	//跳转到添加新闻页面
	public String xinwenadd() {
		HttpServletRequest request = this.getRequest();
		request.setAttribute("url", "method!xinwenadd2");
		request.setAttribute("fenleilist", fenleiDao.selectBeanlist(0, 9999, " where  deletestatus=0 "));
		request.setAttribute("title", "添加新闻");
		this.setUrl("xinwen/xinwenadd.jsp");
		return "success";
	}
	
	
	private File uploadfile;

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	

	//添加新闻操作
	public void xinwenadd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		
		String fid = request.getParameter("fid");
		String xneirong = request.getParameter("xneirong");
		String xtitle = request.getParameter("xtitle");
		
		
		
		Xinwen bean = new Xinwen();
		
		bean.setCtime(Util.getTime3());
		bean.setFenlei(fenleiDao.selectBean(" where id= "+fid));
		bean.setXneirong(xneirong);
		bean.setXtitle(xtitle);
		bean.setTuijian("未推荐");
		
		if(uploadfile!=null){
			String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

			String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

			String imgpath = time + ".jpg";
			File file1 = new File(savaPath + imgpath);
			Util.copyFile(uploadfile, file1);
			bean.setPic(imgpath);
		}
		
		xinwenDao.insertbean(bean);
		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!xinwenlist';</script>");
		
		
		
	}

	//跳转到修改新闻页面
	public String xinwenupdate() {
		HttpServletRequest request = this.getRequest();
		
		request.setAttribute("fenleilist", fenleiDao.selectBeanlist(0, 9999, " where  deletestatus=0 "));
		
		Xinwen bean = xinwenDao.selectBean(" where id = " + request.getParameter("id"));
		request.setAttribute("bean", bean);
		
		request.setAttribute("url", "method!xinwenupdate2?id="+bean.getId());
		request.setAttribute("title", "修改新闻");
		
		this.setUrl("xinwen/xinwenupdate.jsp");
		return "success";

	}

	//修改新闻操作
	public void xinwenupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String fid = request.getParameter("fid");
		String xneirong = request.getParameter("xneirong");
		String xtitle = request.getParameter("xtitle");
		
		
		Xinwen bean = xinwenDao.selectBean(" where id = " + request.getParameter("id"));
		

		bean.setFenlei(fenleiDao.selectBean(" where id= "+fid));
		bean.setXneirong(xneirong);
		bean.setXtitle(xtitle);


		if(uploadfile!=null){
			String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

			String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

			String imgpath = time + ".jpg";
			File file1 = new File(savaPath + imgpath);
			Util.copyFile(uploadfile, file1);
			bean.setPic(imgpath);
		}
		
		xinwenDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!xinwenlist';</script>");
	}
	

	// 删除新闻的操作
	public void xinwendelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		

		Xinwen bean = xinwenDao.selectBean(" where id = " + request.getParameter("id"));
		bean.setDeletestatus(1);
		xinwenDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!xinwenlist';</script>");

	}

	
	//跳转到查看新闻页面
	public String xinwenupdate3() {
		HttpServletRequest request = this.getRequest();

		request.setAttribute("title", "查看新闻");
		
		Xinwen bean = xinwenDao.selectBean(" where id = " + request.getParameter("id"));
		request.setAttribute("bean", bean);
		
		this.setUrl("xinwen/xinwenupdate3.jsp");
		return "success";

	}
	
	//新闻推荐的操作
	public void xinwendelete2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		

		Xinwen bean = xinwenDao.selectBean(" where id = " + request.getParameter("id"));
		
		bean.setTuijian("推荐");
		
		xinwenDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!xinwenlist';</script>");

	}
	
	
	//取消推荐的操作
	public void xinwendelete3() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		

		Xinwen bean = xinwenDao.selectBean(" where id = " + request.getParameter("id"));
		bean.setTuijian("未推荐");
		xinwenDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!xinwenlist';</script>");

	}
	
	
	private PingjiaDao pingjiaDao;

	public PingjiaDao getPingjiaDao() {
		return pingjiaDao;
	}

	public void setPingjiaDao(PingjiaDao pingjiaDao) {
		this.pingjiaDao = pingjiaDao;
	}
	
	
	
	//新闻评价列表
	public String pingjialist() {
		HttpServletRequest request = this.getRequest();
		
		String xtitle = request.getParameter("xtitle");
		
		String nichen = request.getParameter("nichen");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (xtitle != null && !"".equals(xtitle)) {
			sb.append(" xinwen.xtitle like '%" + xtitle + "%' ");
			sb.append(" and ");

			request.setAttribute("xtitle", xtitle);
		}
		
		if (nichen != null && !"".equals(nichen)) {
			sb.append(" user.nichen like '%" + nichen + "%' ");
			sb.append(" and ");

			request.setAttribute("nichen", nichen);
		}

		sb.append(" deletestatus=0  order by id desc ");
		String where = sb.toString();

		int pagesize = 10;
		int currentpage = 1;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = pingjiaDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		List<Pingjia> list = pingjiaDao.selectBeanlist((currentpage - 1)* pagesize, pagesize, where);
		
		request.setAttribute("list", list);
		
		String pagerinfo = Pager.getPagerNormal((int) total, pagesize,currentpage, "method!pingjialist", "总共有" + total + "条记录");
		
		request.setAttribute("pageinfo", pagerinfo);
		
		this.setUrl("pingjia/pingjialist.jsp");
		request.setAttribute("url", "method!pingjialist");
		request.setAttribute("url2", "method!pingjia");
		request.setAttribute("title", "新闻评价管理");
		
		return "success";

	}


	

	

	// 删除新闻评价的操作
	public void pingjiadelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		

		Pingjia bean = pingjiaDao.selectBean(" where id = " + request.getParameter("id"));
		bean.setDeletestatus(1);
		pingjiaDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!pingjialist';</script>");

	}
	
	
	//用户列表
	public String userlist() {
		HttpServletRequest request = this.getRequest();
		
		
		
		String username = request.getParameter("username");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (username != null && !"".equals(username)) {
			sb.append(" username like '%" + username + "%' ");
			sb.append(" and ");

			request.setAttribute("username", username);
		}
		
		

		sb.append(" deletestatus=0 and role=2 order by id desc ");
		String where = sb.toString();

		int pagesize = 10;
		int currentpage = 1;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		long total = userDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		
		List<User> list = userDao.selectBeanlist((currentpage - 1)* pagesize, pagesize, where);
		
		request.setAttribute("list", list);
		
		String pagerinfo = Pager.getPagerNormal((int) total, pagesize,currentpage, "method!userlist", "总共有" + total + "条记录");
		
		request.setAttribute("pageinfo", pagerinfo);
		
		this.setUrl("user/userlist.jsp");
		request.setAttribute("url", "method!userlist");
		request.setAttribute("url2", "method!user");
		request.setAttribute("title", "用户管理");
		
		return "success";

	}


	

	

	// 删除用户的操作
	public void userdelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		

		User bean = userDao.selectBean(" where id = " + request.getParameter("id"));
		bean.setDeletestatus(1);
		userDao.updatebean(bean);

		writer.print("<script language='javascript'>alert('操作成功');window.location.href='method!userlist';</script>");

	}
	
	
}
