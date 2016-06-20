package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Score;
import bean.User;
import exception.UserNotLoginException;
import service.IScoreService;
import service.ValidateService;

public class ScoreListGet extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;

	private IScoreService scoreService;
	
	private List<Score> scoreList;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightId);
		ValidateService.ValidateNecessaryArguments(params);

		scoreList = scoreService.getScoreList(sightId);
		
		return SUCCESS;
	}

	public IScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public List<Score> getScoreList() {
		return scoreList;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}
	
	
}
