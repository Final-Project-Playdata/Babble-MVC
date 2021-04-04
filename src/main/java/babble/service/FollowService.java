package babble.service;

import java.util.List;

import babble.entity.Follow;
import babble.entity.User;

public interface FollowService {
	
	List<Follow> getFollowerList(Long id);
	
	List<Follow> getFollowingList(Long id);
	
	void follow(Long followerId, User following);
	
	void unfollow(Long followerId, User following);

}
