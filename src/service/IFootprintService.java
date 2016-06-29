package service;

import java.util.List;

import bean.Footprint;

public interface IFootprintService {

	void addFootprint(Footprint footprint);

	void deleteFootprint(Footprint footprint);

	List<Footprint> getFootprintList(int userId, String footprintType);

	List<Footprint> getAllFootprint();
	
}
