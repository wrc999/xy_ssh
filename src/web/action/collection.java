package web.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import pojo.ReplyTalk;
import pojo.collect;
import pojo.praise;
import serviceDao.talk.talkServiceDao;

public class collection extends ActionSupport implements ModelDriven<collect>{

	private collect collect = new collect();
	private talkServiceDao talkSD;
	private HttpServletResponse response= ServletActionContext.getResponse ();
	private HttpServletRequest request = ServletActionContext.getRequest();

	public void add() throws Exception {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		collect.setTalktime(df.format(new Date()));
		System.out.println("-------"+collect);
		boolean a = talkSD.talkCollect_add(collect);
		out.println(a);
		out.close();
	}
	public void delete() throws Exception {
		// TODO Auto-generated method stub
		talkSD.talkCollect_delete(collect);
	}
	public void find() throws Exception {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		DetachedCriteria dc = DetachedCriteria.forClass(collect.class);
		dc.add(Restrictions.eq("collectUse_id",collect.getCollectUse_id()));
		ArrayList<collect> talkCollectList = (ArrayList<collect>) talkSD.talkCollect_find(dc);
		ArrayList<praise> praiseList = (ArrayList<praise>) talkSD.praiseFind();
  		ArrayList<ReplyTalk> ReplyList = (ArrayList<ReplyTalk>) talkSD.replyFind();
  		for(int i=0;i<talkCollectList.size();i++) {
  			ArrayList<ReplyTalk> reply = new ArrayList<ReplyTalk>();
  			for(int j=0;j<ReplyList.size();j++) {
  				if(talkCollectList.get(i).getTalk_id()==ReplyList.get(j).getTalk_id()) {
  					reply.add(ReplyList.get(j));
  				}
  				talkCollectList.get(i).setReplyTalkList(reply);
  			}
  		}
  		//添加点赞集合
  		for(int i=0;i<talkCollectList.size();i++) {
  			ArrayList<praise> praise = new ArrayList<praise>();
  			for(int j=0;j<praiseList.size();j++) {
  				if(talkCollectList.get(i).getTalk_id()==praiseList.get(j).getTalk_id()) {
  					praise.add(praiseList.get(j));
  				}
  				talkCollectList.get(i).setPraiseList(praise);
  			}
  		}
  		JSONArray stuMsg = JSONArray.fromObject(talkCollectList);
 	    out.print(stuMsg);
 	    out.close();
	}


	public void setTalkSD(talkServiceDao talkSD) {
		this.talkSD = talkSD;
	}
	@Override
	public collect getModel() {
		// TODO Auto-generated method stub
		return collect;
	}
	
}
