package pojo;

public class activity {

	private int activity_id;	//活动编号
	private int use_id;			//发起人id
	private int joins;			//报名人数
	private String name;		//活动名称
	private String starttime;	//活动开始时间
	private String endtime;		//活动结束时间
	private String place;		//活动地点
	private String photo;		//活动照片
	private String intro;		//活动介绍
	private String school;		//学校
	private String nickName;	//发起人
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
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
		return "activity [activity_id=" + activity_id + ", use_id=" + use_id + ", joins=" + joins + ", name=" + name
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", place=" + place + ", photo=" + photo
				+ ", intro=" + intro + ", school=" + school + ", nickName=" + nickName + "]";
	}
	
}
