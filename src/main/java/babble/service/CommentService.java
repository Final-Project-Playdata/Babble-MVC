package babble.service;

import babble.dto.CommentDto;
import babble.dto.UserDto;

public interface CommentService {

	CommentDto insertComment(CommentDto commentDto, UserDto userDto) throws Exception;

	void deleteComment(Long commentId, Long userId) throws Exception;
	
}
