package exception;


public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/*
	 * 温馨提示
	 */
	protected WarnReminder reminder;
	
	public BaseException(){
	}

	public WarnReminder getReminder() {
		return reminder;
	}

	public void setReminder(WarnReminder reminder) {
		this.reminder = reminder;
	}
}
