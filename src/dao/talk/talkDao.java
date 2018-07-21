package dao.talk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import pojo.ReplyTalk;
import pojo.Talk;
import pojo.collect;
import pojo.praise;

public class talkDao extends HibernateDaoSupport implements talkDaoInterface {
	  
	public talkDao() {
		super();
	}
	@Override
	//查询点赞
	public List<praise> praiseSelect() throws SQLException {
		return getHibernateTemplate().execute(new HibernateCallback<List<praise>>() {

			@Override
			public List<praise> doInHibernate(Session session) throws HibernateException {
				String sql = "select * from praise";
				SQLQuery query = session.createSQLQuery(sql);
				List<Object> list = query.list();
				ArrayList<praise> praiseList = new ArrayList<praise>();
				for(Object obj:list) {
					Object[] objs = (Object[])obj;
					praise p = new praise();
					p.setPraise_id((int)objs[0]);
					p.setTalk_id((int)objs[1]);
					p.setUse_id((int)objs[2]);
					p.setNickName((String)objs[3]);
					praiseList.add(p);
				}
				return praiseList;
			}
		});
	}
	@Override
	//查询记录
	public List<ReplyTalk> replySelect() throws SQLException, ClassNotFoundException {
		return getHibernateTemplate().execute(new HibernateCallback<List<ReplyTalk>>() {

			@Override
			public List<ReplyTalk> doInHibernate(Session session) throws HibernateException {
				String sql = "select r.*,u.nickName from replytalk r,userinfo u where r.use_id=u.use_id";
				SQLQuery query = session.createSQLQuery(sql);
				List<Object> list = query.list();
				ArrayList<ReplyTalk> replyList = new ArrayList<ReplyTalk>();
				for(Object obj:list) {
					 Object[] objs = (Object[])obj;
					 ReplyTalk r = new ReplyTalk();
			         r.setReplytalk_id((int)objs[0]);
			         r.setTalk_id((int)objs[1]);
			         r.setUse_id((int) objs[2]);
			         r.setReplytime(objs[3].toString().substring(0, 19));
			         r.setReplycontent((String) objs[4]);
			         r.setNickName((String) objs[5]);
			         replyList.add(r);
				}
			    return replyList;
			}
			
		});
	}
	@Override
	//查询记录
	public ArrayList<Talk> talkSelect(Talk talk) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<ArrayList<Talk>>() {
			@Override
			public ArrayList<Talk> doInHibernate(Session session) throws HibernateException {
				String hql = "select t.*,u.account,u.school,u.nickName,u.avaPath from Talk t,userInfo u where t.use_id=u.use_id ";
			    String condition = talk.getCondition();
			    if(condition !=null && !condition.equals("")){
			      hql += "and t." + condition;
			    }
			    SQLQuery query = session.createSQLQuery(hql);
				List<Object> list = query.list();
				ArrayList<Talk> talkList = new ArrayList<Talk>();
				for(Object obj:list) {
					 Object[] objs = (Object[])obj;
			         Talk t = new Talk();
			         t.setTalk_id((int)objs[0]);
			         t.setUse_id((int)objs[1]);
			         t.setTalkcontent((String) objs[2]);
			         t.setTalkphoto((String) objs[3]);
			         t.setTalktime(objs[4].toString().substring(0, 19));
			         t.setAccount((String) objs[5]);
			         t.setSchool((String) objs[6]);
			         t.setNickname((String) objs[7]);
			         t.setAvapath((String) objs[8]);
			         talkList.add(t);
				}
			    return talkList;
			}
		});
	}

	@Override
	//插入记录
	public void talkInsert(Talk talk) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(talk);
	}
	@Override
	public void praiseInsert(praise praise) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(praise);
	}

	@Override
	//删除记录
	public void talkDelete(Talk talk) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(talk);
	}

	@Override
	public void talkCollect_add(collect collect) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(collect);
	}

	@Override
	public void talkCollect_delete(collect collect) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(collect);
	}

	@Override
	public List<collect> talkCollect_find(DetachedCriteria dc) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<collect> talklist = (List<collect>) getHibernateTemplate().findByCriteria(dc);
	    return talklist;
	}
}