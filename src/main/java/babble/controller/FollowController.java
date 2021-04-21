package babble.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.mapper.UserMapper;
import babble.service.FollowServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FollowController {

	private final FollowServiceImpl service;

	private final UserMapper mapper;

	@PostMapping("user/{userId}/follow")
	public void follow(@PathVariable("userId") Long userId, @AuthenticationPrincipal PrincipalDetails p) {
		service.follow(mapper.toDto(p.getUser()), userId);
	}

	@DeleteMapping("user/{userId}/follow")
	public void unfollow(@PathVariable("userId") Long userId, @AuthenticationPrincipal PrincipalDetails p) {
		service.unfollow(p.getUser().getId(), userId);
	}

}
