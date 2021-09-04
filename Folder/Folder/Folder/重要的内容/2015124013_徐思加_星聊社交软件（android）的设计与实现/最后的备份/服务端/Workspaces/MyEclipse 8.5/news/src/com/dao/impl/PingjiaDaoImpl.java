package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.PingjiaDao;
import com.model.Pingjia;




public class PingjiaDaoImpl extends HibernateDaoSupport implements PingjiaDao{

	public void deletebean(Pingjia bean) {
		this.getHibernateTemplate().delete(bean);
		
	}

	public void insertbean(Pingjia bean) {
		this.getHibernateTemplate().save(bean);
	}

	@SuppressWarnings("unchecked")
	public Pingjia selectBean(String where) {
		List<Pingjia> list = this.getHibernateTemplate().find("from Pingjia" + where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public long selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Pingjia"+where).get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Pingjia> selectBeanlist(final int start, final int limit, final String where) {
		return (List<Pingjia>)this.getHibernateTemplate().executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				List<Pingjia> list = session.createQuery("from Pingjia"+ where).setFirstResult(start).setMaxResults(limit).list();
				return list;
			}
			
		});
	
	}

	public void updatebean(Pingjia bean) {
		this.getHibernateTemplate().update(bean);
		
	}

	
		

}
