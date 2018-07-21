package dao.replyTalk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import pojo.ReplyTalk;

public class replyTalkDao extends HibernateDaoSupport implements replyTalkDaoInterface {

	
	public replyTalkDao() {
		super();
		// TODO Auto-generated constructor stub
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
				System.out.println(replyList);
			    return replyList;
			}
			
		});
	}

	@Override
	//插入记录
	public void replyInsert(ReplyTalk reply) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(reply);
	}

	@Override
	//删除记录
	public void replyDelete(ReplyTalk replytalk) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(replytalk);
	}

	@Override
	//删除记录
	public void replyUpdate(ReplyTalk reply) throws SQLException {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(reply);
	}

}
