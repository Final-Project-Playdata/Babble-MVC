package babble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.PostRepository;
import babble.dao.TagRepository;
import babble.entity.Post;
import babble.entity.Tag;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagDao;

	@Autowired
	private PostRepository postDao;

	public List<Tag> getTagList(Long postId) {
		try {
			return tagDao.findByPostId(postId);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void insertTagList(Long postId, List<Tag> tagList) {
		try {
			Post post = postDao.findById(postId).get();

			tagList.forEach(tag -> {
				tag.setPost(post);
				tagDao.save(tag);
			});

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	public void updateTagList(Long postId, List<Tag> tagList) {
		try {
			Post post = postDao.findById(postId).get();
			List<Tag> findTagList = post.getTagList();

			if (tagList.size() > findTagList.size()) {
				tagList.forEach(tag -> {
					if (!findTagList.contains(tag)) {
						tag.setPost(post);
						tagDao.save(tag);
					}
				});
			} else {
				findTagList.forEach(tag -> {
					if (!tagList.contains(tag)) {
						tagDao.delete(tag);
					}
				});
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

}
