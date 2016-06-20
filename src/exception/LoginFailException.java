package exception;

public class LoginFailException extends BaseException{

	private static final long serialVersionUID = 1L;

	public LoginFailException(){
		reminder = new WarnReminder();
		reminder.setError_type(100);
		reminder.setError_message("login_fail_error");
	}
	
}
