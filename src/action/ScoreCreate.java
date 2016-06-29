package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Score;
import bean.Sight;
import bean.User;
import exception.IllegalArgumentsException;
import exception.NotExistException;
import exception.UserNotLoginException;
import service.IScoreService;
import service.ISightService;
import service.ValidateService;

public class ScoreCreate extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;
	private Integer point;
	private String scoreMsg;

	private IScoreService scoreService;
	private ISightService sightService;
	
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
		params.add(point);
		ValidateService.ValidateNecessaryArguments(params);
		if (point < 0 || point > 5) {
			throw new IllegalArgumentsException();
		}
		
		Score score = new Score();
		score.setScoreMsg(scoreMsg);
		score.setUserId(user.getUserId());
		score.setPoint(point);
		score.setSightId(sightId);
		Sight sight = sightService.getSight(score.getSightId());
		if (sight == null) {
			throw new NotExistException();
		}
		scoreService.addScore(score);
		
		
		List<Score> scores = scoreService.getScoreList(sightId);
		
		int total = 0;
		
		for (int i = 0; i < scores.size(); i++) {
			Score s = scores.get(i);
			total = s.getPoint() + total;
		}
		
		double d = (double)(total) / (double)(scores.size());
		
		sight.setAvgScore(d);
		
		sightService.updateSight(sight);
		
		return SUCCESS;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public void setScoreMsg(String scoreMsg) {
		this.scoreMsg = scoreMsg;
	}

	public void setScoreService(IScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setSightService(ISightService sightService) {
		this.sightService = sightService;
	}
	
	
	
}
