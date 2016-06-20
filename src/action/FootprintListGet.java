package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Footprint;
import bean.User;
import exception.UserNotLoginException;
import service.IFootprintService;

public class FootprintListGet extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private IFootprintService footprintService;
	
	private String footprintType;
	
	private List<Footprint> footprintList;
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

}
