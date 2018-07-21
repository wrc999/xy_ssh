package web.action.xk;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class list{
	private HttpServletRequest request = ServletActionContext.getRequest();
	public String jy() {
		String p =this.getClass().getResource("").getPath();
        int p1 = p.indexOf("webapps");
		String uploadFilePath = p.substring(1, p1)+"pic"+File.separator+"jy";
		// 存储要下载的文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
		// 将Map集合发送到listfile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);
		request.setAttribute("uploadFilePath", uploadFilePath);
		return "toListjy";
	}
	public String cx() {
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String uploadFilePath = p.substring(1, p1)+"pic"+File.separator+"cx";
		// 存储要下载的文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
		// 将Map集合发送到listfile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);
		request.setAttribute("uploadFilePath", uploadFilePath);
		return "toListcx";
	}
	public String zd() {
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String uploadFilePath = p.substring(1, p1)+"pic"+File.separator+"zd";
		// 存储要下载的文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
		// 将Map集合发送到listfile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);
		request.setAttribute("uploadFilePath", uploadFilePath);
		return "toListzd";
	}
	public String jc() {
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String uploadFilePath = p.substring(1, p1)+"pic"+File.separator+"jc";
		// 存储要下载的文件名
		Map<String, String> fileNameMap = new HashMap<String, String>();
		// 递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
		listfile(new File(uploadFilePath), fileNameMap);// File既可以代表一个文件也可以代表一个目录
		// 将Map集合发送到listfile.jsp页面进行显示
		request.setAttribute("fileNameMap", fileNameMap);
		request.setAttribute("uploadFilePath", uploadFilePath);
		return "toListjc";
	}
	public void listfile(File file, Map<String, String> map) {
		// 如果file代表的不是一个文件，而是一个目录
		if (!file.isFile()) {
			// 列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			// 遍历files[]数组
			for (File f : files) {
				// 递归
				listfile(f, map);
			}
		} else {
			
			String realName = file.getName();
			// file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key
			map.put(file.getName(), realName);
		}
	}
}
