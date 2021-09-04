package com.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//新闻
@Entity
@Table(name="t_Xinwen")
public class Xinwen {
	
	@Id
	@GeneratedValue
    private int id;//主键
	
	private int deletestatus;//表示是否删除的状态。0表示未删除，1表示删除
	
	@ManyToOne
	@JoinColumn(name="fenleiid")
	private Fenlei fenlei;//新闻分类
	
	private String xtitle;//新闻标题
	
	@Column(name="xneirong", columnDefinition="TEXT")
	private String xneirong;//新闻内容
	
	private String pic;//显示图片
	
	private String ctime;//添加时间
	
	private int dianji;//点击数
	
	private String tuijian;//新闻推荐
	
	private int pingjia;//评价数
	
	private int shoucang;//收藏数
	
	

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

	public Fenlei getFenlei() {
		return fenlei;
	}

	public void setFenlei(Fenlei fenlei) {
		this.fenlei = fenlei;
	}

	public String getXtitle() {
		return xtitle;
	}

	public void setXtitle(String xtitle) {
		this.xtitle = xtitle;
	}

	public String getXneirong() {
		return xneirong;
	}

	public void setXneirong(String xneirong) {
		this.xneirong = xneirong;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public int getDianji() {
		return dianji;
	}

	public void setDianji(int dianji) {
		this.dianji = dianji;
	}

	public String getTuijian() {
		return tuijian;
	}

	public void setTuijian(String tuijian) {
		this.tuijian = tuijian;
	}

	public int getPingjia() {
		return pingjia;
	}

	public void setPingjia(int pingjia) {
		this.pingjia = pingjia;
	}

	public int getShoucang() {
		return shoucang;
	}

	public void setShoucang(int shoucang) {
		this.shoucang = shoucang;
	}

	
	
	
	
	
	

	
}
