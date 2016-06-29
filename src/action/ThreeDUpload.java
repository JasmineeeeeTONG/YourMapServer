package action;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import bean.Video;
import exception.FileUploadException;
import exception.UserNotLoginException;
import service.IVideoService;
import service.ValidateService;
import util.RandomUtil;

public class ThreeDUpload extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//input param
	private File threeD;
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;
	
	@Override
	public String execute() throws Exception {
		
		Set<Object> params = new HashSet<Object>();
		params.add(threeD);
//		params.add(rurl)
		ValidateService.ValidateNecessaryArguments(params);
		User user = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User) session.getAttribute("user");
		if (user == null) {
			throw new UserNotLoginException();
		}
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/");
        if(threeD != null) {
           File savefile = new File(new File(realpath+"/threeD"), RandomUtil.generateUUID() + ".3d");
           if (!savefile.getParentFile().exists())
               savefile.getParentFile().mkdirs();
           FileUtils.copyFile(threeD, savefile);
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

	public void setThreeD(File threeD) {
		this.threeD = threeD;
	}

	
	
	
}
