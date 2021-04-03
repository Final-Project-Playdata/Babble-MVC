package babble.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import babble.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
