package web.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import pojo.ReplyTalk;
import serviceDao.replyTalk.replyTalkServiceDao;

public class reply extends ActionSupport implements ModelDriven<ReplyTalk>{
	
	private ReplyTalk reply = new ReplyTalk();
	replyTalkServiceDao replySD;
	private HttpServletResponse response= ServletActionContext.getResponse ();
	public void get() throws Exception {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ArrayList<ReplyTalk> useList = (ArrayList<ReplyTalk>) replySD.replyFind();
  		JSONArray stuMsg = JSONArray.fromObject(useList);
 	    out.print(stuMsg);
 	    out.close();
	}
	public void add() throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String replytime = df.format(new Date());
		reply.setReplytime(replytime);
		replySD.replyAdd(reply);
		System.out.println(reply);
		out.print("1");
	}
	@Override
	public ReplyTalk getModel() {
		// TODO Auto-generated method stub
		return reply;
	}
	public void setReplySD(replyTalkServiceDao replySD) {
		this.replySD = replySD;
	}
	
}
