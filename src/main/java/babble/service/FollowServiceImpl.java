package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.FollowRepository;
import babble.entity.Follow;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowRepository dao;

	public List<Follow> getFollowList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Follow getFollow(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertFollow(Follow follow) {
		try {
			follow.setRegDate(new Date());
			dao.save(follow);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateFollow(Follow follow) {
		try {
			follow.setRegDate(new Date());
			dao.save(follow);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteFollow(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
