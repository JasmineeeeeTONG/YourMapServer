package action;

import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import bean.Sight;
import exception.SightNotExistException;
import service.ISightService;
import service.ValidateService;

public class SightGet extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;

	private ISightService sightService;
	
	private Sight sight;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightId);
		ValidateService.ValidateNecessaryArguments(params);

		sight = sightService.getSight(sightId);
		
		if (sight == null) {
			throw new SightNotExistException();
		}
		return SUCCESS;
	}

	public Sight getSight() {
		return sight;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setSightId(int sightId) {
		this.sightId = sightId;
	}

	public void setSightService(ISightService sightService) {
		this.sightService = sightService;
	}
	
	

}
