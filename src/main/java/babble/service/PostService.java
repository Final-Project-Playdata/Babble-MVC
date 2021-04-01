package babble.service;

import java.util.List;

import babble.entity.Post;

public interface PostService {
	
	List<Post> getPostList();
	
	Post getPost(Long id);
	
	boolean insertPost(Post post);

	boolean updatePost(Post post);

	boolean deletePost(Long id);
}
