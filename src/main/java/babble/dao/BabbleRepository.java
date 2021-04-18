package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Babble;

public interface BabbleRepository extends JpaRepository<Babble, Long> {

	List<Babble> findPostById(Long id);

	void deleteByIdAndUserId(Long postId, Long userId);

	List<Babble> findByRebabbleId(Long id);

	List<Babble> findByUserId(Long id);

}
