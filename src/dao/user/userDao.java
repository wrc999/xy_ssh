package dao.user;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import pojo.suggest;
import pojo.userInfo;

public class userDao extends HibernateDaoSupport implements userDaoInterface{

		public userDao() {
		super();
		// TODO Auto-generated constructor stub
	}
		
		//将用户输入的用户名和密码与数据库中的账号密码相匹配
		 public userInfo login(DetachedCriteria dc) {
			 List<userInfo> list = (List<userInfo>) getHibernateTemplate().findByCriteria(dc);
				if(list != null && list.size()>0){
					return list.get(0);
				}else{
					return null;
				}
		 }
		 
		//查询记录
		  public List<userInfo> useSelect(DetachedCriteria dc) throws SQLException {
			List<userInfo> useList = (List<userInfo>) getHibernateTemplate().findByCriteria(dc);
			return useList;
		  }
		  //插入记录
		  public void useInsert(userInfo use) throws SQLException {
			  getHibernateTemplate().save(use);
			  }
		//更新记录
		  public userInfo useUpdate(userInfo use) throws SQLException {
			  userInfo u = getHibernateTemplate().get(userInfo.class, use.getUse_id());
			  	u.setPassWord(use.getPassWord());
				u.setAvaPath(use.getAvaPath());
				u.setNickName(use.getNickName());
				u.setBirth(use.getBirth());
				u.setSex(use.getSex());
				u.setSchool(use.getSchool());
				u.setAcademy(use.getAcademy());
				u.setMajor(use.getMajor());
				u.setEntryYear(use.getEntryYear());
				u.setPerSign(use.getPerSign());
				u.setHobby(use.getHobby());
				u.setHomeTown(use.getHomeTown()); 
				getHibernateTemplate().update(u);
				return  getHibernateTemplate().get(userInfo.class, use.getUse_id());
		  }
		  //删除记录
		  public void useDelete(userInfo user) throws SQLException {
			  getHibernateTemplate().delete(user);
		  }
		@Override
		public void usePassWord_edit(userInfo use) throws SQLException {
			// TODO Auto-generated method stub
			getHibernateTemplate().update(use);
		}
		@Override
		//意见反馈
		public void useSuggest(suggest suggest) throws SQLException {
			// TODO Auto-generated method stub
			getHibernateTemplate().save(suggest);
		}
	}
