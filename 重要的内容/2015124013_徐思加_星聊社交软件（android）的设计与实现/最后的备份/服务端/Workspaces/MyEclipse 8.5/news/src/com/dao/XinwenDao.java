package com.dao;



import java.util.List;

import com.model.Xinwen;






public interface XinwenDao {
	
	//增加
	public void insertbean(Xinwen bean);
		
	//删除
	public void deletebean(Xinwen bean);
		
	
	//更新
	public void updatebean(Xinwen bean);
	
	
	//根据条件进行查询
	public List<Xinwen> selectBeanlist(final int start,final int limit,final String where);
	
    //根据条件查询信息条数
	public long selectBeanCount(final String where);
	
	//根据条件查询
	public Xinwen selectBean(final String where);
}
