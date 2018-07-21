package web.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import pojo.suggest;
import serviceDao.user.userServiceDao;

public class suggestion extends ActionSupport implements ModelDriven<suggest>{

	private suggest suggest = new suggest();
	private String suggesttime=null;
	private userServiceDao useSD;
	private HttpServletResponse response= ServletActionContext.getResponse ();

	public void add() throws Exception {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		suggesttime = df.format(new Date());
		suggest.setSuggesttime(suggesttime);
		useSD.UseSuggest(suggest);
		out.print("1");
	}

	@Override
	public suggest getModel() {
		// TODO Auto-generated method stub
		return suggest;
	}

	public void setUseSD(userServiceDao useSD) {
		this.useSD = useSD;
	}

	
}
