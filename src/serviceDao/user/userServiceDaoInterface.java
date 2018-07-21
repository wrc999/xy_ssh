package serviceDao.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.suggest;
import pojo.userInfo;

public interface userServiceDaoInterface {
		public userInfo login(DetachedCriteria dc);//登录业务
		public List<userInfo> useFind(DetachedCriteria dc);//查询业务
		public void useAdd(userInfo user);//添加业务
		public void useDel(userInfo user);//删除业务
		public userInfo useSave(userInfo user);//修改业务
		public void UsePassWord_edit(userInfo user);//密码修改业务
		public void UseSuggest(suggest suggest);//意见反馈业务
}
