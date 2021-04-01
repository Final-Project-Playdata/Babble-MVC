package babble.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikesController {

	@PostMapping("likes")
	public String like() {
		return null;
	}
	
	@DeleteMapping("likes")
	public String unlike() {
		return null;
	}
	
	@GetMapping("likes")
	public String getlikesList() {
		return null;
	}
}
