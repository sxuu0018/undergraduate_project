package com.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//新闻评价
@Entity
@Table(name="t_Pingjia")
public class Pingjia {
	
	@Id
	@GeneratedValue
    private int id;//主键
	
	private int deletestatus;//表示是否删除的状态。0表示未删除，1表示删除
	
	@ManyToOne
	@JoinColumn(name="xinwenid")
	private Xinwen xinwen;//评价的新闻，外键
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;//评价的用户，外键
	
	
	@Column(name="pneirong", columnDefinition="TEXT")
	private String pneirong;//评价内容
	
	private String ctime;//评价时间

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

	public Xinwen getXinwen() {
		return xinwen;
	}

	public void setXinwen(Xinwen xinwen) {
		this.xinwen = xinwen;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPneirong() {
		return pneirong;
	}

	public void setPneirong(String pneirong) {
		this.pneirong = pneirong;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
	
	
	
	
	

	
}
