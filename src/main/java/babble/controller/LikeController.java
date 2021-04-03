package babble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.service.LikeServiceImpl;

@RestController
public class LikeController {

	
	@Autowired
	private LikeServiceImpl service;
	
	@PostMapping("likeList")
	public String like() {
		if (service.like(user)) {
			return "success";
		}
		return "fail";
	}

	@DeleteMapping("like")
	public String unlike() {
		if (service.unlike(user)) {
			return "success";
		}
		return "fail";
	}

	@GetMapping("likes")
	public String getlikesList() {
		if (service.getlikesList(user)) {
			return "success";
		}
		return "fail";
	}
}
