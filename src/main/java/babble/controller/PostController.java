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

import babble.entity.Post;
import babble.service.PostServiceImpl;

@RestController
public class PostController {

	@Autowired
	private PostServiceImpl service;

	@PostMapping("post")
	public void insertPost(@RequestBody Post post) {
		service.insertPost(post);
	}

	@DeleteMapping("post/{id}")
	public void deletePost(@PathVariable("id") Long postId) {
		service.deletePost(postId);
	}

	@PutMapping("post/{id}")
	public void updatePost(@RequestBody Post post) {
		service.updatePost(post);
	}

	@GetMapping("post/{id}")
	public Post getPost(@PathVariable("id") Long postId) {
		return service.getPost(postId);
	}

	@GetMapping("posts")
	public List<Post> getPostList() {
		return service.getPostList();
	}

	// 특정 태그가 들어있는 포스트만 반환
	@GetMapping("posts/tag")
	public List<Post> getPostListWithTag(@PathVariable("tag") String tag) {
		return service.getPostListWithTag(tag);
	}
	
	//리트윗 기능
}
