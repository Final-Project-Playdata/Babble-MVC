package babble.service;

import java.util.List;

import babble.dto.CommentDto;

public interface CommentService {
	
	List<CommentDto> getCommentList(Long id);
	
	void insertComment(CommentDto commentDto);

	void updateComment(CommentDto commentDto);

	void deleteComment(Long id);
}
