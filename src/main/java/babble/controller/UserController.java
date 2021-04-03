package babble.controller;

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
	public String signUp(@RequestBody User user) {
		if (service.signUp(user)) {
			return "success";
		}
		return "fail";
	}

	@DeleteMapping("user/{id}")
	public String Withdraw(@PathVariable("id") int id) {
		if (service.Withdraw(id)) {
			return "success";
		}
		return "fail";
	}

	@PutMapping("user/{id}")
	public String updateUser(User user) {
		boolean result = service.updateUser(user);
		if (result) {
			return "success";
		}
		return "fail";
	}

	@GetMapping("user/{id}")
	public String getUser(@PathVariable("id") int id) {
		boolean result = service.getUser(id);
		if (result) {
			return "success";
		}
		return "fail";
	}

	@GetMapping("userlist")
	public String getUserList() {
		boolean result = service.getUserList(user);
		if (result) {
			return "success";
		}
		return "fail";
	}
}
