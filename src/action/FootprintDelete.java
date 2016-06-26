package action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Footprint;
import bean.User;
import exception.UserNotLoginException;
import service.IFootprintService;
import service.ValidateService;

public class FootprintDelete extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;
	private Integer footprintType;

	private IFootprintService footprintService;
	
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			throw new UserNotLoginException();
		}
		
		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightId);
		params.add(footprintType);
		ValidateService.ValidateNecessaryArguments(params);
		
		Footprint footprint = new Footprint();
		footprint.setFootprintType(footprintType);
		footprint.setSightId(sightId);
		footprint.setUserId(user.getUserId());
		footprintService.deleteFootprint(footprint);
		
		return SUCCESS;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setFootprintType(Integer footprintType) {
		this.footprintType = footprintType;
	}

	public void setFootprintService(IFootprintService footprintService) {
		this.footprintService = footprintService;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	
}
