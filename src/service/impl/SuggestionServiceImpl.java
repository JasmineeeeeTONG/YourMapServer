package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Score;
import bean.Suggestion;
import bean.User;
import dao.EntityDAO;
import exception.LoginFailException;
import exception.RepeatException;
import service.ISuggestionService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SuggestionServiceImpl implements ISuggestionService{
	EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}


	@Override
	public void addSuggestion(Suggestion suggestion) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", suggestion.getUserId());
		map.put("sightId", suggestion.getSightId());
		map.put("type", suggestion.getType());
		if (entityDAO.isAllPropertiesExist(Suggestion.class, map)) {
			throw new RepeatException();
		}
		entityDAO.save(suggestion);
	}


	@Override
	public List<Suggestion> getSuggestionListBySightId(Integer sightId) {
		// TODO Auto-generated method stub
		String sql = "";
		List<Suggestion> suggestionList = new ArrayList<Suggestion>();

		sql = "select a.* from suggestion a,(select distinct max(suggestion_id) as suggestion_id from suggestion group by type) b where a.suggestion_id=b.suggestion_id and a.sight_id=" + sightId;
		suggestionList = (List<Suggestion>) entityDAO.findBySql(sql);
		return suggestionList;
	}


	@Override
	public List<Suggestion> getSuggestionListBySightIdAndUserId(Integer sightId, Integer userId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		criterions.add(Restrictions.eq("userId", userId));
		List<Suggestion> suggestionList= entityDAO.findAll(Suggestion.class, null, false, criterions);
		return suggestionList;
	}

}
