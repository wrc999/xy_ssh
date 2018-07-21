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

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import pojo.ReplyTalk;
import pojo.Talk;
import pojo.praise;
import serviceDao.talk.talkServiceDao;

public class talk extends ActionSupport{

	private Talk talk = new Talk();
	private praise praise = new praise();
	private int talk_id;
	private String nickName;
	private int use_id;
	private String talkContent;
	private String talkPhoto;
	private talkServiceDao talkSD;
	private HttpServletResponse response= ServletActionContext.getResponse ();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	public void praiseAdd() throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		praise.setNickName(nickName);
		praise.setTalk_id(talk_id);
		praise.setUse_id(use_id);
		talkSD.pariseAdd(praise);
		out.println("1");
	
	}
	
	public void add() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//发布内容
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String talktime = df.format(new Date());
		talk.setUse_id(use_id);
		talk.setTalkcontent(talkContent);
		talk.setTalkphoto(talkPhoto);
		talk.setTalktime(talktime);
		talkSD.talkAdd(talk);
		out.println("1");
	}
	public void delete() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		talk.setTalk_id(Integer.parseInt(request.getParameter("talk_id")));
		talkSD.talkDel(talk);
		// TODO Auto-generated method stub
		out.println("1");
	}
	public void get() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
  		String condition = request.getParameter("condition");
  		if (condition != null && condition.length() > 0){
	    	talk.setCondition("use_id="+condition);
	    }else{
	    	talk.setCondition("");
	    }
  		//添加回复集合
  		ArrayList<praise> praiseList = (ArrayList<praise>) talkSD.praiseFind();
  		ArrayList<ReplyTalk> ReplyList = (ArrayList<ReplyTalk>) talkSD.replyFind();
  		ArrayList<Talk> talkList = (ArrayList<Talk>) talkSD.talkFind(talk);
  		for(int i=0;i<talkList.size();i++) {
  			ArrayList<ReplyTalk> reply = new ArrayList<ReplyTalk>();
  			for(int j=0;j<ReplyList.size();j++) {
  				if(talkList.get(i).getTalk_id()==ReplyList.get(j).getTalk_id()) {
  					reply.add(ReplyList.get(j));
  				}
  				talkList.get(i).setReplyTalkList(reply);
  			}
  		}
  		//添加点赞集合
  		for(int i=0;i<talkList.size();i++) {
  			ArrayList<praise> praise = new ArrayList<praise>();
  			for(int j=0;j<praiseList.size();j++) {
  				if(talkList.get(i).getTalk_id()==praiseList.get(j).getTalk_id()) {
  					praise.add(praiseList.get(j));
  				}
  				talkList.get(i).setPraiseList(praise);
  			}
  		}
  		JSONArray stuMsg = JSONArray.fromObject(talkList);
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
  
  		if (condition != null && condition.length() > 0){
	    	talk.setCondition("talkcontent like '%"+condition+"%' or account like '%"+condition+"%' or school like '%"+condition+"%'");
	    }else{
	    	talk.setCondition("");
	    }
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<Talk> talkList = (ArrayList<Talk>) talkSD.talkFind(talk);
		int total = talkList.size();
		ArrayList<Talk> userList1 = new ArrayList<Talk>();
		Map<String, Serializable> resultMap = new HashMap<String, Serializable>();
		resultMap.put("total", total);
		if(_page != null && _page.length() > 0 && _pageSize!=null && _pageSize.length()>0){
			for(int i = (page-1)*pageSize ; i< page*pageSize && i< total;i++){
				userList1.add(talkList.get(i));
			}
			resultMap.put("rows", userList1);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}else{
			resultMap.put("rows", talkList);
	        JSONObject jsonObject = JSONObject.fromObject(resultMap);
			out.print(jsonObject);
		}
	}
	
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	
	public void setTalkSD(talkServiceDao talkSD) {
		this.talkSD = talkSD;
	}
	public String getTalkPhoto() {
		return talkPhoto;
	}
	public void setTalkPhoto(String talkPhoto) {
		this.talkPhoto = talkPhoto;
	}
	public String getTalkContent() {
		return talkContent;
	}
	public void setTalkContent(String talkContent) {
		this.talkContent = talkContent;
	}

	public int getTalk_id() {
		return talk_id;
	}

	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
