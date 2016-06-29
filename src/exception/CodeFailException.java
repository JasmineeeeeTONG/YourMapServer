package exception;

public class CodeFailException extends BaseException {
	private static final long serialVersionUID = 1L;

	public CodeFailException(){
		reminder = new WarnReminder();
		reminder.setError_type(410);
		reminder.setError_message("请重新获取code");
	}


}
