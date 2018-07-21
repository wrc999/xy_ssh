package serviceDao.activity;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.activity.activityDao;
import pojo.acollect;
import pojo.activity;
import pojo.activityjoins;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class activityService implements activityServiceInterface {
	private activityDao activityDao;
	
	@Override
	public void collectAdd(acollect a) {
		// TODO Auto-generated method stub
		activityDao.collectAdd(a);
	}
	
	
	@Override
	public List<activity> collectGet(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		List<activity> list = activityDao.collectGet(dc);
		return list;
	}
	
	@Override
	public void joinsAdd(activityjoins a) {
		activityDao.joinsAdd(a);
		
	}
	
	@Override
	public void add(activity activity) {
		activityDao.add(activity);
	}


	@Override
	public void delete(activity activity) {
		// TODO Auto-generated method stub
		activityDao.delete(activity);
	}
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public List<activity> get(int use_id) {
		List<activity> list = activityDao.get(use_id);
		return list;
	}

	public void setActivityDao(activityDao activityDao) {
		this.activityDao = activityDao;
	}

}
