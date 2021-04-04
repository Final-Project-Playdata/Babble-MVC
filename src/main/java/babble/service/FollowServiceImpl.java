package babble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.FollowRepository;
import babble.dao.UserRepository;
import babble.entity.Follow;
import babble.entity.User;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowRepository followDao;
	
	@Autowired
	private UserRepository userDao;

	public List<Follow> getFollowerList(Long id) {
		try {
			return followDao.findByFollowerId(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}
	
	public List<Follow> getFollowingList(Long id) {
		try {
			return followDao.findByFollowingId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

	public void follow(Long followerId, User following) {
		try {
			User follower = userDao.findById(followerId).get();
			
			Follow follow = new Follow();
			follow.setFollower(follower);
			follow.setFollowing(following);
			
			followDao.save(follow);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void unfollow(Long followerId, User following) {
		try {
			followDao.deleteByFollowerAndFollowing(followerId, following.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

}
