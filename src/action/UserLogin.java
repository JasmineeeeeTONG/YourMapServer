package action;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Demo;
import bean.User;
import service.IUserService;
import service.ValidateService;


public class UserLogin extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	private User user;
	private IUserService userService;
	
	private int error_type = 100;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		System.out.println("========");
		Set params = new HashSet();
		params.add(userName);
		params.add(password);
		System.out.println(userName);
		System.out.println(password);
		//要求params中内容不为空
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


		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);

		userService.login(u);

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


	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public void setError_type(int error_type) {
		this.error_type = error_type;
	}

	
	
	
	public User getUser() {
		return user;
	}

	public String getError_message() {
		return error_message;
	}

	public int getError_type() {
		return error_type;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
}
