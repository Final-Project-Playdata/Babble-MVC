package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.dao.BabbleRepository;
import babble.dao.UserRepository;
import babble.dto.CommentDto;
import babble.dto.UserDto;
import babble.entity.Comment;
import babble.exception.UserNotMatchException;
import babble.mapper.CommentMapper;
import babble.util.AudioUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentDao;
	private final UserRepository userDao;
	private final BabbleRepository postDao;

	private final CommentMapper commentMapper;

	private final AudioUtil audioUtil;

	public List<CommentDto> getComments(Long id) {
		try {
			return commentMapper.toDtoList(commentDao.findByBabbleId(id));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public CommentDto insertComment(CommentDto commentDto, UserDto userDto) throws Exception {
		try {
			if (audioUtil.checkPath(commentDto.getFileUrl(), userDto.getUsername())) {
				commentDto.setUser(userDto);
				commentDto.setRegDate(LocalDateTime.now());
				Comment comment = commentDao.save(commentMapper.toEntity(commentDto));
				return commentMapper.toDto(comment);
			} else {
				throw new Exception("저장실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateComment(CommentDto commentDto, String password, String username) throws Exception {
		try {
			String findPassword = userDao.findPasswordById(commentDto.getUser().getId());

			if (findPassword.equals(password)) {
				if (audioUtil.checkPath(commentDto.getFileUrl(), username)) {
					commentDto.setModDate(LocalDateTime.now());
					commentDao.save(commentMapper.toEntity(commentDto));
				} else {
					throw new Exception("저장실패");
				}
			} else {
				throw new UserNotMatchException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public void deleteComment(Long commentId, Long userId) {
		try {
			commentDao.deleteByIdAndUserId(commentId, userId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteComments(Long babbleId, Long userId) {
		try {
			if (postDao.findById(babbleId).get().getUser().getId() == userId) {
				commentDao.deleteByBabbleId(babbleId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
