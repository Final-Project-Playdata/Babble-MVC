package babble.service;

import java.util.List;

import babble.dto.FollowDto;
import babble.dto.UserDto;

public interface FollowService {
	
	List<FollowDto> getFollowerList(Long id);
	
	List<FollowDto> getFollowingList(Long id);
	
	void follow(Long followerId, UserDto following);
	
	void unfollow(Long followerId, UserDto following);

}
