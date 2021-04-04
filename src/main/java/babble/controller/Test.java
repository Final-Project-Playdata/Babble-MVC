package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import babble.config.auth.PrincipalDetails;
import babble.dao.FollowRepository;
import babble.dao.UserRepository;
import babble.entity.Follow;
import babble.entity.User;

@RestController
public class Test {
	
	@Autowired
	private FollowRepository dao;
	
	@Autowired
	private UserRepository uDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("test")
	public List<Follow> test() {
		System.out.println("test");
		return dao.findAll();
	}
	
	
	@GetMapping("test1")
	public void test1() {
		System.out.println("test1");
		uDao.save(User.builder().build());
		uDao.save(User.builder().build());
	}
	
	@GetMapping("test2")
	public void test2() {
		System.out.println("test2");
		User m1 = uDao.findById(1l).orElse(null);
		User m2 = uDao.findById(2l).orElse(null);
		Follow f = new Follow();
		f.setFollower(m1);
		f.setFollowing(m2);
		dao.save(f);
		Follow f1 = new Follow();
		f1.setFollower(m2);
		f1.setFollowing(m1);
		dao.save(f1);
	}
	
	@GetMapping("test3")
	public List<User> test3() {
		System.out.println("test3");
		return uDao.findAll();
	}
	
	@GetMapping("test4")
	public List<User> test4() {
		System.out.println("test4");
		return uDao.findAll();
	}
	
	@PostMapping("join")
	public String join(@RequestBody User user) {
		try {
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_USER");
			uDao.save(user);
			return "회원가입완료";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "실패";
	}
	
	@GetMapping("authtest")
	public String user(Authentication authentication) {
		try {
			System.out.println(1);
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			System.out.println("principal : "+principal.getUser().getId());
			System.out.println("principal : "+principal.getUser().getUsername());
			System.out.println("principal : "+principal.getUser().getPassword());
			return "t";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "<h1>user</h1>";
	}
}
