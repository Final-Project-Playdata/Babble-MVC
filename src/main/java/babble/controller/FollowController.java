package babble.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

	@PostMapping("follow/{id}")
	public String follow(@PathVariable Long id) {
		return null;
	}
	
	@DeleteMapping("follow/{id}")
	public String unfollow(@PathVariable Long id) {
		return null;
	}
	
	@GetMapping("follow/follower/{id}")
	public String getFollowerList(@PathVariable Long id) {
		return null;
	}
	
	@GetMapping("follow/following/{id}")
	public String getFollowingList(@PathVariable Long id) {
		return null;
	}
}
