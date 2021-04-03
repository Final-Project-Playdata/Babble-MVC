package babble.service;

import java.util.List;

import babble.entity.Comment;

public interface CommentService {
	
	List<Comment> getCommentsList();
	
	Comment getComments(Long id);
	
	boolean insertComments(Comment comments);

	boolean updateComments(Comment comments);

	boolean deleteComments(Long id);
}
