package instagram.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagram.project.entity.Topic;
import instagram.project.repository.TopicRepository;
import instagram.project.response.TopicResponse;
import instagram.project.service.TopicService;

@Service
@Transactional
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<TopicResponse> findAll() {
		List<Topic> lis = topicRepository.findAll();
		List<TopicResponse> res = new ArrayList<TopicResponse>();
		for(Topic tp : lis) {
			res.add(new TopicResponse(tp.getId(),tp.getNameTopic(),tp.getActive()));
		}
		
		return res;
	}

	@Override
	public Topic findById(int id) {
		return topicRepository.findById(id);
	}

	@Override
	public Topic findByNameTopic(String name) {
		return topicRepository.findByNameTopic(name);
	}

	@Override
	public Boolean existsByNameTopic(String nameOfTopic) {
		return topicRepository.existsByNameTopic(nameOfTopic);
	}

	@Override
	public void save(Topic topic) {
		topicRepository.save(topic);
	}

	@Override
	public Boolean existById(int id) {
		return topicRepository.existsById(id);
	}

	@Override
	public void delete(Topic topic) {
		topicRepository.delete(topic);
	}

	@Override
	public Boolean existsById(int id) {
		return topicRepository.existsById(id);
	}
	
}
