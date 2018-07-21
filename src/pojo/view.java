package pojo;

public class view {

	private int view_id;
	private int use_id;
	private String photo;
	private String school;
	private String uploadTime;
	public int getView_id() {
		return view_id;
	}
	public void setView_id(int view_id) {
		this.view_id = view_id;
	}
	public int getUse_id() {
		return use_id;
	}
	public void setUse_id(int use_id) {
		this.use_id = use_id;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	@Override
	public String toString() {
		return "view [view_id=" + view_id + ", use_id=" + use_id + ", photo=" + photo + ", school=" + school
				+ ", uploadTime=" + uploadTime + "]";
	}
	
	
}
