package exception;

public class SightNotExistException extends BaseException {
	
	private static final long serialVersionUID = 1L;

	public SightNotExistException(){
		reminder = new WarnReminder();
		reminder.setError_type(201);
		reminder.setError_message("无该景点");
	}

}
