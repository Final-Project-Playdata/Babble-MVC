package babble.service;

import java.util.List;

import babble.entity.Like;
import babble.entity.User;

public interface LikeService {
	
	List<Like> getLikeList(Long postId);
	
	void like(Long postId, User user);
	
	void unlike(Long postId, User user);
	
}
