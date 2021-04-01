package babble.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@PostMapping("post")
	public String insertPost() {
		return null;
	}
	
	@DeleteMapping("post")
	public String deletePost() {
		return null;
	}
	
	@PutMapping("post")
	public String updatePost() {
		return null;
	}
	
	@GetMapping("post")
	public String getPost() {
		return null;
	}
	
	@GetMapping("postlist")
	public String getPostList() {
		return null;
	}
}
