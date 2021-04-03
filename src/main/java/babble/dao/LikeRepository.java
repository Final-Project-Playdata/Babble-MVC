package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long>{

	List<Like> findLikesById(Long id);
}
