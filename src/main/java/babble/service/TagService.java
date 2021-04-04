package babble.service;

import java.util.List;

import babble.entity.Tag;

public interface TagService {
	
	List<Tag> getTagList(Long postId);
	
	void insertTagList(Long postId, List<Tag> tagList);

	void updateTagList(Long postId, List<Tag> tagList);

}
