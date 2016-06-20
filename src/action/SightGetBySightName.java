package action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import bean.Sight;
import exception.NotExistException;
import service.ISightService;
import service.ValidateService;

public class SightGetBySightName extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String sightName;

	private ISightService sightService;
	
	private Sight sight;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightName);
//		List<String> sightType = new ArrayList<String>();
//		sightType.add("1");
		ValidateService.ValidateNecessaryArguments(params);
		sight = sightService.getSightBySightName(sightName);
		if (sight == null) {
			throw new NotExistException();
		}
		
		return SUCCESS;
	}

	public void setSightName(String sightName) {
		this.sightName = sightName;
	}

	public void setSightService(ISightService sightService) {
		this.sightService = sightService;
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

}
