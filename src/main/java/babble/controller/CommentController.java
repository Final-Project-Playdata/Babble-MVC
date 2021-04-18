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

	@GetMapping("babble/{babbleId}/comments")
	public List<CommentDto> getComments(@PathVariable("babbleId") Long id) {
		return service.getComments(id);
	}

	@PostMapping("babble/{babbleId}/comment")
	public CommentDto insertComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		return service.insertComment(commentDto, userMappper.toDto(p.getUser()));
	}

	@PutMapping("babble/{babbleId}/comment/{commentId}")
	public void updateComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		service.updateComment(commentDto, p.getPassword(), p.getUsername());
	}

	@DeleteMapping("babble/{babbleId}/comment/{commentId}")
	public void deleteComment(@PathVariable("commentId") Long commentId, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteComment(commentId, p.getUser().getId());
	}
	
	@DeleteMapping("babble/{babbleId}/comments")
	public void deleteComments(@PathVariable("babbleId") Long babbleId, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteComments(babbleId, p.getUser().getId());
	}

}
