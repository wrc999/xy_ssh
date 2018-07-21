package dao.view;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import pojo.view;

public class viewDao extends HibernateDaoSupport implements viewDaoInterface {
	
	
	public viewDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(view v) {
		getHibernateTemplate().save(v);
	}

	@Override
	public void delete(view v) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(v);
	}
	
	@Override
	public List<view> get(DetachedCriteria dc) {
		List<view> list = (List<view>) getHibernateTemplate().findByCriteria(dc);
		if(list != null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
