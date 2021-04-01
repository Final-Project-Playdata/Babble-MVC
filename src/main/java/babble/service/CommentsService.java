package babble.service;

import java.util.List;

import babble.entity.Comments;

public interface CommentsService {
	
	List<Comments> getCommentsList();
	
	Comments getComments(Long id);
	
	boolean insertComments(Comments comments);

	boolean updateComments(Comments comments);

	boolean deleteComments(Long id);
}
