package babble.service;

import java.util.List;

import babble.dto.CommentDto;
import babble.dto.UserDto;

public interface CommentService {

	List<CommentDto> getCommentList(Long id);

	void insertComment(CommentDto commentDto, UserDto userDto);

	void updateComment(CommentDto commentDto, String password) throws Exception;

	void deleteComment(Long commentId, Long userId);
}
