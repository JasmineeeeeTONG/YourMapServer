package bean;

public class Sight implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private int sightId;
	
	private double lng;
	
	private double lat;
	
	private String sightName;
	
	private String description;
	
	private String detail;
	
	private String sightImg;
	
	private double sightScoreAvg;

	public int getSightId() {
		return sightId;
	}

	public void setSightId(int sightId) {
		this.sightId = sightId;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getSightName() {
		return sightName;
	}

	public void setSightName(String sightName) {
		this.sightName = sightName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getSightImg() {
		return sightImg;
	}

	public void setSightImg(String sightImg) {
		this.sightImg = sightImg;
	}

	public double getSightScoreAvg() {
		return sightScoreAvg;
	}

	public void setSightScoreAvg(double sightScoreAvg) {
		this.sightScoreAvg = sightScoreAvg;
	}
	
}
