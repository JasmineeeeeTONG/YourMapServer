package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.User;
import exception.UserNotLoginException;


/**
 * 
 * ClassName: Login
 * 
 * @Description: 登录
 * 
 * @author xurisun
 * 
 * @date 2015-4-8
 */
public class UserLogout extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int error_type = 0;
	private String error_message = "success";

	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		if (user != null) {

			session.removeAttribute("user");

			return SUCCESS;
		}
		else {
			throw new UserNotLoginException();
		}
		// session池，全局变量，包含每个登录用户的sesssion

	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public Integer getError_type() {
		return error_type;
	}

	public void setError_type(Integer error_type) {
		this.error_type = error_type;
	}

}
