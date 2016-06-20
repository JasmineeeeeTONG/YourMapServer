package exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 异常拦截器，统一处理
 * 
 * @author tom
 * @since 2014-06-07
 */

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	private static final String JAVA_EXCEPTION = "java_exception";
	private static final String BUSINESS_EXCEPTION = "business_exception";
	private static final int SYSTEM_EXCEPTION_CODE = 500;
	private static final String SYSTEM_EXCEPTION = "system exception";

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		String result = "success";
		try {
			result = ai.invoke();
		} catch (Exception e) {
			result = BUSINESS_EXCEPTION; // 先设置为业务异常，如果捕获到非业务异常，则重设
			WarnReminder reminder = new WarnReminder();
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			if (e instanceof BaseException) {
				reminder = ((BaseException) e).getReminder();
				session.setAttribute("reminder", reminder);
			} else {
				reminder.setError_type(SYSTEM_EXCEPTION_CODE);
				reminder.setError_message(SYSTEM_EXCEPTION);
				session.setAttribute("reminder", reminder);
				e.printStackTrace();
				StringWriter out = new StringWriter();
				e.printStackTrace(new PrintWriter(out));
				result = JAVA_EXCEPTION;
			}
		}
		return result;
	}

}
