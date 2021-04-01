package babble.service;

import java.util.List;

import babble.entity.Likes;

public interface LikesService {
	
	List<Likes> getLikesList();
	
	Likes getLikes(Long id);
	
	boolean insertLikes(Likes likes);

	boolean updateLikes(Likes likes);

	boolean deleteLikes(Long id);
}
