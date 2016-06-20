package action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Label;
import bean.Suggestion;
import bean.User;
import exception.UserNotLoginException;
import service.ILabelService;
import service.ISuggestionService;
import service.ValidateService;

public class LabelCreate extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;
	private Integer type;

	private ILabelService labelService;
	
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
		params.add(type);
		ValidateService.ValidateNecessaryArguments(params);
		
		Label label = new Label();
		label.setSightId(sightId);
		label.setUserId(user.getUserId());
		label.setType(type);
		
		labelService.addLabel(label);
		return SUCCESS;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setLabelService(ILabelService labelService) {
		this.labelService = labelService;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

}
