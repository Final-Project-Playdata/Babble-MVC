package babble.service;

import java.util.List;

import babble.dto.PostDto;
import babble.dto.UserDto;

public interface PostService {

	List<PostDto> getPostList();

	List<PostDto> getPostListWithTag(String tag);

	PostDto getPost(Long id);

	void insertPost(PostDto post, UserDto userDto);

	void updatePost(PostDto post, String password) throws Exception;

	void deletePost(Long postId, Long userId);

	void insertRetweetPost(Long id, PostDto post, UserDto userDto);

}
