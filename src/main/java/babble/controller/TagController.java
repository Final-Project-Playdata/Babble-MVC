package babble.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

	@GetMapping("taglist")
	public String getTagList() {
		return null;
	}
	
	@GetMapping("tag")
	public String getTag() {
		return null;
	}
	
	@PostMapping("taglist")
	public String insertTagList() {
		return null;
	}
	
	@PostMapping("tag")
	public String insertTag() {
		return null;
	}
	
	@PutMapping("tag")
	public String updateTag() {
		return null;
	}
	
	@PutMapping("taglist")
	public String updateTagList() {
		return null;
	}
	
	
}
