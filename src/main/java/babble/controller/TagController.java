package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.entity.Tag;
import babble.service.TagServiceImpl;

@RestController
public class TagController {

	@Autowired
	private TagServiceImpl service;

	@GetMapping("post/{id}/tag")
	public List<Tag> getTagList(@PathVariable("id") Long id) {
		return service.getTagList(id);
	}

	@PostMapping("post/{id}/tag")
	public void insertTagList(@PathVariable("id") Long id, @RequestBody List<Tag> tagList) {
		service.insertTagList(id, tagList);
	}

	@PutMapping("post/{id}/tag")
	public void updateTagList(@PathVariable("id") Long id, @RequestBody List<Tag> tagList) {
		service.updateTagList(id, tagList);
	}

}
