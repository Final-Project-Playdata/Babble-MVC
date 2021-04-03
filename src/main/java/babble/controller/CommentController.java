package babble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.service.CommentServiceImpl;

@RestController
public class CommentController {

	
	@Autowired
	private CommentServiceImpl service;
	
	@GetMapping("commentList")
	public String getCommentsList() {
		if (service.getCommentsList(user)) {
			return "success";
		}
		return "fail";
	}

	@PutMapping("comments")
	public String updateComments() {
		if (service.updateComments(user)) {
			return "success";
		}
		return "fail";
	}

	@PostMapping("comments")
	public String insertComments() {
		if (service.insertComments(user)) {
			return "success";
		}
		return "fail";
	}

	@DeleteMapping("comments/{id}")
	public String deleteComments() {
		if (service.deleteComments(user)) {
			return "success";
		}
		return "fail";
	}

}
