package exception;

public class UserRepeatException extends BaseException{
	
	private static final long serialVersionUID = 1L;

	public UserRepeatException(){
		reminder = new WarnReminder();
		reminder.setError_type(102);
		reminder.setError_message("用户名或密码已存在！");
	}

}
