package bean;

public class Img implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int imgId;
	
	private int sightId;
	
	private String url;

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
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
