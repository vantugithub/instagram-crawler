package instagram.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagram.project.entity.UserInstagram;
import instagram.project.repository.UserInstagramRepository;
import instagram.project.response.PagedResponse;
import instagram.project.response.PostInstagramResponse;
import instagram.project.service.PostService;
import instagram.project.utils.AppConstants;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserInstagramRepository userInstagramRepository;
	
	@GetMapping
	public PagedResponse<PostInstagramResponse> getAllPhotos(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return postService.getAllPosts(page, size);
	}
	
	@PostMapping
	public ResponseEntity<Void> createUserIns(){
		userInstagramRepository.save(new UserInstagram(0, "van tu","vantu", null));
		return ResponseEntity.ok().build();
		
	}
}
