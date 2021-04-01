package babble.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import babble.dao.FollowRepository;
import babble.dao.MemberRepository;
import babble.entity.Follow;
import babble.entity.Member;

@RestController
public class Test {
	
	@Autowired
	private FollowRepository dao;
	
	@Autowired
	private MemberRepository mDao;
	
	@GetMapping("test")
	public List<Follow> test() {
		System.out.println("test");
		return dao.findAll();
	}
	
	
	@GetMapping("test1")
	public void test1() {
		System.out.println("test1");
		mDao.save(Member.builder().build());
		mDao.save(Member.builder().build());
	}
	
	@GetMapping("test2")
	public void test2() {
		System.out.println("test2");
		Member m1 = mDao.findById(1l).orElse(null);
		Member m2 = mDao.findById(2l).orElse(null);
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
	public List<Member> test3() {
		System.out.println("test3");
		return mDao.findAll();
	}
	
	@GetMapping("test4")
	public List<Member> test4() {
		System.out.println("test4");
		return mDao.findAll();
	}
}
