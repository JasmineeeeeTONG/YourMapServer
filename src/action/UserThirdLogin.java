package action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import exception.CodeFailException;
import exception.IllegalArgumentsException;
import service.IUserService;
import service.ValidateService;
import util.Client;

public class UserThirdLogin extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String code;
	
	private IUserService userService;

	private User user;
	
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {

		Set params = new HashSet();
		//要求params中内容不为空
		params.add(code);
		ValidateService.ValidateNecessaryArguments(params);

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();

		// session池，全局变量，包含每个登录用户的sesssion
		Map<Integer, HttpSession> sessionPool = (Map<Integer, HttpSession>) application
				.getAttribute("sessionPool");

		// 如果为空，则新建
		if (sessionPool == null) {
			sessionPool = new HashMap<Integer, HttpSession>();
		}
		
		
		String token = Client.sendSMSS(code);
		if (token.length() != 40) throw new IllegalArgumentsException();
		System.out.println();
		User u = new User();
		
		JSONObject x = new JSONObject(Client.sendSMS(token));
		if (x.has("login") == false) {
			throw new CodeFailException();
		}
	
		u.setAccount(x.getString("login"));
		u.setType("github");
		
		if (userService.ifExsitUser(u) == false) {
			u.setUsername("github_" + u.getAccount());
			u.setPassword("000000");
			u.setHeadImg("headImg/1.jpg");
			userService.addThirdUser(u);
		}
		else {
			u.setPassword("000000");
			u = userService.login(u);
		}
		
		user = u;
		Integer userID = u.getUserId();
		
		if (sessionPool.containsKey(userID)) {
			HttpSession se = sessionPool.get(userID);
			if (se != null && !se.getId().equals(session.getId())) {

				// 移除全局变量池中原先登录用户的信息
				sessionPool.remove(userID);
			}
		}

		session.setAttribute("user", u);
		sessionPool.put(userID, session);
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	

}
