package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.ShoucangDao;
import com.model.Shoucang;




public class ShoucangDaoImpl extends HibernateDaoSupport implements ShoucangDao{

	public void deletebean(Shoucang bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertbean(Shoucang bean) {
		this.getHibernateTemplate().save(bean);
	}

	@SuppressWarnings("unchecked")
	public Shoucang selectBean(String where) {
		List<Shoucang> list = this.getHibernateTemplate().find("from Shoucang" + where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Shoucang"+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Shoucang> selectBeanlist(final int start, final int limit, final String where) {
		return (List<Shoucang>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List<Shoucang> list = session.createQuery("from Shoucang"+ where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
			
		});
	
	}

	public void updatebean(Shoucang bean) {
		this.getHibernateTemplate().update(bean);
		
	}

	
		

}
