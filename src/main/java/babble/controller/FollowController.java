package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.entity.Follow;
import babble.service.FollowServiceImpl;

@RestController
public class FollowController {

	
	@Autowired
	private FollowServiceImpl service;
	
	@PostMapping("follow/{id}")
	public void follow(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.follow(id, p.getUser());
	}

	@DeleteMapping("follow/{id}")
	public void unfollow(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.unfollow(id, p.getUser());
	}

	@GetMapping("follower/{id}")
	public List<Follow> getFollowerList(@PathVariable Long id) {
		return service.getFollowerList(id);
	}

	@GetMapping("following/{id}")
	public List<Follow> getFollowingList(@PathVariable Long id) {
		return service.getFollowingList(id);
	}
}
