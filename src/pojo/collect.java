package pojo;

import java.util.ArrayList;

public class collect {

	private int collect_id;				//收藏编号
	private int use_id;					//分享用户
	private int talk_id;				//分享编号
	private String talkcontent;		//收藏内容
	private String talktime;			//收藏时间
	private String talkphoto;				//内容所带的图片url
	private String nickName;
	private String avaPath;
	private String school;
	private int collectUse_id;			//收藏用户id
	private ArrayList<ReplyTalk> replyTalkList;	//回复集合
    private ArrayList<praise> praiseList;	//点赞集合
	public int getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(int collect_id) {
		this.collect_id = collect_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public int getTalk_id() {
		return talk_id;
	}
	public void setTalk_id(int talk_id) {
		this.talk_id = talk_id;
	}
	public String getTalkcontent() {
		return talkcontent;
	}
	public void setTalkcontent(String talkcontent) {
		this.talkcontent = talkcontent;
	}
	public String getTalktime() {
		return talktime;
	}
	public void setTalktime(String talktime) {
		this.talktime = talktime;
	}
	public String getTalkphoto() {
		return talkphoto;
	}
	public void setTalkphoto(String talkphoto) {
		this.talkphoto = talkphoto;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvaPath() {
		return avaPath;
	}
	public void setAvaPath(String avaPath) {
		this.avaPath = avaPath;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getCollectUse_id() {
		return collectUse_id;
	}
	public void setCollectUse_id(int collectUse_id) {
		this.collectUse_id = collectUse_id;
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
	@Override
	public String toString() {
		return "collect [collect_id=" + collect_id + ", use_id=" + use_id + ", talk_id=" + talk_id + ", talkcontent="
				+ talkcontent + ", talktime=" + talktime + ", talkphoto=" + talkphoto + ", nickName=" + nickName
				+ ", avaPath=" + avaPath + ", school=" + school + ", collectUse_id=" + collectUse_id
				+ ", replyTalkList=" + replyTalkList + ", praiseList=" + praiseList + "]";
	}
	
}
