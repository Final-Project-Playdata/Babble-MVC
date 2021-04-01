package babble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.Follow;
import babble.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	List<Member> findMemberById(Long id);
}
