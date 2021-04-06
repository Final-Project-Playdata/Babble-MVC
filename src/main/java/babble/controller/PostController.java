package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.dto.PostDto;
import babble.service.PostServiceImpl;

@RestController
public class PostController {

	@Autowired
	private PostServiceImpl service;

	@PostMapping("post")
	public void insertPost(@RequestBody PostDto postDto) {
		service.insertPost(postDto);
	}

	@DeleteMapping("post/{id}")
	public void deletePost(@PathVariable("id") Long postId) {
		service.deletePost(postId);
	}

	@PutMapping("post/{id}")
	public void updatePost(@RequestBody PostDto postDto) {
		service.updatePost(postDto);
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
	@GetMapping("posts/tag")
	public List<PostDto> getPostListWithTag(@PathVariable("tag") String tag) {
		return service.getPostListWithTag(tag);
	}
	
	//리트윗 기능
	@PostMapping("post/{id}/retweet")
	public void insertRetweetPost(@PathVariable("id") Long id, @RequestBody PostDto postDto) {
		service.insertRetweetPost(id, postDto);
	}
	
}
