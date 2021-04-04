package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.entity.Comment;
import babble.service.CommentServiceImpl;

@RestController
public class CommentController {

	@Autowired
	private CommentServiceImpl service;
	
	@GetMapping("post/{id}/comments")
	public List<Comment> getCommentList(@PathVariable("id") Long id) {
		return service.getCommentList(id);
	}

	@PostMapping("comment")
	public void insertComment(@RequestBody Comment comment) {
		service.insertComment(comment);
	}
	
	@PutMapping("comment")
	public void updateComment(@RequestBody Comment comment) {
		service.updateComment(comment);
	}

	@DeleteMapping("comment/{id}")
	public void deleteComment(@PathVariable("id") Long id) {
		service.deleteComment(id);
	}

}
