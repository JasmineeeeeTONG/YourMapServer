package action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import bean.Sight;
import service.ISightService;
import service.ValidateService;

public class SightListGetBySightType extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private String sightType;

	private ISightService sightService;
	
	private List<Sight> sightList;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightType);
//		List<String> sightType = new ArrayList<String>();
//		sightType.add("1");
		ValidateService.ValidateNecessaryArguments(params);
		String[] s = sightType.split(",");
		List<String> ss = new ArrayList<String>();
		for (int i = 0; i < s.length; i++) {
			ss.add(s[i]);
		}
		sightList = sightService.getSightListBySightType(ss);
		
		return SUCCESS;
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
