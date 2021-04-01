package babble.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@PostMapping("signin/{id}")
	public String signIn() {
		return null;
	}
	
	@PostMapping("signup")
	public String signUp() {
		return null;
	}
	
	@DeleteMapping("member/{id}")
	public String  Withdraw() {
		return null;
	}
		
	@PutMapping("member/{id}")
	public String updateMember() {
		return null;
	}
	
	@GetMapping("member/{id}")
	public String getMember() {
		return null;
	}
	
	@GetMapping("memberlist")
	public String getMemberList() {
		return null;
	}
}
