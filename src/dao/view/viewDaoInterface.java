package dao.view;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import pojo.view;

public interface viewDaoInterface {

	public void add(view v);
	public void delete(view v);
	public List<view> get(DetachedCriteria dc);
}
