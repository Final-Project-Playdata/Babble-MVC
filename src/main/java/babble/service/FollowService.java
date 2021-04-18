package babble.service;

import java.util.List;

import babble.dto.UserDto;

public interface FollowService {

	List<UserDto> getFollowers(Long id);

	List<UserDto> getFollowings(Long id);

	void follow(UserDto following, Long followerId);

	void unfollow(Long followingId, Long followerId);

}
