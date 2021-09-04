package com.action;





import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.dao.FenleiDao;
import com.dao.PingjiaDao;
import com.dao.ShoucangDao;
import com.dao.UserDao;
import com.dao.XinwenDao;
import com.model.Fenlei;
import com.model.Pingjia;
import com.model.Shoucang;
import com.model.User;
import com.model.Xinwen;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Util;



public class AppAction extends ActionSupport{

	
	
	private static final long serialVersionUID = 1L;



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

	//新用户注册操作
	public void register() throws IOException {
		HttpServletRequest request = this.getRequest();


		PrintWriter writer = this.getPrintWriter();
		String tel = request.getParameter("tel");
		String username = request.getParameter("username");
		String nichen = request.getParameter("nichen");
		String password = request.getParameter("password");

	
		User bean = userDao.selectBean(" where username='"+username+"' and  deletestatus=0");
		if(bean!=null){
			
			writer.print("fail");
			return;
		}
		bean = new User();
		bean.setCreatetime(Util.getTime());

		bean.setPassword(password);
		bean.setUsername(username);
		bean.setNichen(nichen);
		bean.setTel(tel);
		bean.setRole(2);
	
		userDao.insertbean(bean);
		
		
		writer.print("success");
		
		
	}
	
	
	
	//登入请求
	public void login() throws IOException {
		
		HttpServletRequest request = this.getRequest();
		
		PrintWriter writer = this.getPrintWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User user = userDao.selectBean(" where username = '" + username+ "' and password= '" + password + "' and deletestatus=0 ");
		if (user != null) {
			writer.print(user.getUsername());
		} else {
			writer.print("fail");
		}
		
	}
	
	private FenleiDao fenleiDao;



	public FenleiDao getFenleiDao() {
		return fenleiDao;
	}

	public void setFenleiDao(FenleiDao fenleiDao) {
		this.fenleiDao = fenleiDao;
	}
	
	
	private XinwenDao xinwenDao;



	public XinwenDao getXinwenDao() {
		return xinwenDao;
	}

	public void setXinwenDao(XinwenDao xinwenDao) {
		this.xinwenDao = xinwenDao;
	}
	
	//新闻分类信息列表
	public void fenleilist() throws IOException {
		
		PrintWriter writer = this.getPrintWriter();
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		sb.append(" deletestatus=0 order by id desc ");
	
		String where = sb.toString();
		


		List<Fenlei> list = fenleiDao.selectBeanlist(0, 9999, where);
		
		

		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		for(Fenlei bean:list){
			JSONObject obj = new JSONObject();
			try {
				obj.put("id", bean.getId());
				obj.put("fname", Util.isNull(bean.getFname()));
			
			} catch (Exception e) {

			}
			array.put(obj);
		}
		
		
		writer.println(array.toString());
		
		writer.flush();
		writer.close();

	}
	
	
	
	//新闻信息列表
	public void xinwenlist() throws IOException {
		
		PrintWriter writer = this.getPrintWriter();
		HttpServletRequest request = this.getRequest();
		
		String xtitle = request.getParameter("xtitle");
		String fenlei = request.getParameter("fenlei");
		
		String tuijian = request.getParameter("tuijian");
	
		
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		
		if(xtitle !=null &&!"".equals(xtitle)){
			sb.append(" xtitle like '%"+xtitle+"%' ");
			sb.append(" and ");
	
		}
		
		if(fenlei !=null &&!"".equals(fenlei)){
			sb.append(" fenlei.fname like '%"+fenlei+"%' ");
			sb.append(" and ");
			
		
		}
		
		if(tuijian !=null &&!"".equals(tuijian)){
			sb.append(" tuijian = '"+tuijian+"' ");
			sb.append(" and ");
	
		}
		
		
		sb.append(" deletestatus=0 order by id desc ");
	
		String where = sb.toString();
		


		List<Xinwen> list = xinwenDao.selectBeanlist(0, 9999, where);
		
		

		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		for(Xinwen bean:list){
			JSONObject obj = new JSONObject();
			try {
				
				obj.put("id", bean.getId());
				obj.put("xtitle", Util.isNull(bean.getXtitle()));
				obj.put("fenlei", Util.isNull(bean.getFenlei().getFname()));
				obj.put("pic", Util.isNull(bean.getPic()));
				
			} catch (Exception e) {

			}
			array.put(obj);
		}
		writer.println(array.toString());
		writer.flush();
		writer.close();

	}
	
	
	//新闻信息详情
	public void xinwendetails() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();
		Xinwen bean = xinwenDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDianji(bean.getDianji()+1);
		
