package babble.service;

import java.util.List;

import babble.dto.CommentDto;
import babble.dto.UserDto;

public interface CommentService {

	List<CommentDto> getComments(Long id);

	CommentDto insertComment(CommentDto commentDto, UserDto userDto) throws Exception;

	void updateComment(CommentDto commentDto, String password, String username) throws Exception;

	void deleteComment(Long commentId, Long userId) throws Exception;
}
