package babble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.TagRepository;
import babble.entity.Tag;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository dao;

	public List<Tag> getTagList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Tag getTag(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertTag(Tag tag) {
		try {
			dao.save(tag);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateTag(Tag tag) {
		try {
			dao.save(tag);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteTag(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
