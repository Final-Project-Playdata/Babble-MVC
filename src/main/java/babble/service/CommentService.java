package babble.service;

import java.util.List;

import babble.entity.Comment;

public interface CommentService {
	
	List<Comment> getCommentList(Long id);
	
	void insertComment(Comment comment);

	void updateComment(Comment comment);

	void deleteComment(Long id);
}
