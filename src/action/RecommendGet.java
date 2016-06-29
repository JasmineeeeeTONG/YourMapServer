package action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Footprint;
import bean.Img;
import bean.Sight;
import bean.User;
import exception.UserNotLoginException;
import service.IFootprintService;
import service.IImgService;
import service.ISightService;
import service.IUserService;
import service.ValidateService;
import util.Recommend;

public class RecommendGet extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	//return value
	private Integer error_type = 0;
	private String error_message = SUCCESS;

	private List<Sight> sightList;
	
	private IUserService userService;
	private ISightService sightService;
	private IFootprintService footprintService;
	
	@Override
	public String execute() throws Exception {
		
		User user = null;
		HttpSession session = ServletActionContext.getRequest().getSession();
		user = (User) session.getAttribute("user");
		if (user == null) {
			throw new UserNotLoginException();
		}
		
		List<User> users = userService.getAllUser();
		List<Sight> sights = sightService.getAllSight();
		List<Footprint> footprints = footprintService.getAllFootprint();
		
		Recommend recommend = new Recommend(users, sights, footprints);
		
		user.setUserId(user.getUserId() - 1);
		
		List<Integer> sightIdList = recommend.getRecommend(user);
		
		user.setUserId(user.getUserId() + 1);
		
		sightList = new ArrayList<Sight>();
		
		for (Integer sightId : sightIdList) {
			sightId++;
			sightList.add(sightService.getSight(sightId));
		}
		
		return SUCCESS;
	}

	public Integer getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public List<Sight> getSightList() {
		return sightList;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setSightService(ISightService sightService) {
		this.sightService = sightService;
	}

	public void setFootprintService(IFootprintService footprintService) {
		this.footprintService = footprintService;
	}
	
	

}
