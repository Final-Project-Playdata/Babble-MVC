package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findCommentByPost(Long id);
	
	void deleteByIdAndUserId(Long commentId, Long userId);
	
}
