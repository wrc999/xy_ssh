package pojo;

import java.util.ArrayList;

public class Talk {
	
	private int talk_id;		//分享编号
	private int use_id;			//用户编号
	private String talktime;	//分享时间
	private String talkcontent;	//分享内容
	private String talkphoto;	//分享照片url
	private String condition;	//查询条件
	private String account;		//获取用户名
	private String school;		//获取学校名
    private String nickname;      //获取昵称
    private String avapath;       //获取头像地址
    private ArrayList<ReplyTalk> replyTalkList;	//回复集合
    private ArrayList<praise> praiseList;	//点赞集合

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getTalk_id() {
		return talk_id;
	}
	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public String getTalktime() {
		return talktime;
	}
	public void setTalktime(String talktime) {
		this.talktime = talktime;
	}
	public String getTalkcontent() {
		return talkcontent;
	}
	public void setTalkcontent(String talkcontent) {
		this.talkcontent = talkcontent;
	}
	public String getTalkphoto() {
		return talkphoto;
	}
	public void setTalkphoto(String talkphoto) {
		this.talkphoto = talkphoto;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvapath() {
		return avapath;
	}
	public void setAvapath(String avapath) {
		this.avapath = avapath;
	}
	
	@Override
	public String toString() {
		return "Talk [talk_id=" + talk_id + ", use_id=" + use_id + ", talktime=" + talktime + ", talkcontent="
				+ talkcontent + ", talkphoto=" + talkphoto + ", condition=" + condition + ", account=" + account
				+ ", school=" + school + ", nickname=" + nickname + ", avapath=" + avapath + ", replyTalkList="
				+ replyTalkList + "]";
	}
	public ArrayList<ReplyTalk> getReplyTalkList() {
		return replyTalkList;
	}
	public void setReplyTalkList(ArrayList<ReplyTalk> replyTalkList) {
		this.replyTalkList = replyTalkList;
	}
	public ArrayList<praise> getPraiseList() {
		return praiseList;
	}
	public void setPraiseList(ArrayList<praise> praiseList) {
		this.praiseList = praiseList;
	}
	
	
}
