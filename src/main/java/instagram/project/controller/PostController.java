package instagram.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagram.project.entity.DateOfAnalysis;
import instagram.project.response.AnalysisResponse;
import instagram.project.response.DateOfAnalysisResponse;
import instagram.project.response.ListAnalysisResponse;
import instagram.project.response.PagedResponse;
import instagram.project.response.PostInstagramResponse;
import instagram.project.response.TopicResponse;
import instagram.project.service.AnalysisService;
import instagram.project.service.DateOfAnalysisService;
import instagram.project.service.PostService;
import instagram.project.service.TopicService;
import instagram.project.utils.AppConstants;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private AnalysisService analysisService;
	
	@Autowired
	private DateOfAnalysisService dateOfAnalysisService;
	
	@GetMapping
	public PagedResponse<PostInstagramResponse> getAllPosts(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return postService.getAllPosts(page, size);
	}
	
	@GetMapping(path = "/search")
	public PagedResponse<PostInstagramResponse> search(
			@RequestParam(name = "key") String key,@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return postService.findByCaptionContainingIgnoreCase(key, page, size);
	}
	
	
	@GetMapping(path= "/analysis", produces ={"application/json"})
	public List<ListAnalysisResponse<AnalysisResponse>> analysis (
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate,
			@RequestParam(name = "nameTopic", required = false) String nameTopic
			){
		
		return analysisService.fetchAnalysis(startDate, endDate, nameTopic);
	}
	
	@GetMapping(path ="/dates")
	public ResponseEntity<DateOfAnalysisResponse<DateOfAnalysis>> getAllDates(){
		DateOfAnalysisResponse<DateOfAnalysis> res= new DateOfAnalysisResponse<>();
		res.setListDate(dateOfAnalysisService.findAll());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping(path="/topics", produces ={"application/json"})
	public List<TopicResponse> getAllTopics(){
		return topicService.findAll();
	}
	
}