		xinwenDao.updatebean(bean);
		
		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", bean.getId());
			obj.put("xtitle", Util.isNull(bean.getXtitle()));
			obj.put("fenlei", Util.isNull(bean.getFenlei().getFname()));
			obj.put("xneirong", Util.isNull(bean.getXneirong()));
			obj.put("dianji", Util.isNull(bean.getDianji()+""));
			obj.put("pingjia", Util.isNull(bean.getPingjia()+""));
			obj.put("ctime", Util.isNull(bean.getCtime()));
			obj.put("shoucang", Util.isNull(bean.getShoucang()+""));
			
				
		} catch (Exception e) {

		}
		array.put(obj);

		writer.println(array.toString());
		
		writer.flush();
		writer.close();
	}
	
	
	private PingjiaDao pingjiaDao;



	public PingjiaDao getPingjiaDao() {
		return pingjiaDao;
	}

	public void setPingjiaDao(PingjiaDao pingjiaDao) {
		this.pingjiaDao = pingjiaDao;
	}
	
	//评价操作
	public void pingjiaadd() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();	
		
		
		String username = request.getParameter("username");
		
		String xid = request.getParameter("xid");
		String pneirong = request.getParameter("pneirong");
		
		Xinwen xw = xinwenDao.selectBean(" where id= "+xid);
		

		Pingjia bean = new Pingjia();
		bean.setCtime(Util.getTime());
		bean.setPneirong(pneirong);
		bean.setUser(userDao.selectBean(" where username='"+username+"' "));
		bean.setXinwen(xw);
		
		pingjiaDao.insertbean(bean);
		
		
		xw.setPingjia(xw.getPingjia()+1);
		
		xinwenDao.updatebean(xw);
		
		writer.print("success");
		
		
		
	}
	
	
	//评价列表
	public void pingjialist() throws IOException {
		
		PrintWriter writer = this.getPrintWriter();
		HttpServletRequest request = this.getRequest();
		
		String xid = request.getParameter("xid");

		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		
		
		
		sb.append(" deletestatus=0 and  xinwen.id="+xid+" order by id desc ");
	
		String where = sb.toString();
		


		List<Pingjia> list = pingjiaDao.selectBeanlist(0, 9999, where);
		
		

		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		for(Pingjia bean:list){
			
			
			
			JSONObject obj = new JSONObject();
			try {
				obj.put("id", bean.getId());
				obj.put("nichen", Util.isNull(bean.getUser().getNichen()));
				obj.put("pneirong", Util.isNull(bean.getPneirong()));
				obj.put("ctime", Util.isNull(bean.getCtime()));
				
				
				
				
			} catch (Exception e) {

			}
			array.put(obj);
		}
		
		
		writer.println(array.toString());
		
		writer.flush();
		writer.close();

	}
	
	
	private ShoucangDao shoucangDao;



	public ShoucangDao getShoucangDao() {
		return shoucangDao;
	}

	public void setShoucangDao(ShoucangDao shoucangDao) {
		this.shoucangDao = shoucangDao;
	}
	
	
	//收藏操作
	public void shoucangadd() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();	
		
		
		String username = request.getParameter("username");
		
		String xid = request.getParameter("xid");
	
		
		Xinwen xw = xinwenDao.selectBean(" where id= "+xid);
		

		Shoucang bean = shoucangDao.selectBean(" where deletestatus=0 and xinwen.id="+xid+" and user.username='"+username+"' ");
		if(bean!=null){
			writer.print("fail");//你已经收藏过该新闻不可重复收藏
			return ;
		}
		bean = new Shoucang();
		
		bean.setCtime(Util.getTime());
		bean.setUser(userDao.selectBean(" where username='"+username+"' "));
		bean.setXinwen(xw);
		
		shoucangDao.insertbean(bean);
		
		
		xw.setShoucang(xw.getShoucang()+1);
		
		xinwenDao.updatebean(xw);
		
		writer.print("success");
		
		
		
	}
	
	
	//我的收藏列表
	public void shoucanglist() throws IOException {
		
		PrintWriter writer = this.getPrintWriter();
		HttpServletRequest request = this.getRequest();
		
		String username = request.getParameter("username");

		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		
		
		
		sb.append(" deletestatus=0 and  user.username='"+username+"' order by id desc ");
	
		String where = sb.toString();
		


		List<Shoucang> list = shoucangDao.selectBeanlist(0, 9999, where);
		
		

		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		for(Shoucang bean:list){
			
			
			
			JSONObject obj = new JSONObject();
			try {
				obj.put("id", bean.getId());
				obj.put("xid", Util.isNull(bean.getXinwen().getId()+""));
				obj.put("xtitle", Util.isNull(bean.getXinwen().getXtitle()));
				obj.put("ctime", Util.isNull(bean.getCtime()));
				
				
				
				
			} catch (Exception e) {

			}
			array.put(obj);
		}
		
		
		writer.println(array.toString());
		
		writer.flush();
		writer.close();

	}
	
	
	
	//取消收藏操作
	public void shoucangdelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();	
		
		String id = request.getParameter("id");

		Shoucang bean = shoucangDao.selectBean(" where deletestatus=0 and id= "+id);
		
		bean.setDeletestatus(1);
		
		shoucangDao.updatebean(bean);
		
		Xinwen xw = xinwenDao.selectBean(" where id= "+bean.getXinwen().getId());
		
		xw.setShoucang(xw.getShoucang()-1);
		
		xinwenDao.updatebean(xw);
		
		writer.print("success");
		

		
	}
	
	
	
	//我的评价评价列表
	public void pingjialist2() throws IOException {
		
		PrintWriter writer = this.getPrintWriter();
		HttpServletRequest request = this.getRequest();
		
		String username = request.getParameter("username");

		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		
		
		
		sb.append(" deletestatus=0 and  user.username='"+username+"' order by id desc ");
	
		String where = sb.toString();
		


		List<Pingjia> list = pingjiaDao.selectBeanlist(0, 9999, where);
		
		

		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		for(Pingjia bean:list){
			
			
			
			JSONObject obj = new JSONObject();
			try {
				obj.put("id", bean.getId());
				obj.put("nichen", Util.isNull(bean.getUser().getNichen()));
				obj.put("pneirong", Util.isNull(bean.getPneirong()));
				obj.put("ctime", Util.isNull(bean.getCtime()));
				obj.put("xid", Util.isNull(bean.getXinwen().getId()+""));
				obj.put("xtitle", Util.isNull(bean.getXinwen().getXtitle()));
				
				
				
				
			} catch (Exception e) {

			}
			array.put(obj);
		}
		
		
		writer.println(array.toString());
		
		writer.flush();
		writer.close();

	}
	
	
	
	
	//删除评价操作
	public void pingjiadelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();	
		
		String id = request.getParameter("id");

		Pingjia bean = pingjiaDao.selectBean(" where deletestatus=0 and id= "+id);
		
		bean.setDeletestatus(1);
		
		pingjiaDao.updatebean(bean);
		
		Xinwen xw = xinwenDao.selectBean(" where id= "+bean.getXinwen().getId());
		
		xw.setPingjia(xw.getPingjia()-1);
		
		xinwenDao.updatebean(xw);
		
		writer.print("success");
	
	}

	
	//用户信息详情
	public void userdetails() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String username = request.getParameter("username");
		
		User bean = userDao.selectBean(" where username= '"+username+"'");
		
		//组装成json对象传递给app端
		JSONArray array = new JSONArray();
		
		JSONObject obj = new JSONObject();
		try {
				obj.put("id", bean.getId());
				obj.put("username", Util.isNull(bean.getUsername()));
				obj.put("password", Util.isNull(bean.getPassword()));
				obj.put("createtime", Util.isNull(bean.getCreatetime()));
				obj.put("nichen", Util.isNull(bean.getNichen()));
				obj.put("tel", Util.isNull(bean.getTel()));
				
				
		} catch (Exception e) {

		}
		array.put(obj);

		writer.println(array.toString());
		
		writer.flush();
		writer.close();
	}
	
	
	//修改密码
	public void passwordedit() throws IOException {
		HttpServletRequest request = this.getRequest();

		PrintWriter writer = this.getPrintWriter();
		String username = request.getParameter("username");

		String password1 = request.getParameter("password1");//原密码
		
		String password2 = request.getParameter("password2");//新密码

	
		User bean = userDao.selectBean(" where username='"+username+"' and password='"+password1+"' and deletestatus=0");
		//原密码错误
		if(bean==null){
			
			writer.print("fail");
			return;
		}
		
		bean.setPassword(password2);

		userDao.updatebean(bean);
		
		//修改成功
		writer.print("success");
		
		
	}
	
	
	//编辑用户信息
	public void userdedit() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String username = request.getParameter("username");

		String nichen = request.getParameter("nichen");
		
		String tel = request.getParameter("tel");

	
		User bean = userDao.selectBean(" where username='"+username+"'  and deletestatus=0");
		
		bean.setNichen(nichen);
		bean.setTel(tel);
		
		
		userDao.updatebean(bean);
		
		//修改成功
		writer.print("success");
		
		
	}
	
	
	
	
}
