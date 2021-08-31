package com.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//用户
@Entity
@Table(name="t_User")
public class User {
	
	@Id
	@GeneratedValue
    private int id;//主键
	
	private int deletestatus;//表示是否删除的状态。0表示未删除，1表示删除
	
	private String username;//用户名
	
	private String password;//密码
	
	private String createtime;//注册时间
	
	private int role;//角色，1表示管理员，2表示用户
	
		
	private String nichen;//昵称
	
	private String tel;//手机号码

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getNichen() {
		return nichen;
	}

	public void setNichen(String nichen) {
		this.nichen = nichen;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

	
}
