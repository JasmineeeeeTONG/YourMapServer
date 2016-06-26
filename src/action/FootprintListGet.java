package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Footprint;
import bean.Sight;
import bean.User;
import exception.UserNotLoginException;
import service.IFootprintService;
import service.ISightService;

public class FootprintListGet extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private IFootprintService footprintService;
	private ISightService sightService;
	
	private String footprintType;
	
	private List<Footprint> footprintList;
	private List<Sight> sightList;
	private int error_type = 0;
	private String error_message = "success";

	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			throw new UserNotLoginException();
		}
		footprintList = footprintService.getFootprintList(user.getUserId(), footprintType);
		sightList = new ArrayList<Sight>();
		for (int i = 0; i < footprintList.size(); i++) {
			sightList.add(sightService.getSight(footprintList.get(i).getSightId()));
		}
		return SUCCESS;
	}

	public void setFootprintService(IFootprintService footprintService) {
		this.footprintService = footprintService;
	}

	public void setFootprintType(String footprintType) {
		this.footprintType = footprintType;
	}

	public List<Footprint> getFootprintList() {
		return footprintList;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public List<Sight> getSightList() {
		return sightList;
	}

	public void setSightService(ISightService sightService) {
		this.sightService = sightService;
	}

}
