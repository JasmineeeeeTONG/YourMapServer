package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Img;
import bean.User;
import bean.Video;
import exception.UserNotLoginException;
import service.IImgService;
import service.IVideoService;
import service.ValidateService;

public class VideoGet extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//input param
	private Integer sightId;	
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;

	private IVideoService videoService;
	
	private List<Video> videoList;
	@Override
	public String execute() throws Exception {
		
		Set<Object> params = new HashSet<Object>();
		params.add(sightId);
//		params.add(rurl)
		videoList = videoService.getVideoList(sightId);
		return SUCCESS;
	}
	
	public Integer getError_type() {
		return error_type;
	}
	
	public String getError_message() {
		return error_message;
	}
	
	public List<Video> getVideoList() {
		return videoList;
	}
	
	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}
	
	public void setVideoService(IVideoService videoService) {
		this.videoService = videoService;
	}

	
	
}
