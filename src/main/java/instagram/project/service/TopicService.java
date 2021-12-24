package instagram.project.service;

import java.util.List;

import instagram.project.entity.Topic;
import instagram.project.response.TopicResponse;

public interface TopicService {
	public Topic findByNameTopic(String name);
	public List<TopicResponse> findAll();
	public Topic findById(int id);
	public Boolean existsByNameTopic(String nameOfTopic);
	public void save(Topic topic);
	public Boolean existById(int id);
	public void delete(Topic topic);
}
