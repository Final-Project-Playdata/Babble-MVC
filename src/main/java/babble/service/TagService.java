package babble.service;

import java.util.List;

import babble.entity.Tag;

public interface TagService {
	
	List<Tag> getTagList();
	
	Tag getTag(Long id);
	
	boolean insertTag(Tag tag);

	boolean updateTag(Tag tag);

	boolean deleteTag(Long id);
}
