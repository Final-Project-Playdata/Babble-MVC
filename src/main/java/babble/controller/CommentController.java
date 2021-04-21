package babble.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("babble/{babbleId}/comment")
	public CommentDto insertComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		return service.insertComment(commentDto, userMappper.toDto(p.getUser()));
	}

	@DeleteMapping("babble/{babbleId}/comment/{commentId}")
	public void deleteComment(@PathVariable("commentId") Long commentId, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteComment(commentId, p.getUser().getId());
	}

}
