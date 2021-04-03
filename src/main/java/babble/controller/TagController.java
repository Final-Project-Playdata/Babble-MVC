package babble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.service.TagServiceImpl;

@RestController
public class TagController {

	@Autowired
	private TagServiceImpl service;
	
	@GetMapping("taglist")
	public String getTagList() {
		if (service.getTagList(user)) {
			return "success";
		}
		return "fail";
	}
	
	@GetMapping("tag{id}")
	public String getTag() {
		if (service.getTag(user)) {
			return "success";
		}
		return "fail";
	}
	
	@PostMapping("taglist")
	public String insertTagList() {
		if (service.insertTagList(user)) {
			return "success";
		}
		return "fail";	}
	
	@PostMapping("tag")
	public String insertTag() {
		if (service.insertTag(user)) {
			return "success";
		}
		return "fail";	}
	
	@PutMapping("tag")
	public String updateTag() {
		if (service.updateTag(user)) {
			return "success";
		}
		return "fail";	}
	
	@PutMapping("taglist")
	public String updateTagList() {
		if (service.updateTagList(user)) {
			return "success";
		}
		return "fail";	}
	
}
