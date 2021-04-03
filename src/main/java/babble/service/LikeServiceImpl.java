package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.LikeRepository;
import babble.entity.Like;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeRepository dao;

	public List<Like> getLikesList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Like getLikes(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertLikes(Like likes) {
		try {
			likes.setRegDate(new Date());
			dao.save(likes);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateLikes(Like likes) {
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
