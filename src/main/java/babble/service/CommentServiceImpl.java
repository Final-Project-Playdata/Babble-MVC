package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.dto.CommentDto;
import babble.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository dao;

	private final CommentMapper mapper;

	public List<CommentDto> getCommentList(Long id) {
		try {
			return mapper.toDtoList(dao.findCommentByPost(id));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void insertComment(CommentDto commentDto) {
		try {
			commentDto.setRegDate(LocalDateTime.now());
			dao.save(mapper.toEntity(commentDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateComment(CommentDto commentDto) {
		try {
			commentDto.setModDate(LocalDateTime.now());
			dao.save(mapper.toEntity(commentDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteComment(Long id) {
		try {
			dao.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
