package service;

import java.util.List;

import bean.Sight;

public interface ISightService {

	Sight getSight(int sightId);

	List<Sight> getSightList(Double lng1, Double lat1, Double lng2, Double lat2);

	List<Sight> getSightListByCoordinateAndSightType(Double lng1, Double lat1, Double lng2, Double lat2, String sightType);

	List<Sight> getSightListBySightType(List<String> sightType);

	Sight getSightBySightName(String sightName);
	
}