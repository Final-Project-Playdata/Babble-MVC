package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

	List<Tag> findByName(String tag);

	void deleteByBabbleId(Long babbleId);

	List<Tag> findTagByBabbleId(Long babbleId);

}
