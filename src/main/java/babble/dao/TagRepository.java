package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

	List<Tag> findTagByPostId(Long postId);
	List<Tag> findByName(String tag);
	void deleteByPostId(Long postId);
}
