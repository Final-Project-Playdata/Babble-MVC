package babble.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.FollowDto;
import babble.mapper.UserMapper;
import babble.service.FollowServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FollowController {

	private final FollowServiceImpl service;
	
	private final UserMapper mapper;
	
	@PostMapping("follow/{id}")
	public void follow(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.follow(id, mapper.toDto(p.getUser()));
	}

	@DeleteMapping("follow/{id}")
	public void unfollow(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.unfollow(id, mapper.toDto(p.getUser()));
	}

	@GetMapping("follower/{id}")
	public List<FollowDto> getFollowerList(@PathVariable Long id) {
		return service.getFollowerList(id);
	}

	@GetMapping("following/{id}")
	public List<FollowDto> getFollowingList(@PathVariable Long id) {
		return service.getFollowingList(id);
	}
}
