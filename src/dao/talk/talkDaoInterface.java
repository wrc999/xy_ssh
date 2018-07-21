package dao.talk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.ReplyTalk;
import pojo.Talk;
import pojo.collect;
import pojo.praise;

public interface talkDaoInterface {
	
	  public ArrayList<Talk> talkSelect(Talk talk) throws SQLException, ClassNotFoundException;//用户查询
	  public List<ReplyTalk> replySelect() throws SQLException, ClassNotFoundException;//查询回复
	  public List<praise> praiseSelect() throws SQLException;	//查询点赞
	  public void praiseInsert(praise praise);//添加点赞
	  
	  public void talkInsert(Talk talk) throws SQLException;//添加
	  public void talkDelete(Talk talk) throws SQLException;//删除
	  
	  public void talkCollect_add(collect collect) throws SQLException;//添加收藏
	  public void talkCollect_delete(collect collect) throws SQLException;//删除收藏
	  public List<collect> talkCollect_find(DetachedCriteria dc) throws SQLException, ClassNotFoundException;//查询收藏
}
