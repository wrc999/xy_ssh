package serviceDao.replyTalk;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.replyTalk.replyTalkDao;
import pojo.ReplyTalk;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class replyTalkServiceDao implements replyTalkServiceDaoInterface {
	replyTalkDao replyDao;

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public List<ReplyTalk> replyFind() {
		// TODO Auto-generated method stub
	    List<ReplyTalk> replyList=null;
			try {
				replyList = replyDao.replySelect();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    return replyList;
	}

	@Override
	public void replyAdd(ReplyTalk reply) {
		// TODO Auto-generated method stub
		try {
			replyDao.replyInsert(reply);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void replyDel(ReplyTalk reply) {
		// TODO Auto-generated method stub
		      try {
		    	  replyDao.replyDelete(reply);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void replySave(ReplyTalk reply) {
		// TODO Auto-generated method stub
		try {
			replyDao.replyUpdate(reply);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setReplyDao(replyTalkDao replyDao) {
		this.replyDao = replyDao;
	}
	
}