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

public class SuggestionListGetBySightId extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;

	private ISuggestionService suggestionService;
	
	private List<Suggestion> suggestionList;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {

		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightId);
		ValidateService.ValidateNecessaryArguments(params);
		
		suggestionList = suggestionService.getSuggestionListBySightId(sightId);
		return SUCCESS;
	}

	public Integer getSightId() {
		return sightId;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public ISuggestionService getSuggestionService() {
		return suggestionService;
	}

	public void setSuggestionService(ISuggestionService suggestionService) {
		this.suggestionService = suggestionService;
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

}
