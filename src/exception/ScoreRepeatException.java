package exception;

public class ScoreRepeatException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ScoreRepeatException(){
		reminder = new WarnReminder();
		reminder.setError_type(301);
		reminder.setError_message("已评价过该景点");
	}

}
