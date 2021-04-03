package babble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.service.PostServiceImpl;

@RestController
public class PostController {

	
	@Autowired
	private PostServiceImpl service;
	
	@PostMapping("post")
	public String insertPost() {
		if (service.insertPost(user)) {
			return "success";
		}
		return "fail";
	}
	
	@DeleteMapping("post")
	public String deletePost() {
		if (service.deletePost(user)) {
			return "success";
		}
		return "fail";	}
	
	@PutMapping("post")
	public String updatePost() {
		if (service.updatePost(user)) {
			return "success";
		}
		return "fail";	}
	
	@GetMapping("post")
	public String getPost() {
		if (service.getPost(user)) {
			return "success";
		}
		return "fail";	}
	
	@GetMapping("postlist")
	public String getPostList() {
		return null;if (service.getPostList(user)) {
			return "success";
		}
		return "fail";
	}
}
