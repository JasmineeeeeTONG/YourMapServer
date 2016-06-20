package action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import bean.Label;
import bean.Suggestion;
import service.ILabelService;
import service.ISuggestionService;
import service.ValidateService;

public class LabelListGetBySightId extends ActionSupport{
	private static final long serialVersionUID = 1L;

	private Integer sightId;

	private ILabelService labelService;
	
	private List<Label> labelList;
	private int error_type = 0;
	private String error_message = "success";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String execute() {

		Set params = new HashSet();
		//要求params中内容不为空
		params.add(sightId);
		ValidateService.ValidateNecessaryArguments(params);
		
		labelList = labelService.getLabelListBySightId(sightId);
		return SUCCESS;
	}

	public List<Label> getLabelList() {
		return labelList;
	}

	public int getError_type() {
		return error_type;
	}

	public String getError_message() {
		return error_message;
	}

	public void setSightId(Integer sightId) {
		this.sightId = sightId;
	}

	public void setLabelService(ILabelService labelService) {
		this.labelService = labelService;
	}

	
}
