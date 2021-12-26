package instagram.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagram.project.entity.Topic;
import instagram.project.request.TopicRequest;
import instagram.project.response.PagedResponse;
import instagram.project.response.TopicResponse;
import instagram.project.response.UserResponse;
import instagram.project.service.TopicService;
import instagram.project.service.UserService;
import instagram.project.utils.AppConstants;

@RestController
@RequestMapping("/api/admin-management")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/topics")
	public ResponseEntity createTopic(@RequestBody TopicRequest topicRequest  ) {
		String name = topicRequest.getNameTopic().replaceAll(" ", "").toLowerCase();
		if(topicService.existsByNameTopic(name)) {
			return new ResponseEntity("Fail -> Name of topic is already in use!",
	                  HttpStatus.BAD_REQUEST);
		}
		topicService.save(new Topic(name));
		
		return ResponseEntity.ok().body("Created successfully!");
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/topics/{id}")
	public ResponseEntity updateTopic(@RequestParam(name = "id", required = true) int id) {
		
		if(!topicService.existsById(id)) {
			return new ResponseEntity("Fail -> name of topic doesn't exist!",
	                  HttpStatus.BAD_REQUEST);
		}
		Topic topic = topicService.findById(id);
		if(topic.getActive()==1) {
			topic.setActive(0);
		}else {
			topic.setActive(1);
		}
		topicService.save(topic);
		
		return ResponseEntity.ok().body("Updated successfully!");
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/topics/{id}")
	public ResponseEntity deleteTopic(@PathVariable("id") int idTopic)
	{
		if(!topicService.existById(idTopic)) {
			return new ResponseEntity("Faid -> id of topic doesn't exist!",
					HttpStatus.BAD_REQUEST);
		}
		Topic topic =  topicService.findById(idTopic);
		topicService.delete(topic);
		return ResponseEntity.ok().body("Deleted successfully!");
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/users/{id}")
	public ResponseEntity deleteUser(@PathVariable("id") long id) {
		
		if(!userService.existsById(id)) {
			return new ResponseEntity("Fail -> id user doesn't exist!",
					HttpStatus.BAD_REQUEST);
		}
		userService.delete(id);
		
		return ResponseEntity.ok().body("Deleted successfully!");
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/users/{id}")
	public ResponseEntity updateUser(@PathVariable("id") long id) {
		if(!userService.existsById(id)) {
			return new ResponseEntity("Fail -> id user doesn't exist!",
					HttpStatus.BAD_REQUEST);
		}
		userService.save(id);
		return ResponseEntity.ok().body("Updated successfully!");
	}
	
	@GetMapping(path="/users", produces ={"application/json"})
	public PagedResponse<UserResponse> getAllUsers(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return userService.findAll(page, size);
	}
	
	@GetMapping("/topics")
	public List<TopicResponse> getAllTopics(){
		return topicService.findAll();
	}
	
}
