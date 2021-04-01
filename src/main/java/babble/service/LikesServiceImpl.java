package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.LikesRepository;
import babble.entity.Likes;

@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	private LikesRepository dao;

	public List<Likes> getLikesList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Likes getLikes(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertLikes(Likes likes) {
		try {
			likes.setRegDate(new Date());
			dao.save(likes);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateLikes(Likes likes) {
		try {
			likes.setRegDate(new Date());
			dao.save(likes);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteLikes(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
