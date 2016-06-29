
package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Label;
import bean.Suggestion;
import dao.EntityDAO;
import exception.RepeatException;
import service.ILabelService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LabelServiceImpl implements ILabelService{
	EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public void addLabel(Label label) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", label.getUserId());
		map.put("sightId", label.getSightId());
		map.put("type", label.getType());
		if (entityDAO.isAllPropertiesExist(Label.class, map)) {
			throw new RepeatException();
		}
		entityDAO.save(label);

	}

	@Override
	public List<Label> getLabelListBySightId(Integer sightId) {
		// TODO Auto-generated method stub
		String sql = "";
		List<Label> labelList = new ArrayList<Label>();

		sql = "select a.* from label a,(select distinct max(label_id) as label_id from label where label.sight_id = " + sightId + " group by type) b where a.label_id=b.label_id and a.sight_id=" + sightId;
		System.out.println(sql);
		labelList = (List<Label>) entityDAO.findBySql(sql);
		return labelList;
	}

	@Override
	public List<Label> getLabelListBySightIdAndUserId(Integer sightId, Integer userId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		criterions.add(Restrictions.eq("userId", userId));
		List<Label> labelList= entityDAO.findAll(Label.class, null, false, criterions);
		return labelList;
	}

}
