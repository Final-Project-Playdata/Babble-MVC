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
import babble.dto.CommentDto;
import babble.mapper.UserMapper;
import babble.service.CommentServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentServiceImpl service;

	private final UserMapper userMappper;

	@GetMapping("post/{postId}/comments")
	public List<CommentDto> getCommentList(@PathVariable("id") Long id) {
		return service.getCommentList(id);
	}

	@PostMapping("post/{postId}/comment")
	public void insertComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal PrincipalDetails p) {
		service.insertComment(commentDto, userMappper.toDto(p.getUser()));
	}

	@PutMapping("post/{postId}/comment/{commentId}")
	public void updateComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		service.updateComment(commentDto, p.getPassword());
	}

	@DeleteMapping("post/{postId}/comment/{commentId}")
	public void deleteComment(@PathVariable("commentId") Long commentId, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteComment(commentId, p.getUser().getId());
	}

}
