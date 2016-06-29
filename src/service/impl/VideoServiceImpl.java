package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Img;
import bean.Video;
import dao.EntityDAO;
import service.IVideoService;

public class VideoServiceImpl implements IVideoService {
	private EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public void addVideo(Video video) {
		// TODO Auto-generated method stub
		entityDAO.save(video);
	}

	@Override
	public List<Video> getVideoList(Integer sightId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		List<Video> videoList = entityDAO.findAll(Video.class, "vid", false, criterions);
		return videoList;
	}

}
