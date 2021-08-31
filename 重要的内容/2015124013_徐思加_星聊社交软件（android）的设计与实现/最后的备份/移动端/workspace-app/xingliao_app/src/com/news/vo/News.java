package com.news.vo;

//新闻
public class News {
	
	
    private int id;//主键
	
	private String fenlei;//新闻分类
	
	private String xtitle;//新闻标题
	
	private String xneirong;//新闻内容
	
	private String pic;//显示图片
	
	private String ctime;//添加时间
	
	private int dianji;//点击数
	
	private String tuijian;//新闻推荐
	
	private int pingjia;//评价数

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
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
	
	
	
	
	
	

	
}
