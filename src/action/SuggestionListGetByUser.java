package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Suggestion;
import bean.User;
import exception.UserNotLoginException;
import service.ISuggestionService;
import service.ValidateService;

public class SuggestionListGetByUser extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;

	private ISuggestionService suggestionService;
	
	private List<Suggestion> suggestionList;
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
		ValidateService.ValidateNecessaryArguments(params);
		
		suggestionList = suggestionService.getSuggestionListBySightIdAndUserId(sightId, user.getUserId());
		return SUCCESS;
	}

	public List<Suggestion> getSuggestionList() {
		return suggestionList;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setSuggestionService(ISuggestionService suggestionService) {
		this.suggestionService = suggestionService;
	}

}
