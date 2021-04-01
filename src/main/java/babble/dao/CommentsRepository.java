package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Comments;
import babble.entity.Follow;

public interface CommentsRepository extends JpaRepository<Comments, Long>{

	List<Comments> findCommentsById(Long id);
}
