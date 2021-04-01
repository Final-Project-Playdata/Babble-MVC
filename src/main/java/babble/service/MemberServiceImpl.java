package babble.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import babble.dao.MemberRepository;
import babble.entity.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository dao;

	public List<Member> getMemberList() {
		try {
			return dao.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public Member getMember(Long id) {
		try {
			return dao.findById(id).get();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

	public boolean insertMember(Member member) {
		try {
			member.setRegDate(new Date());
			dao.save(member);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean updateMember(Member member) {
		try {
			Member findMember = dao.findById(member.getId()).get();
			findMember.setRegDate(new Date());
			dao.save(findMember);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	public boolean deleteMember(Long id) {
		try {
			dao.deleteById(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
}
