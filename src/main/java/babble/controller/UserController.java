package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.entity.User;
import babble.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@PostMapping("signup")
	public void signUp(@RequestBody User user) {
		service.signUp(user);
	}

	@DeleteMapping("user/{id}")
	public void withdraw(@PathVariable("id") Long id) {
		service.withdraw(id);
	}

	@PutMapping("user/{id}")
	public void updateUser(@RequestBody User user) {
		service.updateUser(user);
	}

	@GetMapping("user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return service.getUser(id);
	}

	@GetMapping("users")
	public List<User> getUserList() {
		return service.getUserList();
	}
}
