package dao.activity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import pojo.acollect;
import pojo.activity;
import pojo.activityjoins;

public class activityDao extends HibernateDaoSupport implements activityDaoInterface {

	public activityDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collectAdd(acollect a) {
		getHibernateTemplate().save(a);
	}


	@Override
	public List<activity> collectGet(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		List<activity> list = (List<activity>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}
	
	@Override
	public void joinsAdd(activityjoins a) {
		getHibernateTemplate().save(a);
		activity ac = getHibernateTemplate().get(activity.class, a.getActivity_id());
		ac.setJoins(ac.getJoins()+1);
		getHibernateTemplate().update(ac);
	}
	
	@Override
	public void add(activity activity) {
		getHibernateTemplate().save(activity);
	}

	@Override
	public void delete(activity activity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(activity);
	}
	
	@Override
	public List<activity> get(int use_id) {
		return getHibernateTemplate().execute(new HibernateCallback<List<activity>>() {

			@Override
			public List<activity> doInHibernate(Session session) throws HibernateException {
				//使用sql查询，自动返回封装对象
				/*String hql = "select * from activity";
				SQLQuery query = session.createSQLQuery(hql);
				query.addEntity(activity.class);
				List<activity> list = query.list();*/
				//使用sql查询，手动装配对象
				String sql = "select a.*,u.nickName,u.school from activity a,userinfo u where a.use_id=u.use_id ";
				if(use_id>0) {
					sql += "and a.use_id="+use_id;					
				}
				SQLQuery query = session.createSQLQuery(sql);
				List<Object> list = query.list();
				ArrayList<activity> activityList = new ArrayList<activity>();
				for(Object obj:list) {
					 Object[] objs = (Object[])obj;
					 activity a = new activity();
			         a.setActivity_id((int)objs[0]);
			         a.setUse_id((int)objs[1]);
			         a.setName((String) objs[2]);
			         a.setStarttime((String) objs[3]);
			         a.setEndtime((String) objs[4]);
			         a.setPlace((String) objs[5]);
			         a.setJoins((int)objs[6]);
			         a.setPhoto((String) objs[7]);
			         a.setIntro((String) objs[8]);
			         a.setNickName((String) objs[9]);
			         a.setSchool((String) objs[10]);
			         activityList.add(a);
				}
				/*String hql = "from activity";
				Query query = session.createQuery(hql);
				List<activity> list = query.list();*/
				return activityList;
			}
		});

	}

}
