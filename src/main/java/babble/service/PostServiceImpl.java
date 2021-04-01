package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.PostRepository;
import babble.entity.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository dao;

	public List<Post> getPostList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Post getPost(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertPost(Post post) {
		try {
			post.setRegDate(new Date());
			dao.save(post);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updatePost(Post post) {
		try {
			Post findPost = dao.findById(post.getId()).get();
			findPost.setRegDate(new Date());
			dao.save(findPost);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deletePost(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
