package bean;

public class SightType implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int sightTypeId;
	
	private int sightId;
	
	private String sightType;

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

	public String getSightType() {
		return sightType;
	}

	public void setSightType(String sightType) {
		this.sightType = sightType;
	}

}
