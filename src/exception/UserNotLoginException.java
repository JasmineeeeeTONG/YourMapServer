package exception;

public class UserNotLoginException extends BaseException{

	
	private static final long serialVersionUID = 1L;

	public UserNotLoginException(){
		reminder = new WarnReminder();
		reminder.setError_type(101);
		reminder.setError_message("请先登录！");
	}

}
