package service;

import java.util.List;

import bean.SightType;

public interface ISightTypeService {
	List<SightType> getSightTypeBySightId(int sightId);
}
