package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.CommentRepository;
import babble.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository dao;

	public List<Comment> getCommentsList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Comment getComments(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertComments(Comment Comments) {
		try {
			Comments.setRegDate(new Date());
			dao.save(Comments);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateComments(Comment comments) {
		try {
			Comment findComment = dao.findById(comments.getId()).get();
			findComment.setFileURL(comments.getFileURL());
			findComment.setRegDate(new Date());
			dao.save(findComment);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteComments(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
