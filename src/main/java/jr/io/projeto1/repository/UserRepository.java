package jr.io.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jr.io.projeto1.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.name like %:name%")
	User findByNameQualquerCoisa(String name);
	
	User findByEmail(String email);
	
	User findByNameIgnoreCase(String name);
}
