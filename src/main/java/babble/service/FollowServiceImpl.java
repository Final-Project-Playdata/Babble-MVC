package babble.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import babble.dao.FollowRepository;
import babble.dao.UserRepository;
import babble.dto.FollowDto;
import babble.dto.UserDto;
import babble.mapper.FollowMapper;
import babble.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

	private final FollowRepository followDao;

	private final UserRepository userDao;

	private final FollowMapper followMapper;

	private final UserMapper userMapper;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// following -> follower
	public List<UserDto> getFollowers(Long id) {
		try {
			logger.info("getFollowers : {}", id);
			return userMapper.toDtoList(followDao.findByFollowerId(id).stream().map(follower -> follower.getFollowing())
					.collect(Collectors.toList()));
		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public List<UserDto> getFollowings(Long id) {
		try {
			logger.info("getFollowings : {}", id);
			return userMapper.toDtoList(followDao.findByFollowingId(id).stream().map(follower -> follower.getFollower())
					.collect(Collectors.toList()));

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	public void follow(UserDto following, Long followerId) {
		try {

			UserDto follower = userMapper.toDto(userDao.findById(followerId).get());

			FollowDto followDto = new FollowDto();
			followDto.setFollowing(following);
			followDto.setFollower(follower);

			logger.info("follow : {}", followDto);
			followDao.save(followMapper.toEntity(followDto));

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

	@Transactional
	public void unfollow(Long followingId, Long followerId) {
		try {
			followDao.deleteByFollowingIdAndFollowerId(followingId, followerId);
			logger.info("unfollow : {} - {}", followingId, followerId);

		} catch (Exception e) {
			logger.error("Error : {}", e);
			throw e;
		}
	}

}
