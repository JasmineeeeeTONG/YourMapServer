package bean;

public class SightType implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int sightTypeId;
	
	private int sightId;
	
	private String sightTypeText;

	public int getSightTypeId() {
		return sightTypeId;
	}

	public void setSightTypeId(int sightTypeId) {
		this.sightTypeId = sightTypeId;
	}

	public int getSightId() {
		return sightId;
	}

	public void setSightId(int sightId) {
		this.sightId = sightId;
	}

	public String getSightTypeText() {
		return sightTypeText;
	}

	public void setSightTypeText(String sightTypeText) {
		this.sightTypeText = sightTypeText;
	}
}
