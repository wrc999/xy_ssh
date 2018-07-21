package dao.user;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.suggest;
import pojo.userInfo;

public interface userDaoInterface {

	public userInfo login(DetachedCriteria dc);//登录
	public List<userInfo> useSelect(DetachedCriteria dc) throws SQLException, ClassNotFoundException;//查询
	public void useInsert(userInfo use) throws SQLException;//添加
	public void useDelete(userInfo user) throws SQLException;//删除
	public userInfo useUpdate(userInfo use) throws SQLException;//修改
	public void usePassWord_edit(userInfo use) throws SQLException;//修改密码
	public void useSuggest(suggest suggest) throws SQLException;//意见反馈
}
