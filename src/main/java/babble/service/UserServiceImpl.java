package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.UserRepository;
import babble.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository dao;

	public List<User> getMemberList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public User getMember(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertMember(User member) {
		try {
			member.setRegDate(new Date());
			dao.save(member);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateMember(User member) {
		try {
			User findMember = dao.findById(member.getId()).get();
			findMember.setRegDate(new Date());
			dao.save(findMember);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteMember(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
