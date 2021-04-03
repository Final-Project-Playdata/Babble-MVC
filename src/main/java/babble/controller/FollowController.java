package babble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.service.FollowServiceImpl;

@RestController
public class FollowController {

	
	@Autowired
	private FollowServiceImpl service;
	
	@PostMapping("follow/{id}")
	public String follow(@PathVariable Long id) {
		if (service.follow(user)) {
			return "success";
		}
		return "fail";
	}

	@DeleteMapping("follow/{id}")
	public String unfollow(@PathVariable Long id) {
		if (service.unfollow(user)) {
			return "success";
		}
		return "fail";
	}

	@GetMapping("follow/follower/{id}")
	public String getFollowerList(@PathVariable Long id) {
		if (service.getFollowerList(user)) {
			return "success";
		}
		return "fail";
	}

	@GetMapping("follow/following/{id}")
	public String getFollowingList(@PathVariable Long id) {
		if (service.getFollowingList(user)) {
			return "success";
		}
		return "fail";
	}
}
