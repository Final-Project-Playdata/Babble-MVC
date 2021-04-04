package babble.service;

import java.util.List;

import babble.entity.Post;

public interface PostService {
	
	List<Post> getPostList();
	
	Post getPost(Long id);
	
	void insertPost(Post post);

	void updatePost(Post post);

	void deletePost(Long id);
}
