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
import bean.Video;
import exception.FileUploadException;
import exception.UserNotLoginException;
import service.IImgService;
import service.IVideoService;
import service.ValidateService;
import util.RandomUtil;

public class VideoUpload extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//input param
	private File video;
	private Integer sightId;	
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;

	private IVideoService videoService;
	
	@Override
	public String execute() throws Exception {
		
		Set<Object> params = new HashSet<Object>();
		params.add(video);
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
        if(video != null) {
           File savefile = new File(new File(realpath+"/video"), RandomUtil.generateUUID() + ".mp4");
           if (!savefile.getParentFile().exists())
               savefile.getParentFile().mkdirs();
           FileUtils.copyFile(video, savefile);
           Video video = new Video();
           video.setSightId(sightId);
           video.setUrl(savefile.getAbsolutePath().replace(realpath, ""));
           videoService.addVideo(video);
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

	public void setVideo(File video) {
		this.video = video;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setVideoService(IVideoService videoService) {
		this.videoService = videoService;
	}

	
	
}

