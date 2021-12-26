package instagram.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instagram.project.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer>{
	public Topic findByNameTopic(String name);
	public List<Topic> findAll();
	public Topic findById(int id);
	public boolean existsByNameTopic(String nameTopic);
	public boolean existsById(int id);
	
}
