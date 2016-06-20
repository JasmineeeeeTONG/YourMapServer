package action;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import exception.FileUploadException;
import service.IUserService;
import service.ValidateService;
import util.RandomUtil;

public class UserHeadImgUpload extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	//input param
	private File headImg;
	
	private String url;
	
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;

	private IUserService userService;
	
	@Override
	public String execute() throws Exception {
		
		Set<Object> params = new HashSet<Object>();
		params.add(headImg);
//		params.add(rurl);
		ValidateService.ValidateNecessaryArguments(params);
		User user = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User) session.getAttribute("user");
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/");
        if(headImg != null) {
           File savefile = new File(new File(realpath+"/headImg"), RandomUtil.generateUUID() + ".jepg");
           if (!savefile.getParentFile().exists())
               savefile.getParentFile().mkdirs();
           FileUtils.copyFile(headImg, savefile);
           user.setHeadImg(savefile.getAbsolutePath().replace(realpath, ""));
           userService.updateUser(user);
           url = user.getHeadImg();
	     }else{
	    	 throw new FileUploadException();
	     }
	     return SUCCESS;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getUrl() {
		return url;
	}

	public Integer getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

}
