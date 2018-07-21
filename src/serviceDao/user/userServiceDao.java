package serviceDao.user;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.user.userDao;
import pojo.suggest;
import pojo.userInfo;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class userServiceDao implements userServiceDaoInterface{

	private userDao userDao;
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public userInfo login(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		userInfo user = new userInfo();
		user = userDao.login(dc);
		return user;
	}

	@Override
	//查询业务
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public List<userInfo> useFind(DetachedCriteria dc) {
		// TODO Auto-generated method stub
	    List<userInfo> list=null;
		try {
			list = userDao.useSelect(dc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return list;
	  }

	@Override
	//添加业务
	public void useAdd(userInfo use) {
		// TODO Auto-generated method stub
		try {
			userDao.useInsert(use);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	//删除业务
	public void useDel(userInfo user) {
		// TODO Auto-generated method stub
				try {
					userDao.useDelete(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	//更新业务
	public userInfo useSave(userInfo use) {
		// TODO Auto-generated method stub
		userInfo u=null;
		try {
			u = userDao.useUpdate(use);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void UsePassWord_edit(userInfo use) {
		// TODO Auto-generated method stub
		try {
			userDao.usePassWord_edit(use);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void UseSuggest(suggest suggest) {
		// TODO Auto-generated method stub
		try {
			userDao.useSuggest(suggest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUserDao(userDao userDao) {
		this.userDao = userDao;
	}
	
}
