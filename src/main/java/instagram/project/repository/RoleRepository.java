package instagram.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instagram.project.entity.Role;
import instagram.project.entity.RoleName;
import instagram.project.entity.User;


@Repository
public interface RoleRepository  extends JpaRepository<Role,Long>{
	Optional<Role> findByName(RoleName name);
	List<User> findUsersByName(RoleName name);
}
