package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dto.UserDto;
import babble.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@PostMapping("signup")
	public void signUp(@RequestBody UserDto userDto) {
		service.signUp(userDto);
	}

	@DeleteMapping("user/{id}")
	public void withdraw(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) throws Exception {
		service.withdraw(id, p.getUser().getPassword());
	}

	@PutMapping("user/{id}")
	public void updateUser(@RequestBody UserDto userDto, @AuthenticationPrincipal PrincipalDetails p, @PathVariable("id") Long id) throws Exception {
		service.updateUser(userDto, id, p.getUser().getPassword());
	}

	@GetMapping("user/{id}")
	public UserDto getUser(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p) throws Exception {
		return service.getUser(id, p.getUser().getPassword());
	}

	@GetMapping("admin/users")
	public List<UserDto> getUserList() {
		return service.getUserList();
	}
}
