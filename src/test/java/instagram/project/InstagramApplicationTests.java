package instagram.project;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.google.gson.Gson;

import instagram.project.entity.Analysis;
import instagram.project.entity.DateOfAnalysis;
import instagram.project.entity.PostInstagram;
import instagram.project.entity.Topic;
import instagram.project.entity.UserInstagram;
import instagram.project.repository.AnalysisRepository;
import instagram.project.repository.DateOfAnalysisRepository;
import instagram.project.repository.PostInstagramRepository;
import instagram.project.repository.TopicRepository;
import instagram.project.repository.UserInstagramRepository;
import instagram.project.repository.UserRepository;
import instagram.project.response.PagedResponse;
import instagram.project.response.PostInstagramResponse;
import instagram.project.service.PostService;
import instagram.project.service.impl.AnalysisServiceImpl;

@SpringBootTest(classes = InstagramApplication.class)
class InstagramApplicationTests {
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AnalysisRepository analysisRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private DateOfAnalysisRepository dateOfAnalysisRepository;

	@Autowired
	private UserInstagramRepository userInstagramRepository;
	
	@Autowired
	private PostInstagramRepository postInstagramRepository;
	
	@Test
	public void testAnalysis() {
		
		
		
		Optional<Topic> topic = Optional.of(topicRepository.findById(1));
		Optional<DateOfAnalysis> date = dateOfAnalysisRepository.findById(3);
		List<Analysis> lis = analysisRepository.findByDateOfAnalysisIdAndTopicId(date.get().getId(), topic.get().getId());
		logger.info("Analysis : -> {}" , lis);
	}
	
	

	@Test
	public void testSearch() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<UserInstagram> users = userInstagramRepository.findAll(pageable);
		
//		users.forEach(System.out::println);
		for (UserInstagram i : users) {
			System.err.println(i.getPosts());
		}
		
//		logger.info("total page : -> {}" , users.isLast());
		
	}
	
	@Test
	public void tesst() {
		Optional<UserInstagram> instagram  = userInstagramRepository.findById(15);
		logger.info("list -> {}", instagram.get().getPosts());
		
	}
	
	
	@Test
	@Transactional
	public void testSeacrhFullText() {
		
		Pageable pageable = PageRequest.of(0, 10);
		Page<PostInstagram> posts = postInstagramRepository.search("squidgame",pageable);
		posts.forEach(System.out::println);
		logger.info("is lasted page -> {}", posts.getContent().get(0).getUserInstagrams().getUsername());
		
		    
	}
	
	@Autowired
	private PostService postService;
	
	@Test
	@Transactional
	public void testPaged() {
		PagedResponse<PostInstagramResponse> getAllPhotos = postService.getAllPosts(0, 9);
		logger.info("list -> {}", getAllPhotos.getContent());
	}
	
	
	

}
