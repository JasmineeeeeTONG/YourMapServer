package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Comment;
import bean.Img;
import dao.EntityDAO;
import service.IImgService;

public class ImgServiceImpl implements IImgService {
	EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public void addImg(Img img) {
		// TODO Auto-generated method stub
		entityDAO.save(img);
	}

	@Override
	public List<Img> getImgList(Integer sightId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		List<Img> imgList = entityDAO.findAll(Img.class, "imgId", false, criterions);
		return imgList;

	}

}
