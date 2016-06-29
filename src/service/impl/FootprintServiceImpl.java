package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Footprint;
import dao.EntityDAO;
import exception.FootprintRepeatException;
import exception.ScoreRepeatException;
import service.IFootprintService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class FootprintServiceImpl implements IFootprintService{

	EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public void addFootprint(Footprint footprint) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", footprint.getUserId());
		map.put("sightId", footprint.getSightId());
		map.put("footprintType", footprint.getFootprintType());
		if (entityDAO.isAllPropertiesExist(Footprint.class, map)) {
			throw new FootprintRepeatException();
		}
		entityDAO.save(footprint);
		
	}

	@Override
	public void deleteFootprint(Footprint footprint) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", footprint.getSightId()));
		criterions.add(Restrictions.eq("userId", footprint.getUserId()));
		criterions.add(Restrictions.eq("footprintType", footprint.getFootprintType()));
		entityDAO.deleteByCriteria(Footprint.class, criterions);
	}

	@Override
	public List<Footprint> getFootprintList(int userId, String footprintType) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("userId", userId));
		criterions.add(Restrictions.eq("footprintType", Integer.parseInt(footprintType)));	
		List<Footprint> footprintList = entityDAO.findAll(Footprint.class, "footprintId", false, criterions);
		return footprintList;
	}

	@Override
	public List<Footprint> getAllFootprint() {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		List<Footprint> footprintList = entityDAO.findAll(Footprint.class, "footprintId", false, criterions);
		return footprintList;
	}

}
