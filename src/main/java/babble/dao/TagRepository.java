package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

	List<Tag> findTagById(Long id);
}
