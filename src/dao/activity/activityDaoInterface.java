package dao.activity;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.acollect;
import pojo.activity;
import pojo.activityjoins;

public interface activityDaoInterface {
		public void add(activity activity);						//添加果断
		public void delete(activity activity);					//删除活动
		public List<activity> get(int use_id);					//查询活动
		public void joinsAdd(activityjoins a);					//添加报名者
		public void collectAdd(acollect a);						//添加活动收藏
		public List<activity> collectGet(DetachedCriteria dc);	//查询活动收藏
}
