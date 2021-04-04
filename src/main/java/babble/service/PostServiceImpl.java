package babble.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.PostRepository;
import babble.dao.TagRepository;
import babble.entity.Post;
import babble.entity.Tag;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postDao;
	
	@Autowired
	private TagRepository tagDao;

	public List<Post> getPostList() {
		try {
			return postDao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
	
	public List<Post> getPostListWithTag(String tag) {
		try {
			List<Tag> tagList = tagDao.findByName(tag);
			List<Post> postList = new ArrayList<>();
			
			tagList.forEach(t -> {
				postList.add(t.getPost());
			});
			
			return postList;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}
	}

	public Post getPost(Long id) {
		try {
			return postDao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void insertPost(Post post) {
		try {
			post.setRegDate(LocalDateTime.now());
			postDao.save(post);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void updatePost(Post post) {
		try {
			Post findPost = postDao.findById(post.getId()).get();
			findPost.setModDate(LocalDateTime.now());
			postDao.save(findPost);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void deletePost(Long id) {
		try {
			postDao.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}
	
}
