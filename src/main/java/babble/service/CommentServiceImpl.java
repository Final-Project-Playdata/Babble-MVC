package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository dao;

	public List<Comment> getCommentList(Long id) {
		try {
			return dao.findCommentByPost(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void insertComment(Comment Comment) {
		try {
			Comment.setRegDate(LocalDateTime.now());
			dao.save(Comment);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateComment(Comment comment) {
		try {
			Comment findComment = dao.findById(comment.getId()).get();
			findComment.setFileURL(comment.getFileURL());
			findComment.setModDate(LocalDateTime.now());
			dao.save(findComment);

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
