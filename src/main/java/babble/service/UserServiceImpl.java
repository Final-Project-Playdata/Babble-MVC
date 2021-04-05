package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.UserRepository;
import babble.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository dao;

	public List<User> getUserList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public User getUser(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void signUp(User user) {
		try {
			user.setRegDate(LocalDateTime.now());
			dao.save(user);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateUser(User user) {
		try {
			user.setModDate(LocalDateTime.now());
			dao.save(user);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void withdraw(Long id) {
		try {
			dao.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
