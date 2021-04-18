package babble.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.BabbleDto;
import babble.mapper.UserMapper;
import babble.service.BabbleServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BabbleController {

	private final BabbleServiceImpl service;

	private final UserMapper userMapper;

	@PostMapping("babble")
	public BabbleDto insertBabble(@RequestBody BabbleDto babbleDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		return service.insertBabble(babbleDto, userMapper.toDto(p.getUser()));
	}

	@DeleteMapping("babble/{id}")
	public void deleteBabble(@PathVariable("id") Long postId, @AuthenticationPrincipal PrincipalDetails p) {
		service.deleteBabble(postId, p.getUser().getId());
	}

	@PutMapping("babble/{id}")
	public BabbleDto updateBabble(@RequestBody BabbleDto babbleDto, @AuthenticationPrincipal PrincipalDetails p) throws Exception {
		return service.updateBabble(babbleDto, userMapper.toDto(p.getUser()));
	}

	@GetMapping("babble/{id}")
	public BabbleDto getBabble(@PathVariable("id") Long postId) {
		return service.getBabble(postId);
	}

	@GetMapping("babbles")
	public List<BabbleDto> getBabbles() {
		return service.getBabbles();
	}

	// 특정 태그가 들어있는 포스트만 반환
	@GetMapping("babbles/{tag}")
	public List<BabbleDto> getBabblesWithTag(@PathVariable("tag") String tag) {
		return service.getBabblesWithTag(tag);
	}
	
	@GetMapping("user/{id}/babbles")
	public List<BabbleDto> getBabblesWithId(@PathVariable("id") Long id) {
		return service.getBabblesWithId(id);
	}

	// 리트윗 기능
	@PostMapping("rebabble")
	public BabbleDto insertRebabble(@RequestBody BabbleDto babbleDto, @AuthenticationPrincipal PrincipalDetails p)
			throws Exception {
		return service.insertRebabble(babbleDto, userMapper.toDto(p.getUser()));
	}

}
