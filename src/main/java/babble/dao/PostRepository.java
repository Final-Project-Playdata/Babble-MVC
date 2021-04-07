package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	List<Post> findPostById(Long id);
	
	void deleteByIdAndUserId(Long postId, Long userId);
	
}
