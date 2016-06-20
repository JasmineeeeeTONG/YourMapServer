package bean;

public class Label {
	private static final long serialVersionUID = 1L;

	private Integer labelId;
	
	private Integer sightId;
	
	private Integer userId;
	
	private Integer type;

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public Integer getSightId() {
		return sightId;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
