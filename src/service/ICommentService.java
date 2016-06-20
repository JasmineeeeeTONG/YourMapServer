package service;

import java.util.List;

import bean.Comment;

public interface ICommentService {

	void addComment(Comment comment);

	void deleteComment(Comment comment);

	List<Comment> getCommentList(Integer sightId, Integer commentType);
	
}
