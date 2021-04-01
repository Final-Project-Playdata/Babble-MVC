package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long>{

	List<Follow> findFollowById(Long id);
}
