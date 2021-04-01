package babble.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

	@GetMapping("comments/{id}")
	public String getCommentsList() {
		return null;
	}
	
	@PutMapping("comments")
	public String updateComments() {
		return null;
	}
	
	@PostMapping("comments")
	public String insertComments() {
		return null;
	}
	
	@DeleteMapping("comments/{id}")
	public String deleteComments() {
		return null;
	}
	
}
