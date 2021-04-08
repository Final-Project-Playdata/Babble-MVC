package babble.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import babble.dto.PostDto;
import babble.dto.UserDto;

public interface PostService {

	List<PostDto> getPostList();

	List<PostDto> getPostListWithTag(String tag);

	PostDto getPost(Long id);

	void insertPost(MultipartFile file, String post, UserDto userDto) throws Exception;

	void updatePost(PostDto post, String password) throws Exception;

	void deletePost(Long postId, Long userId);

	void insertRetweetPost(Long id, PostDto post, UserDto userDto);

}
