package com.dao;



import java.util.List;

import com.model.Fenlei;






public interface FenleiDao {
	
	//增加
	public void insertbean(Fenlei bean);
		
	//删除
	public void deletebean(Fenlei bean);
		
	
	//更新
	public void updatebean(Fenlei bean);
	
	
	//根据条件进行查询
	public List<Fenlei> selectBeanlist(final int start,final int limit,final String where);
	
    //根据条件查询信息条数
	public long selectBeanCount(final String where);
	
	//根据条件查询
	public Fenlei selectBean(final String where);
}
