package babble.service;

import java.util.List;

import babble.dto.PostDto;
import babble.dto.UserDto;

public interface PostService {

	List<PostDto> getPostList();

	List<PostDto> getPostListWithTag(String tag);

	PostDto getPost(Long id);

	void insertPost(PostDto postDto, UserDto userDto) throws Exception;

	void updatePost(PostDto postDto, UserDto userDto) throws Exception;

	void deletePost(Long postId, Long userId);

	void insertRetweetPost(PostDto postDto, UserDto userDto) throws Exception;

}
