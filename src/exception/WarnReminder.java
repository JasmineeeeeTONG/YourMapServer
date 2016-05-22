package exception;

import java.io.Serializable;

/**
 * 温馨提示类
 * @author tom
 * @since 2014-06-7
 */
public class WarnReminder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer error_type;
	private String error_message;
	
	public Integer getError_type() {
		return error_type;
	}
	public void setError_type(Integer error_type) {
		this.error_type = error_type;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
}
