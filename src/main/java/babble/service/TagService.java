package babble.service;

import java.util.List;

import babble.dto.TagDto;

public interface TagService {
	
	List<TagDto> getTagList(Long postId);
	
	void insertTagList(Long postId, List<TagDto> tagList, String password) throws Exception ;

	void updateTagList(Long postId, List<TagDto> tagList, String password) throws Exception ;

}
