package babble.service;

import java.util.List;

import babble.dto.UserDto;

public interface UserService {
	
	List<UserDto> getUserList();
	
	UserDto getUser(Long id, String password) throws Exception ;
	
	void signUp(UserDto userDto);

	void updateUser(UserDto userDto, Long id, String password) throws Exception ;

	void withdraw(Long id, String password) throws Exception ;
}
