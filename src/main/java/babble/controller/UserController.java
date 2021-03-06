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
import babble.dto.LoginRequestDto;
import babble.dto.UserDto;
import babble.mapper.UserMapper;
import babble.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserServiceImpl service;

	private final UserMapper userMapper;

	@PostMapping("signup")
	public void signUp(@RequestBody UserDto userDto) throws Exception {
		service.signUp(userDto);
	}

	@DeleteMapping("user/{id}")
	public void withdraw(@PathVariable("id") Long id, @AuthenticationPrincipal PrincipalDetails p,
			@RequestBody LoginRequestDto loginDto) throws Exception {
		service.withdraw(id, p.getUser().getPassword(), loginDto);
	}

	@PutMapping("user/{id}")
	public UserDto updateUser(@RequestBody UserDto userDto, @AuthenticationPrincipal PrincipalDetails p,
			@PathVariable("id") Long id) throws Exception {
		return service.updateUser(userDto, id, p.getUser().getPassword());
	}

	@GetMapping("user/{id}")
	public UserDto getUserInfo(@PathVariable("id") Long id) throws Exception {
		return service.getUserInfo(id);
	}
	
	@GetMapping("my")
	public UserDto getMyInfo(@AuthenticationPrincipal PrincipalDetails p) throws Exception {
		return userMapper.toDto(p.getUser());
	}

	@GetMapping("admin/users")
	public List<UserDto> getUsers() {
		return service.getUsers();
	}
	
}
