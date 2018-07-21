package pojo;

public class activityjoins {

	private int joins_id;		//报名编号
	private int use_id;			//用户编号
	private int activity_id;	//活动编号
	public int getJoins_id() {
		return joins_id;
	}
	public void setJoins_id(int joins_id) {
		this.joins_id = joins_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	@Override
	public String toString() {
		return "activityjoins [joins_id=" + joins_id + ", use_id=" + use_id + ", activity_id=" + activity_id + "]";
	}
	
}
