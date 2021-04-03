package babble.service;

import java.util.List;

import babble.entity.User;

public interface UserService {
	
	List<User> getMemberList();
	
	User getMember(Long id);
	
	boolean insertMember(User member);

	boolean updateMember(User member);

	boolean deleteMember(Long id);
}
