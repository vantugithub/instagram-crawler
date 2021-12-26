package instagram.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instagram.project.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	
	Optional<User> findByUsernameAndActive(String username,int active);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
	List<User> findByRolesId(Long id);
	
	Page<User> findAllByOrderByIdDesc(Pageable pageable);
	
}
