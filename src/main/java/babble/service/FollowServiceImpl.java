package babble.service;

import java.util.List;

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

	public List<FollowDto> getFollowerList(Long id) {
		try {
			return followMapper.toDtoList(followDao.findByFollowerId(id));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<FollowDto> getFollowingList(Long id) {
		try {
			return followMapper.toDtoList(followDao.findByFollowingId(id));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void follow(UserDto following, Long followerId) {
		try {

			UserDto follower = userMapper.toDto(userDao.findById(followerId).get());

			FollowDto followDto = new FollowDto();
			followDto.setFollowing(following);
			followDto.setFollower(follower);

			followDao.save(followMapper.toEntity(followDto));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void unfollow(Long followingId, Long followerId) {
		try {
			followDao.deleteByFollowingIdAndFollowerId(followingId, followerId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
