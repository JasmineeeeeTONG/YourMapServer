package service;

import java.util.List;

import bean.Label;
import bean.Suggestion;

public interface ILabelService {

	void addLabel(Label label);

	List<Label> getLabelListBySightId(Integer sightId);

	List<Label> getLabelListBySightIdAndUserId(Integer sightId, Integer userId);
}
