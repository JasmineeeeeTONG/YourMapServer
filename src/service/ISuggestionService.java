package service;

import java.util.List;

import bean.Suggestion;

public interface ISuggestionService {

	void addSuggestion(Suggestion suggestion);
	
	List<Suggestion> getSuggestionListBySightId(Integer sightId);

	List<Suggestion> getSuggestionListBySightIdAndUserId(Integer sightId, Integer userId);
	
}
