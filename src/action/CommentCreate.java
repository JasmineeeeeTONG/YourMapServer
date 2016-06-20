package action;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Comment;
import bean.Footprint;
import bean.User;
import exception.UserNotLoginException;
import service.ICommentService;
import service.IFootprintService;
import service.ValidateService;

public class CommentCreate extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;
	private Integer commentType;
	private String commentText;

	private ICommentService commentService;
	
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
		params.add(commentType);
		params.add(commentText);
		ValidateService.ValidateNecessaryArguments(params);
		
		Comment comment = new Comment();
		comment.setCommentText(commentText);
		comment.setCommentType(commentType);
		comment.setSightId(sightId);
		comment.setUser(user);
		
		commentService.addComment(comment);
		
		return SUCCESS;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

}
