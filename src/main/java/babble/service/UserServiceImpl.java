package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import babble.dao.UserRepository;
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
			String findPassword = dao.findById(id).get().getPassword();

			if (findPassword.equals(password)) {
				return mapper.toDto(dao.findById(id).get());
			}

			throw new UserNotMatchException("정보를 가져오는 중 예외발생");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void signUp(UserDto userDto) {
		try {
			userDto.setRegDate(LocalDateTime.now());
			User user = mapper.toEntity(userDto);
			dao.save(user);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateUser(UserDto userDto, Long id, String password) throws Exception {
		try {
			String findPassword = dao.findById(id).get().getPassword();

			if (findPassword.equals(password)) {
				userDto.setModDate(LocalDateTime.now());
				User user = mapper.toEntity(userDto);
				dao.save(user);
			}
			
			throw new UserNotMatchException("정보를 업데이트 하는 중 예외발생");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void withdraw(Long id, String password, UserDto userDto) throws Exception {
		try {
			String findPassword = dao.findById(id).get().getPassword();

			if (findPassword.equals(password) && findPassword.equals(userDto.getPassword())) {
				dao.deleteById(id);
			}

			throw new UserNotMatchException("회원탈퇴 중 예외발생");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
