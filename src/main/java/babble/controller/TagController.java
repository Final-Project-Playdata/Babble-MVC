package babble.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.TagDto;
import babble.dto.TagListDto;
import babble.service.TagServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TagController {

	private final TagServiceImpl service;
	
	@GetMapping("post/{id}/tags")
	public List<TagDto> getTagList(@PathVariable("id") Long id) {
		return service.getTagList(id);
	}

	@PostMapping("post/{id}/tags")
	public void insertTagList(@PathVariable("id") Long id, @RequestBody TagListDto tagDtoList, @AuthenticationPrincipal PrincipalDetails p) throws Exception {
		service.insertTagList(id, tagDtoList.getTagList(), p.getUser().getPassword());
	}

	@PutMapping("post/{id}/tags")
	public void updateTagList(@PathVariable("id") Long id, @RequestBody TagListDto tagDtoList, @AuthenticationPrincipal PrincipalDetails p) throws Exception {
		service.updateTagList(id, tagDtoList.getTagList(), p.getUser().getPassword());
	}

}
