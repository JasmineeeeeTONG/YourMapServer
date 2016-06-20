package bean;

public class Score implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int scoreId;
	
	private int sightId;
	
	private int userId;
	
	private int point;
	
	private String scoreMsg;

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}

	public int getSightId() {
		return sightId;
	}

	public void setSightId(int sightId) {
		this.sightId = sightId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getScoreMsg() {
		return scoreMsg;
	}

	public void setScoreMsg(String scoreMsg) {
		this.scoreMsg = scoreMsg;
	}
	
	
}
