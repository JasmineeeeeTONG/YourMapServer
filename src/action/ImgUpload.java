package action;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Img;
import bean.User;
import exception.FileUploadException;
import exception.UserNotLoginException;
import service.IImgService;
import service.IUserService;
import service.ValidateService;
import util.RandomUtil;

public class ImgUpload extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//input param
	private File img;
	private Integer sightId;	
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;

	private IImgService imgService;
	
	@Override
	public String execute() throws Exception {
		
		Set<Object> params = new HashSet<Object>();
		params.add(img);
		params.add(sightId);
//		params.add(rurl)
		ValidateService.ValidateNecessaryArguments(params);
		User user = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User) session.getAttribute("user");
		if (user == null) {
			throw new UserNotLoginException();
		}
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/");
        if(img != null) {
           File savefile = new File(new File(realpath+"/sightImg"), RandomUtil.generateUUID() + ".jpg");
           if (!savefile.getParentFile().exists())
               savefile.getParentFile().mkdirs();
           FileUtils.copyFile(img, savefile);
           Img img = new Img();
           img.setSightId(sightId);
           img.setUrl(savefile.getAbsolutePath().replace(realpath, ""));
           imgService.addImg(img);
	     }else{
	    	 throw new FileUploadException();
	     }
	     return SUCCESS;
	}

	public Integer getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setImgService(IImgService imgService) {
		this.imgService = imgService;
	}
	
	

}
