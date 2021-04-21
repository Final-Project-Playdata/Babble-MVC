package babble.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.dto.CommentDto;
import babble.dto.UserDto;
import babble.entity.Comment;
import babble.mapper.CommentMapper;
import babble.util.AudioUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentDao;

	private final CommentMapper commentMapper;

	private final AudioUtil audioUtil;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public CommentDto insertComment(CommentDto commentDto, UserDto userDto) throws Exception {
		try {
			if (audioUtil.checkPath(commentDto.getFileUrl(), userDto.getUsername())) {
				commentDto.setUser(userDto);
				commentDto.setRegDate(LocalDateTime.now());
				Comment comment = commentDao.save(commentMapper.toEntity(commentDto));
				logger.info("inserComment : {}", commentDto);
				return commentMapper.toDto(comment);
			} else {
				logger.info("inserComment fail : {}", commentDto);
				throw new Exception("저장실패");
			}
		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	@Transactional
	public void deleteComment(Long commentId, Long userId) {
		try {
			commentDao.deleteByIdAndUserId(commentId, userId);
			logger.info("deleteComment : {} - {}", commentId, userId);
		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

}
