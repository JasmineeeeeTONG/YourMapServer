package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import bean.Sight;
import dao.EntityDAO;
import service.ISightService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SightServiceImpl implements ISightService{
	private EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public Sight getSight(int sightId) {
		// TODO Auto-generated method stub
		Sight sight = (Sight)entityDAO.get(Sight.class, sightId);
		return sight;
	}

	@Override
	public List<Sight> getSightList(Double lng1, Double lat1, Double lng2, Double lat2) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.gt("lat", lat1));
		criterions.add(Restrictions.lt("lat", lat2));
		criterions.add(Restrictions.gt("lng", lng1));
		criterions.add(Restrictions.lt("lng", lng2));
		List<Sight> sightList = entityDAO.findByCriteria(Sight.class, null, false, 0, 0, criterions);
		return sightList;
	}

	@Override
	public List<Sight> getSightListByCoordinateAndSightType(Double lng1, Double lat1, Double lng2, Double lat2, String sightType) {
		// TODO Auto-generated method stub
		String hql = "";
		List<Object> params = new ArrayList<Object>();
		params.add(lng2);
		params.add(lng1);
		params.add(lat2);
		params.add(lat1);
		params.add(sightType);
		hql = "select s from Sight as s , SightType as st "
				+"where s.sightId = st.sightId and s.lng<?"
				+" and s.lng>?"
				+" and s.lat<?"
				+" and s.lng>?"
				+" and st.sightType=?";
		List<Sight> sightList = entityDAO.findByHql(hql, params);
		return sightList;
	}

	@Override
	public List<Sight> getSightListBySightType(List<String> sightType) {
		// TODO Auto-generated method stub
		String hql = "";
		List<Sight> sightList = new ArrayList<Sight>();
		if (sightType.size() == 0) return sightList;
		hql = "select distinct s from Sight as s, SightType as st where s.sightId = st.sightId and (";
		for (int i = 0; i < sightType.size() - 1; i++){
			hql = hql + "st.sightType=" + sightType.get(i) + " or ";
		}
		hql = hql + "st.sightType=" + sightType.get(sightType.size() - 1) + " )";
		sightList = entityDAO.findByHql(hql);
		return sightList;
	}

	@Override
	public Sight getSightBySightName(String sightName) {
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.like("name", sightName, MatchMode.ANYWHERE));
		List<Sight> sights = entityDAO.findByCriteria(Sight.class, "name", false, 0, 1, criterions);
		if (sights.size() == 0)
			return null;
		// TODO Auto-generated method stub
		return sights.get(0);
	}

}
