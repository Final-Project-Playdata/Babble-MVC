package babble.service;

import java.util.List;

import babble.dto.UserDto;

public interface FollowService {

	List<UserDto> getFollowerList(Long id);

	List<UserDto> getFollowingList(Long id);

	void follow(UserDto following, Long followerId);

	void unfollow(Long followingId, Long followerId);

}
