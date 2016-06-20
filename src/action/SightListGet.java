package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import bean.Sight;
import service.ISightService;
import service.ValidateService;

public class SightListGet extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Double lng1;
	private Double lat1;
	private Double lng2;
	private Double lat2;
	private String sightType;

	private ISightService sightService;
	
	private List<Sight> sightList;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		Set params = new HashSet();
		//要求params中内容不为空
		params.add(lat1);
		params.add(lat2);
		params.add(lng1);
		params.add(lng2);
		ValidateService.ValidateNecessaryArguments(params);

		if (sightType == null || sightType.isEmpty()) {
			System.out.println(sightService);
			sightList = sightService.getSightList(lng1, lat1, lng2, lat2);			
		}
		else {
			sightList = sightService.getSightListByCoordinateAndSightType(lng1, lat1, lng2, lat2, sightType);
		}
		
		return SUCCESS;
	}

	
	
	public void setLng1(Double lng1) {
		this.lng1 = lng1;
	}



	public void setLat1(Double lat1) {
		this.lat1 = lat1;
	}



	public void setLng2(Double lng2) {
		this.lng2 = lng2;
	}



	public void setLat2(Double lat2) {
		this.lat2 = lat2;
	}



	public void setSightType(String sightType) {
		this.sightType = sightType;
	}
	
	public void setSightService(ISightService sightService) {
		this.sightService = sightService;
	}

	public List<Sight> getSightList() {
		return sightList;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}
	
	

}
