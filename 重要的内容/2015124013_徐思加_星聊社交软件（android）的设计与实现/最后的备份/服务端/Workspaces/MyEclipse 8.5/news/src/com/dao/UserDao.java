package com.dao;



import java.util.List;

import com.model.User;






public interface UserDao {
	
	//增加
	public void insertbean(User bean);
		
	//删除
	public void deletebean(User bean);
		
	
	//更新
	public void updatebean(User bean);
	
	
	//根据条件进行查询
	public List<User> selectBeanlist(final int start,final int limit,final String where);
	
    //根据条件查询信息条数
	public long selectBeanCount(final String where);
	
	//根据条件查询
	public User selectBean(final String where);
}
