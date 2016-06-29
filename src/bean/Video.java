package bean;

public class Video implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int vid;
	
	private int sightId;
	
	private String url;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getSightId() {
		return sightId;
	}

	public void setSightId(int sightId) {
		this.sightId = sightId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	
}