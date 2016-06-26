package service;

import java.util.List;

import bean.Score;

public interface IScoreService {

	void addScore(Score score);

	List<Score> getScoreList(Integer sightId);
	
}
