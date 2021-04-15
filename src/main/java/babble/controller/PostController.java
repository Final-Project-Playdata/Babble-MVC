package babble.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.PostDto;
import babble.mapper.UserMapper;
import babble.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostServiceImpl service;

	private final UserMapper userMapper;

	@PostMapping("post")
	public PostDto insertPost(@RequestBody PostDto postDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		return service.insertPost(postDto, userMapper.toDto(p.getUser()));
	}

	@DeleteMapping("post/{id}")
	public void deletePost(@PathVariable("id") Long postId, @AuthenticationPrincipal PrincipalDetails p) {
		service.deletePost(postId, p.getUser().getId());
	}

	@PutMapping("post/{id}")
	public PostDto updatePost(@RequestBody PostDto postDto, @AuthenticationPrincipal PrincipalDetails p) throws Exception {
		return service.updatePost(postDto, userMapper.toDto(p.getUser()));
	}

	@GetMapping("post/{id}")
	public PostDto getPost(@PathVariable("id") Long postId) {
		return service.getPost(postId);
	}

	@GetMapping("posts")
	public List<PostDto> getPostList() {
		return service.getPostList();
	}

	// 특정 태그가 들어있는 포스트만 반환
	@GetMapping("posts/{tag}")
	public List<PostDto> getPostListWithTag(@PathVariable("tag") String tag) {
		return service.getPostListWithTag(tag);
	}

	// 리트윗 기능
	@PostMapping("retweet")
	public PostDto insertRetweetPost(@RequestBody PostDto postDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		return service.insertRetweetPost(postDto, userMapper.toDto(p.getUser()));
	}

}
