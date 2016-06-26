package bean;

public class Footprint implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int footprintId;
	
	private int sightId;
	
	private int userId;
	
	private Integer footprintType;

	public int getFootprintId() {
		return footprintId;
	}

	public void setFootprintId(int footprintId) {
		this.footprintId = footprintId;
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

	public Integer getFootprintType() {
		return footprintType;
	}

	public void setFootprintType(Integer footprintType) {
		this.footprintType = footprintType;
	}

	
}
