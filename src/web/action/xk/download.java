package web.action.xk;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class download extends ActionSupport{
    // 要下载的文件名称  
    private String fileName;  
    // 文件的Mime类型  
    private String contentType;   
    // 该属性设置与否都可以，但是比如提供get方法  
    private InputStream fileInputStream;  
      
	public String jy() throws Exception {
		// TODO Auto-generated method stub
		
		String p =this.getClass().getResource("").getPath();
        int p1 = p.indexOf("webapps");
		String path = p.substring(1, p1)+"pic"+File.separator+"jy";
        ServletContext context = ServletActionContext.getServletContext();
        String mimeType = context.getMimeType(path +File.separator+ fileName);  
        setContentType(mimeType);  
        //当采用 return ServletActionContext.getServletContext().getResourceAsStream("...")
        //这种方法获得输入流的时候，要保证文件位置在 ServletContext 当中，就是说要在当前的应用上下文中
        //fileInputStream = context.getResourceAsStream(path +"/"+ fileName);
        
        //如果想要获得外部文件 譬如 D盘中的某个文件，那么就要自己创建输入流才可以
        fileInputStream = new FileInputStream(new File(path+"/"+fileName));
        return SUCCESS; 
	}
	public String cx() throws Exception {
		// TODO Auto-generated method stub
		
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String path = p.substring(1, p1)+"pic"+File.separator+"cx";
		ServletContext context = ServletActionContext.getServletContext();
		String mimeType = context.getMimeType(path +File.separator+ fileName);  
		setContentType(mimeType);  
		fileInputStream = new FileInputStream(new File(path+File.separator+fileName));
		return SUCCESS; 
	}
	public String zd() throws Exception {
		// TODO Auto-generated method stub
		
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String path = p.substring(1, p1)+"pic"+File.separator+"zd";
		ServletContext context = ServletActionContext.getServletContext();
		String mimeType = context.getMimeType(path +File.separator+ fileName);  
		setContentType(mimeType);  
		fileInputStream = new FileInputStream(new File(path+File.separator+fileName));
		return SUCCESS; 
	}
	public String jc() throws Exception {
		// TODO Auto-generated method stub
		
		String p =this.getClass().getResource("").getPath();
		int p1 = p.indexOf("webapps");
		String path = p.substring(1, p1)+"pic"+File.separator+"jc";
		ServletContext context = ServletActionContext.getServletContext();
		String mimeType = context.getMimeType(path +File.separator+ fileName);  
		setContentType(mimeType);  
		fileInputStream = new FileInputStream(new File(path+File.separator+fileName));
		return SUCCESS; 
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	
	
	
}
