package exception;

public class FileUploadException extends BaseException {
	private static final long serialVersionUID = 1L;

	public FileUploadException(){
		reminder = new WarnReminder();
		reminder.setError_type(402);
		reminder.setError_message("文件上传失败");
	}

}
