package babble.service;

import java.util.List;

import babble.dto.FollowDto;
import babble.dto.UserDto;

public interface FollowService {

	List<FollowDto> getFollowerList(Long id);

	List<FollowDto> getFollowingList(Long id);

	void follow(UserDto following, Long followerId);

	void unfollow(Long followingId, Long followerId);

}
