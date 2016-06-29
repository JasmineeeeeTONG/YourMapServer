package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Comment;
import bean.Footprint;
import dao.EntityDAO;
import exception.FootprintRepeatException;
import exception.NotExistException;
import service.ICommentService;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommentServiceImpl implements ICommentService{

	EntityDAO entityDAO;

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

	@Override
	public void addComment(Comment comment) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		entityDAO.save(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", comment.getUser());
		map.put("sightId", comment.getSightId());
		map.put("commentType", comment.getCommentType());
		Comment c = (Comment)entityDAO.findUniqueByProperties(Comment.class, map);
		if (c == null) {
			throw new NotExistException();
		}
		entityDAO.delete(c);
	}

	@Override
	public List<Comment> getCommentList(Integer sightId, Integer commentType) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		criterions.add(Restrictions.eq("commentType", commentType));	
		List<Comment> commentList = entityDAO.findAll(Comment.class, "commentId", false, criterions);
		return commentList;
	}

	@Override
	public List<Comment> getCommentList(Integer sightId, Integer commentType, int userId) {
		// TODO Auto-generated method stub
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("sightId", sightId));
		criterions.add(Restrictions.eq("commentType", commentType));	
		criterions.add(Restrictions.eq("userId", userId));			
		List<Comment> commentList = entityDAO.findAll(Comment.class, "commentId", false, criterions);
		return commentList;
	}

}
