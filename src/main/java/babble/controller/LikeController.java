package babble.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.LikeDto;
import babble.dto.BabbleDto;
import babble.mapper.UserMapper;
import babble.service.LikeServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LikeController {

	private final LikeServiceImpl service;

	private final UserMapper mapper;

	@PostMapping("babble/{id}/like")
	public void like(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.like(id, mapper.toDto(p.getUser()));
	}

	@DeleteMapping("babble/{id}/like")
	public void unlike(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.unlike(id, p.getUser().getId());
	}

	@GetMapping("babble/{id}/likes")
	public List<LikeDto> getLikes(@PathVariable("id") Long id) {
		return service.getLikes(id);
	}

	@DeleteMapping("babble/{id}/likes")
	public void deleteLikes(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteLikes(id, p.getUser().getId());
	}
	
	@GetMapping("user/{id}/likes")
	public List<BabbleDto> getLikeBabbles(@PathVariable("id") Long id) {
		return service.getLikeBabbles(id);
	}
	
}
