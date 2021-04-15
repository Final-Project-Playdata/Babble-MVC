package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long>{

	List<Like> findByPostId(Long postId);
	
	void deleteByPostIdAndUserId(Long postId, Long userId);

	void deleteByPostId(Long postId);

	List<Like> findByUserId(Long userId);
	
}
