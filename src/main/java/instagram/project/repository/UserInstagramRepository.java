package instagram.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instagram.project.entity.UserInstagram;

@Repository
public interface UserInstagramRepository extends JpaRepository<UserInstagram, Integer>{
}
