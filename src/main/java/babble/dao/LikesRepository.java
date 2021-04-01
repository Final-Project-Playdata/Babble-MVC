package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Follow;
import babble.entity.Likes;

public interface LikesRepository extends JpaRepository<Likes, Long>{

	List<Likes> findLikesById(Long id);
}
