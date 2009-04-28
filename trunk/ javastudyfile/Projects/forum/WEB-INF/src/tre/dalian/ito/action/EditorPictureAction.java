package tre.dalian.ito.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class EditorPictureAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int BUFFER_SIZE=8*1024;
	private static final String url="user/local";
	private File imgFile;
	private String contentType;
	private String fileName;

	public File getImgFile() {
		return imgFile;
	}
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}
	public void setImgFileContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setImgFileFileName(String fileName) {
		this.fileName = fileName;
	}
	private String returnUrl;
	private String imgTitle;
	private String imgWidth;
	private String imgHeight;
	private String imgBorder;
	
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getImgTitle() {
		return imgTitle;
	}
	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}
	public String getImgWidth() {
		return imgWidth;
	}
	public void setImgWidth(String imgWidth) {
		this.imgWidth = imgWidth;
	}
	public String getImgHeight() {
		return imgHeight;
	}
	public void setImgHeight(String imgHeight) {
		this.imgHeight = imgHeight;
	}
	public String getImgBorder() {
		return imgBorder;
	}
	public void setImgBorder(String imgBorder) {
		this.imgBorder = imgBorder;
	}
	@Override
	public String execute() throws Exception {
		File dirFile=new File(ServletActionContext.getServletContext().getRealPath("file")+"\\"+fileName);
		this.returnUrl="file\\"+fileName;
		copy(imgFile,dirFile);
		return SUCCESS;
	}
	private static void copy(File src,File dst ){
		try{
			InputStream in=null;
			OutputStream out=null;
			try{
				in=new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
				out=new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
				byte[] buffer=new byte[BUFFER_SIZE];
				while(in.read(buffer)>0){
					out.write(buffer);
				}
			}finally{
				if(null!=in){
					in.close();
				}else{
					out.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
