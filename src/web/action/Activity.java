package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.Talk;
import pojo.acollect;
import pojo.activity;
import pojo.activityjoins;
import pojo.userInfo;
import serviceDao.activity.activityService;

public class Activity extends ActionSupport{

	private activity activity = new activity();
	private int use_id;						//发起人id
	private String name;					//活动名
	private String starttime;				//开始时间
	private String endtime;					//结束时间
	private String place;					//活动地点
	private int joins;						//参与人数
	private String photo;					//活动照片
	private String intro;					//活动简介
	private int activity_id;				//收藏活动编号
	private int ause_id;					//收藏用户id
	private String acollecttime;			//收藏时间
	private String school;					//学校
	private String nickName;				//昵称
	private int condition;					//查询条件
	private activityjoins ajoins = new activityjoins();
	private acollect aco = new acollect();
	private activityService activitySD;
	private HttpServletResponse response= ServletActionContext.getResponse ();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public void collectAdd() throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		acollecttime = df.format(new Date());
		aco.setAuse_id(ause_id);
		aco.setAcollecttime(acollecttime);
		aco.setActivity_id(activity_id);
		aco.setUse_id(use_id);
		aco.setName(name);
		aco.setStarttime(starttime);
		aco.setEndtime(endtime);
		aco.setPlace(place);
		aco.setJoins(joins);
		aco.setPhoto(photo);
		aco.setIntro(intro);
		aco.setSchool(school);
		aco.setNickName(nickName);
		activitySD.collectAdd(aco);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("1");
		out.close();
	}
	
	public void collectGet() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		DetachedCriteria dc = DetachedCriteria.forClass(acollect.class);
		dc.add(Restrictions.eq("use_id", condition));
		ArrayList<activity> activityList = (ArrayList<activity>) activitySD.collectGet(dc);
  		JSONArray stuMsg = JSONArray.fromObject(activityList);
 	    out.print(stuMsg);
	}
	
	public void joinsAdd() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ajoins.setActivity_id(activity_id);
		ajoins.setUse_id(use_id);
		activitySD.joinsAdd(ajoins);
		out.println("1");
		out.close();
	}
	
	public void add() throws IOException {
		activity.setUse_id(use_id);
		activity.setName(name);
		activity.setStarttime(starttime);
		activity.setEndtime(endtime);
		activity.setPlace(place);
		activity.setPhoto(photo);
		activity.setIntro(intro);
		activity.setJoins(1);
		System.out.println(activity);
		activitySD.add(activity);
		PrintWriter out = response.getWriter();
		out.println("1");
		out.close();
	}
	public void delete() throws IOException {
		activity.setActivity_id(activity_id);
		activitySD.delete(activity);
		PrintWriter out = response.getWriter();
		out.println("1");
		out.close();
	}
	
	public void get() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
  		ArrayList<activity> activityList = (ArrayList<activity>) activitySD.get(condition);
  		JSONArray stuMsg = JSONArray.fromObject(activityList);
 	    out.print(stuMsg);
 	    out.close();
	}
	
	public void adminGet() throws Exception {
		// TODO Auto-generated method stub
		String _pageSize = request.getParameter("rows");
		String _page = request.getParameter("page");
		int pageSize = 10;
		if(_pageSize != null && !_pageSize.equals("")){
			pageSize = Integer.parseInt(_pageSize);
		}
		int page = 1;
		if(_page != null && !_pageSize.equals("")){
			page = Integer.parseInt(_page);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<activity> activityList = (ArrayList<activity>) activitySD.get(condition);
		int total = activityList.size();
		ArrayList<activity> activityList1 = new ArrayList<activity>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("total", total);
		if(_page != null && _page.length() > 0 && _pageSize!=null && _pageSize.length()>0){
			for(int i = (page-1)*pageSize ; i< page*pageSize && i< total;i++){
				activityList1.add(activityList.get(i));
			}
			resultMap.put("rows", activityList1);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}else{
			resultMap.put("rows", activityList);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}
	}

	public void setActivitySD(activityService activitySD) {
		this.activitySD = activitySD;
	}

	public int getUse_id() {
		return use_id;
	}

	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getJoins() {
		return joins;
	}

	public void setJoins(int joins) {
		this.joins = joins;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	public int getAuse_id() {
		return ause_id;
	}

	public void setAuse_id(int ause_id) {
		this.ause_id = ause_id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}



}
