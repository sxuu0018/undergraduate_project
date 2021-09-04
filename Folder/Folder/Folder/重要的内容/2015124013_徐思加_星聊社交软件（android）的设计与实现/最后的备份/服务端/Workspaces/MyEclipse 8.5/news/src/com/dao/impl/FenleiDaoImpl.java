package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.FenleiDao;
import com.model.Fenlei;




public class FenleiDaoImpl extends HibernateDaoSupport implements FenleiDao{

	public void deletebean(Fenlei bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertbean(Fenlei bean) {
		this.getHibernateTemplate().save(bean);
	}

	@SuppressWarnings("unchecked")
	public Fenlei selectBean(String where) {
		List<Fenlei> list = this.getHibernateTemplate().find("from Fenlei" + where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Fenlei"+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Fenlei> selectBeanlist(final int start, final int limit, final String where) {
		return (List<Fenlei>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List<Fenlei> list = session.createQuery("from Fenlei"+ where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
			
		});
	
	}

	public void updatebean(Fenlei bean) {
		this.getHibernateTemplate().update(bean);
		
	}

	
		

}
