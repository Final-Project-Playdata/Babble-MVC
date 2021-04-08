package babble.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import babble.dao.UserRepository;
import babble.dto.LoginRequestDto;
import babble.dto.UserDto;
import babble.entity.User;
import babble.exception.UserNotMatchException;
import babble.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository dao;

	private final UserMapper mapper;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public List<UserDto> getUserList() {
		try {
			return mapper.toDtoList(dao.findAll());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public UserDto getUser(Long id, String password) throws Exception {
		try {
			User user = dao.findById(id).get();
			String findPassword = user.getPassword();

			if (findPassword.equals(password)) {
				return mapper.toDto(user);
			}

			throw new UserNotMatchException("정보를 가져오는 중 예외발생");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void signUp(LoginRequestDto loginDto) throws Exception {
		try {
			User findUser = dao.findByUsername(loginDto.getUsername());
			if (findUser == null) {
				User user = new User();
				user.signUp(loginDto.getUsername(), bCryptPasswordEncoder.encode(loginDto.getPassword()));
				dao.save(user);
			}

			throw new Exception("유저가 이미 존재합니다.");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateUser(UserDto userDto, Long id, String password) throws Exception {
		try {
			User user = dao.findById(id).get();
			String findPassword = user.getPassword();

			if (findPassword.equals(password) && userDto.getId() == id) {
				user.update(userDto.getAvatar(), userDto.getFirstName(), userDto.getLastName(), userDto.getBio(),
						userDto.getBirth());
				dao.save(user);
			}

			throw new UserNotMatchException("정보를 업데이트 하는 중 예외발생");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void withdraw(Long id, String password, LoginRequestDto loginDto) throws Exception {
		try {
			String findPassword = dao.findById(id).get().getPassword();
			String doubleCheckPassword = bCryptPasswordEncoder.encode(loginDto.getPassword());

			if (findPassword.equals(password) && findPassword.equals(doubleCheckPassword)) {
				dao.deleteById(id);
			}

			throw new UserNotMatchException("회원탈퇴 중 예외발생");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
