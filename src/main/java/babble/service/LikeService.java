package babble.service;

import java.util.List;

import babble.entity.Like;

public interface LikeService {
	
	List<Like> getLikesList();
	
	Like getLikes(Long id);
	
	boolean insertLikes(Like likes);

	boolean updateLikes(Like likes);

	boolean deleteLikes(Long id);
}
