package babble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final BabbleServiceImpl babbleService;

	private final FollowServiceImpl followService;

	private final LikeServiceImpl likeService;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<UserDto> getUsers() {
		try {
			logger.info("getUsers");
			return mapper.toDtoList(dao.findAll());

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;

		}
	}

	public UserDto getUserInfo(Long id) throws Exception {
		try {
			UserDto userDto = mapper.toDto(dao.findById(id).get());
			userDto.setBabbles(babbleService.getBabblesWithId(id));
			userDto.setLikeBabbles(likeService.getLikeBabbles(id));
			userDto.setFollowings(followService.getFollowings(id));
			userDto.setFollowers(followService.getFollowers(id));

			logger.info("getUserInfo : {}", userDto);
			return userDto;

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public void signUp(UserDto userDto) throws Exception {
		try {
			User findUser = dao.findByUsername(userDto.getUsername());
			if (findUser == null) {
				userDto.setRole("ROLE_USER");
				userDto.setRegDate(LocalDateTime.now());
				userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
				logger.info("signUp : {}", userDto);
				dao.save(mapper.toEntity(userDto));
			} else {
				throw new Exception("유저가 이미 존재합니다.");
			}

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public UserDto updateUser(UserDto userDto, Long id, String password) throws Exception {
		try {
			User user = dao.findById(id).get();
			String findPassword = user.getPassword();

			if (findPassword.equals(password) && userDto.getId().equals(id)) {
				user.update(userDto.getAvatar(), userDto.getFirstName(), userDto.getLastName(), userDto.getBio(),
						userDto.getBirth(), userDto.getNickname(), userDto.getGender(), userDto.getPhoneNumber(),
						userDto.getBackground());

				logger.info("updateUser : {}", userDto);
				User savedUser = dao.save(user);
				return mapper.toDto(savedUser);
			} else {
				throw new UserNotMatchException("정보를 업데이트 하는 중 예외발생");
			}

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public void withdraw(Long id, String password, LoginRequestDto loginDto) throws Exception {
		try {
			String findPassword = dao.findById(id).get().getPassword();
			String doubleCheckPassword = bCryptPasswordEncoder.encode(loginDto.getPassword());

			if (findPassword.equals(password) && findPassword.equals(doubleCheckPassword)) {
				dao.deleteById(id);
				logger.info("withdraw : {}", loginDto);
			} else {
				throw new UserNotMatchException("회원탈퇴 중 예외발생");
			}

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

}
