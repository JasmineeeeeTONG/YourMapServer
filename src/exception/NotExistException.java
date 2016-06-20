package exception;

public class NotExistException extends BaseException {
	private static final long serialVersionUID = 1L;

	public NotExistException(){
		reminder = new WarnReminder();
		reminder.setError_type(401);
		reminder.setError_message("该项内容并不存在");
	}

}
