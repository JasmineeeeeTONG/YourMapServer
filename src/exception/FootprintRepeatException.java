package exception;

public class FootprintRepeatException extends BaseException {
	private static final long serialVersionUID = 1L;

	public FootprintRepeatException(){
		reminder = new WarnReminder();
		reminder.setError_type(301);
		reminder.setError_message("操作已进行过");
	}

}
