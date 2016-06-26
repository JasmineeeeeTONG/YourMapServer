package bean;

public class Suggestion {
	private static final long serialVersionUID = 1L;

	private Integer suggestionId;
	
	private Integer sightId;
	
	private Integer userId;
	
	private Integer type;

	public Integer getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(Integer suggestionId) {
		this.suggestionId = suggestionId;
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
