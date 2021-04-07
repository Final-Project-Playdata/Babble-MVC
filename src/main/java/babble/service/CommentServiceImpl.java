package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.dao.UserRepository;
import babble.dto.CommentDto;
import babble.dto.UserDto;
import babble.exception.UserNotMatchException;
import babble.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentDao;

	private final UserRepository userDao;

	private final CommentMapper commentMapper;

	public List<CommentDto> getCommentList(Long id) {
		try {
			return commentMapper.toDtoList(commentDao.findCommentByPost(id));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void insertComment(CommentDto commentDto, UserDto userDto) {
		try {
			commentDto.setUser(userDto);
			commentDto.setRegDate(LocalDateTime.now());
			commentDao.save(commentMapper.toEntity(commentDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateComment(CommentDto commentDto, String password) throws Exception {
		try {
			String findPassword = userDao.findPasswordById(commentDto.getUser().getId());

			if (findPassword.equals(password)) {
				commentDto.setModDate(LocalDateTime.now());
				commentDao.save(commentMapper.toEntity(commentDto));

			} else {
				throw new UserNotMatchException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteComment(Long commentId, Long userId) {
		try {
			commentDao.deleteByIdAndUserId(commentId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
