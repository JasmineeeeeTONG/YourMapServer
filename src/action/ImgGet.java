package action;

import java.io.File;
import java.util.HashSet;
import java.util.List;
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
import service.ValidateService;
import util.RandomUtil;

public class ImgGet extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//input param
	private Integer sightId;	
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;

	private IImgService imgService;
	
	private List<Img> imgList;
	@Override
	public String execute() throws Exception {
		
		Set<Object> params = new HashSet<Object>();
		params.add(sightId);
//		params.add(rurl)
		imgList = imgService.getImgList(sightId);
		return SUCCESS;
	}
	
	public Integer getError_type() {
		return error_type;
	}
	
	public String getError_message() {
		return error_message;
	}
	
	public List<Img> getImgList() {
		return imgList;
	}
	
	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}
	
	public void setImgService(IImgService imgService) {
		this.imgService = imgService;
	}
	
	

}
