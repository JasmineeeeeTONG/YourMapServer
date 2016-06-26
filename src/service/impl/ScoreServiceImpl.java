package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Score;
import dao.EntityDAO;
import exception.ScoreRepeatException;
import service.IScoreService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ScoreServiceImpl implements IScoreService {

	EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public void addScore(Score score) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", score.getUserId());
		map.put("sightId", score.getSightId());
		if (entityDAO.isAllPropertiesExist(Score.class, map)) {
			throw new ScoreRepeatException();
		}
		entityDAO.save(score);
	}

	@Override
	public List<Score> getScoreList(Integer sightId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		List<Score> scoreList= entityDAO.findAll(Score.class, null, false, criterions);
		return scoreList;
	}

}
