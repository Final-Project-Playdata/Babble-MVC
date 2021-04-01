package babble.service;

import java.util.List;

import babble.entity.Follow;

public interface FollowService {
	
	List<Follow> getFollowList();
	
	Follow getFollow(Long id);
	
	boolean insertFollow(Follow follow);

	boolean updateFollow(Follow follow);

	boolean deleteFollow(Long id);
}
