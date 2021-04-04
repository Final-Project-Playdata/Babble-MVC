package babble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.LikeRepository;
import babble.dao.PostRepository;
import babble.entity.Like;
import babble.entity.Post;
import babble.entity.User;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeRepository likeDao;

	@Autowired
	private PostRepository postDao;

	public List<Like> getLikeList(Long postId) {
		try {
			return likeDao.findByPostId(postId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void like(Long postId, User user) {
		try {
			Post post = postDao.findById(postId).get();
			Like like = new Like();

			like.setPost(post);
			like.setUser(user);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void unlike(Long postId, User user) {
		try {
			likeDao.deleteByPostIdAndUserId(postId, user.getId());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

}
