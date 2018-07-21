package serviceDao.view;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.view.viewDao;
import pojo.view;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class viewService implements viewServiceInterface {

	private viewDao vD;
	
	@Override
	public void add(view v) {
		vD.add(v);
	}
	
	@Override
	public void delete(view v) {
		// TODO Auto-generated method stub
		vD.delete(v);
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public List<view> get(DetachedCriteria dc) {
		return vD.get(dc);
	}

	public void setvD(viewDao vD) {
		this.vD = vD;
	}

}
