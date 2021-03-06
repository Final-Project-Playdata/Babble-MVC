package babble.service;

import java.util.List;

import babble.dto.LoginRequestDto;
import babble.dto.UserDto;

public interface UserService {

	List<UserDto> getUsers();

	UserDto getUserInfo(Long id) throws Exception;

	void signUp(UserDto userDto) throws Exception;

	UserDto updateUser(UserDto userDto, Long id, String password) throws Exception;

	void withdraw(Long id, String password, LoginRequestDto loginDto) throws Exception;

}
