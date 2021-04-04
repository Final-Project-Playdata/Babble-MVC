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
import babble.entity.Like;
import babble.service.LikeServiceImpl;

@RestController
public class LikeController {

	@Autowired
	private LikeServiceImpl service;
	
	@PostMapping("post/{id}/like")
	public void like(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.like(id, p.getUser());
	}

	@DeleteMapping("post/{id}/like")
	public void unlike(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.unlike(id, p.getUser());
	}

	@GetMapping("post/{id}/like")
	public List<Like> getLikeList(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		return service.getLikeList(id);
	}
	
}
