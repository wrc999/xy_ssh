package web.action;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
import pojo.userInfo;
import serviceDao.user.userServiceDao;

public class user extends ActionSupport implements ModelDriven<userInfo>{

	private userInfo user = new userInfo();
	private userServiceDao useSD;
	private HttpServletResponse response= ServletActionContext.getResponse ();
	private HttpServletRequest request = ServletActionContext.getRequest();

	public void login() throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		DetachedCriteria dc = DetachedCriteria.forClass(userInfo.class);
		dc.add(Restrictions.and(Restrictions.eq("account", user.getAccount())).add(Restrictions.eq("passWord", user.getPassWord())));
		userInfo user = useSD.login(dc);
		if(user!=null){
			JSONObject jsonObject = JSONObject.fromObject(user);
			out.print(jsonObject);
	    }else {
	    	JSONObject jsonObject = JSONObject.fromObject(user);
	        	out.print(jsonObject);
	        }
		out.close();
		
	}

	public void add() throws Exception {
		response.setCharacterEncoding("UTF-8");
		if (user.getBirth().equals("")) {
			user.setBirth(null);
		}
		if (user.getEntryYear().equals("")) {
			user.setEntryYear(null);
		}
		useSD.useAdd(user);
		PrintWriter out = response.getWriter();
		out.print("1");
	}

	
	public void edit() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (user.getBirth().equals("")) {
			user.setBirth(null);
		}
		if (user.getEntryYear().equals("")) {
			user.setEntryYear(null);
		}
		userInfo user1 = useSD.useSave(user);
		JSONObject jsonObject = JSONObject.fromObject(user1);
		out.print(jsonObject);
	}
	public void delete() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		useSD.useDel(user);
		out.print("1");
	}
	public void get() throws Exception {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		DetachedCriteria dc = DetachedCriteria.forClass(userInfo.class);
  		String condition = user.getCondition();
  		if(condition!=null && !"".equals(condition)){
  			dc.add(Restrictions.like("account",condition));
  		}
  		userInfo user = useSD.login(dc);
  		JSONObject jsonObject = JSONObject.fromObject(user);
    	out.print(jsonObject);
 	    out.close();
	}
	public void PassWordEdit() throws Exception {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String newpassWord = request.getParameter("newpassWord");
		DetachedCriteria dc = DetachedCriteria.forClass(userInfo.class);
		dc.add(Restrictions.and(Restrictions.eq("account", user.getAccount())).add(Restrictions.eq("passWord", user.getPassWord())));
		userInfo user  = useSD.login(dc);
		if(user!=null) {
			user.setPassWord(newpassWord);
			System.out.println("新密码"+user.getPassWord());
			useSD.UsePassWord_edit(user);
			out.println("1");
		}
	}

	public void adminGet() throws Exception {
		// TODO Auto-generated method stub
		String _pageSize = request.getParameter("limit");
		String _page = request.getParameter("page");
		int pageSize = 10;
		if(_pageSize != null && !_pageSize.equals("")){
			pageSize = Integer.parseInt(_pageSize);
		}
		int page = 1;
		if(_page != null && !_pageSize.equals("")){
			page = Integer.parseInt(_page);
		}
	    String condition = user.getCondition();
	    DetachedCriteria dc = DetachedCriteria.forClass(userInfo.class);
  		if(condition!=null && !"".equals(condition)){
  			dc.add(Restrictions.like("account","%"+condition+"%"));
  		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<userInfo> userList = (ArrayList<userInfo>) useSD.useFind(dc);
		int total = userList.size();
		ArrayList<userInfo> userList1 = new ArrayList<userInfo>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("count", total);
		resultMap.put("msg", "");
		resultMap.put("code", 0);
		if(_page != null && _page.length() > 0 && _pageSize!=null && _pageSize.length()>0){
			for(int i = (page-1)*pageSize ; i< page*pageSize && i< total;i++){
				userList1.add(userList.get(i));
			}
			resultMap.put("data", userList1);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}else{
			resultMap.put("data", userList);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}
	}
	
	@Override
	public userInfo getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public void setUseSD(userServiceDao useSD) {
		this.useSD = useSD;
	}
	
}
