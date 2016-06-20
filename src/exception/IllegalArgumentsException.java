package exception;

public class IllegalArgumentsException extends BaseException {

	private static final long serialVersionUID = 1L;

	public IllegalArgumentsException(){
		reminder = new WarnReminder();
		reminder.setError_type(100);
		reminder.setError_message("参数有误");
	}
}
