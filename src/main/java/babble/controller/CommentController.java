package babble.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.dto.CommentDto;
import babble.service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentServiceImpl service;
	
	@GetMapping("post/{id}/comments")
	public List<CommentDto> getCommentList(@PathVariable("id") Long id) {
		return service.getCommentList(id);
	}

	@PostMapping("comment")
	public void insertComment(@RequestBody CommentDto commentDto) {
		service.insertComment(commentDto);
	}
	
	@PutMapping("comment")
	public void updateComment(@RequestBody CommentDto commentDto) {
		service.updateComment(commentDto);
	}

	@DeleteMapping("comment/{id}")
	public void deleteComment(@PathVariable("id") Long id) {
		service.deleteComment(id);
	}

}
