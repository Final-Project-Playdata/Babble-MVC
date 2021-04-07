package babble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import babble.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	@Query(value="SELECT password FROM Member WHERE Id = :id", nativeQuery=true)
    String findPasswordById(@Param("id") Long id);
}
