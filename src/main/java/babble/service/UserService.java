package babble.service;

import java.util.List;

import babble.entity.User;

public interface UserService {
	
	List<User> getUserList();
	
	User getUser(Long id);
	
	void signUp(User user);

	void updateUser(User user);

	void withdraw(Long id);
}
