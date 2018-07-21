package pojo;

public class acollect {

	private int acollect_id;		//收藏编号
	private int use_id;				//收藏人编号
	private String acollecttime;	//收藏时间
	private int activity_id;		//活动编号
	private int ause_id;			//活动发起人编号
	private int joins;				//报名人数
	private String name;			//活动名称
	private String starttime;		//活动开始时间
	private String endtime;			//活动结束时间
	private String place;			//活动地点
	private String photo;			//活动照片
	private String intro;			//活动介绍
	private String school;			//发起人所属学校
	private String nickName;		//发起人昵称
	public int getAcollect_id() {
		return acollect_id;
	}
	public void setAcollect_id(int acollect_id) {
		this.acollect_id = acollect_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public String getAcollecttime() {
		return acollecttime;
	}
	public void setAcollecttime(String acollecttime) {
		this.acollecttime = acollecttime;
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
	public int getJoins() {
		return joins;
	}
	public void setJoins(int joins) {
		this.joins = joins;
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
	@Override
	public String toString() {
		return "acollect [acollect_id=" + acollect_id + ", use_id=" + use_id + ", acollecttime=" + acollecttime
				+ ", activity_id=" + activity_id + ", ause_id=" + ause_id + ", joins=" + joins + ", name=" + name
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", place=" + place + ", photo=" + photo
				+ ", intro=" + intro + ", school=" + school + ", nickName=" + nickName + "]";
	}
	
}
