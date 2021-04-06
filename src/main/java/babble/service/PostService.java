package babble.service;

import java.util.List;

import babble.dto.PostDto;

public interface PostService {
	
	List<PostDto> getPostList();
	
	PostDto getPost(Long id);
	
	void insertPost(PostDto post);

	void updatePost(PostDto post);

	void deletePost(Long id);
	
	void insertRetweetPost(Long id, PostDto post);
	
}
