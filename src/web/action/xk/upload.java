package web.action.xk;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class upload extends ActionSupport{
	
	private File file;
	private String fileFileName;
	public String jy() throws Exception {
		// TODO Auto-generated method stub
		String p =this.getClass().getResource("").getPath();
        int p1 = p.indexOf("webapps");
		String savePath = p.substring(1, p1)+"pic"+File.separator+"jy";
		File filePath = new File(savePath);
		if(!filePath.exists()) {filePath.mkdirs();}
		file.renameTo(new File(filePath,fileFileName));
		return "toList";
	}
	public String cx() throws Exception {
		// TODO Auto-generated method stub
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String savePath = p.substring(1, p1)+"pic"+File.separator+"cx";
		File filePath = new File(savePath);
		if(!filePath.exists()) {filePath.mkdirs();}
		file.renameTo(new File(filePath,fileFileName));
		return "toList";
	}
	public String zd() throws Exception {
		// TODO Auto-generated method stub
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String savePath = p.substring(1, p1)+"pic"+File.separator+"zd";
		File filePath = new File(savePath);
		if(!filePath.exists()) {filePath.mkdirs();}
		file.renameTo(new File(filePath,fileFileName));
		return "toList";
	}
	public String jc() throws Exception {
		// TODO Auto-generated method stub
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String savePath = p.substring(1, p1)+"pic"+File.separator+"jc";
		File filePath = new File(savePath);
		if(!filePath.exists()) {filePath.mkdirs();}
		file.renameTo(new File(filePath,fileFileName));
		return "toList";
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
}
