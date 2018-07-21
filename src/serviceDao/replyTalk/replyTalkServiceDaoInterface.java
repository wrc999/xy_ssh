package serviceDao.replyTalk;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.ReplyTalk;

public interface replyTalkServiceDaoInterface {
	
	  public List<ReplyTalk> replyFind();//查询业务
	  public void replyAdd(ReplyTalk reply);//添加业务
	  public void replyDel(ReplyTalk reply);//删除业务
	  public void replySave(ReplyTalk reply);//修改业务
}
