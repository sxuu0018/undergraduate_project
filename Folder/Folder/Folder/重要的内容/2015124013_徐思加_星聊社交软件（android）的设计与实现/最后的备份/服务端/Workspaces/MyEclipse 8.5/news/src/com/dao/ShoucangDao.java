package com.dao;



import java.util.List;

import com.model.Shoucang;






public interface ShoucangDao {
	
	//增加
	public void insertbean(Shoucang bean);
		
	//删除
	public void deletebean(Shoucang bean);
		
	
	//更新
	public void updatebean(Shoucang bean);
	
	
	//根据条件进行查询
	public List<Shoucang> selectBeanlist(final int start,final int limit,final String where);
	
    //根据条件查询信息条数
	public long selectBeanCount(final String where);
	
	//根据条件查询
	public Shoucang selectBean(final String where);
}
