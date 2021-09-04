package com.dao;



import java.util.List;

import com.model.Pingjia;






public interface PingjiaDao {
	
	//增加
	public void insertbean(Pingjia bean);
		
	//删除
	public void deletebean(Pingjia bean);
		
	
	//更新
	public void updatebean(Pingjia bean);
	
	
	//根据条件进行查询
	public List<Pingjia> selectBeanlist(final int start,final int limit,final String where);
	
    //根据条件查询信息条数
	public long selectBeanCount(final String where);
	
	//根据条件查询
	public Pingjia selectBean(final String where);
}
