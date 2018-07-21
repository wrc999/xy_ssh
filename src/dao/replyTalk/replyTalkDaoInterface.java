package dao.replyTalk;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.ReplyTalk;

public interface replyTalkDaoInterface {

	List<ReplyTalk> replySelect() throws SQLException, ClassNotFoundException;//查询
	  public void replyInsert(ReplyTalk replytalk) throws SQLException;//添加
	  public void replyDelete(ReplyTalk replytalk) throws SQLException;//删除
	  public void replyUpdate(ReplyTalk replytalk) throws SQLException;//修改
}
