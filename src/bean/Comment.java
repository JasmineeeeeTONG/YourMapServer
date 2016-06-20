package bean;

public class Comment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int commentId;
	
	private int sightId;
	
	private User user;
	
	private Integer commentType;
	
	private String commentText;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getSightId() {
		return sightId;
	}

	public void setSightId(int sightId) {
		this.sightId = sightId;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public Integer getCommentType() {
		return commentType;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
}
