package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.SightType;
import dao.EntityDAO;
import service.ISightTypeService;

public class SightTypeServiceImpl implements ISightTypeService{
	private EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public List<SightType> getSightTypeBySightId(int sightId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));

		List<SightType> sightTypeList = entityDAO.findByCriteria(SightType.class, "sightId", false, 0, 0, criterions);
		return sightTypeList;
	}
	
}
