package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import bean.SightType;
import service.ISightTypeService;
import service.ValidateService;

public class SightTypeCreate extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;

	private ISightTypeService sightTypeService;
	
	private List<SightType> sightTypeList;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {
		Set params = new HashSet();
		//要求params中内容不为空
//		List<String> sightType = new ArrayList<String>();
//		sightType.add("1");
		params.add(sightId);
		System.out.println(999999);
		ValidateService.ValidateNecessaryArguments(params);
		sightTypeList = sightTypeService.getSightTypeBySightId(sightId);
		
		return SUCCESS;
	}

}
