package babble.service;

import java.util.List;

import babble.entity.Member;

public interface MemberService {
	
	List<Member> getMemberList();
	
	Member getMember(Long id);
	
	boolean insertMember(Member member);

	boolean updateMember(Member member);

	boolean deleteMember(Long id);
}
