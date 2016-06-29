package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

import exception.WarnReminder;


public class WarnReminderOutput extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 返回值
	private Integer error_type = 103;
	private String error_message = "error";

	@Override
	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		WarnReminder reminder = (WarnReminder) session.getAttribute("reminder");
		error_type = reminder.getError_type();
		error_message = reminder.getError_message();
		return "success";
	}

	public Integer getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_type(Integer error_type) {
		this.error_type = error_type;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

}
