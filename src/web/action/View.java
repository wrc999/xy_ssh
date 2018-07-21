package web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.userInfo;
import pojo.view;
import serviceDao.view.viewService;

public class View extends ActionSupport implements ModelDriven<view> {
	
	private view v = new view();
	private viewService vS;
	private HttpServletResponse response= ServletActionContext.getResponse ();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public void add() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		v.setUploadTime(df.format(new Date()));
		vS.add(v);
		out.println("1");
	}
	
	public void delete() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		vS.delete(v);
		out.println("1");
	}
	
	public void get() throws IOException{
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		DetachedCriteria dc = DetachedCriteria.forClass(view.class);
		if(v.getSchool()!=null) {
			dc.add(Restrictions.eq("school", v.getSchool()));
		}
		ArrayList<view> viewList = (ArrayList<view>) vS.get(dc);
  		JSONArray stuMsg = JSONArray.fromObject(viewList);
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
	    String condition = request.getParameter("condition");
	    DetachedCriteria dc = DetachedCriteria.forClass(view.class);
  		if(condition!=null && !"".equals(condition)){
  			dc.add(Restrictions.or(Restrictions.eq("use_id",Integer.parseInt(condition)),Restrictions.like("account","%"+condition+"%")));
  		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<view> viewList = (ArrayList<view>) vS.get(dc);
		int total = viewList.size();
		ArrayList<view> viewList1 = new ArrayList<view>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("total", total);
		if(_page != null && _page.length() > 0 && _pageSize!=null && _pageSize.length()>0){
			for(int i = (page-1)*pageSize ; i< page*pageSize && i< total;i++){
				viewList1.add(viewList.get(i));
			}
			resultMap.put("rows", viewList1);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}else{
			resultMap.put("rows", viewList);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}
	}
	
	@Override
	public view getModel() {
		// TODO Auto-generated method stub
		return v;
	}
	public void setvS(viewService vS) {
		this.vS = vS;
	}

}
