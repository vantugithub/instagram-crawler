package instagram.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import instagram.project.response.PagedResponse;
import instagram.project.response.PostInstagramResponse;
import instagram.project.service.PostService;
import instagram.project.utils.AppConstants;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	private PostService postService;
	
	
	@GetMapping
	public PagedResponse<PostInstagramResponse> getAllPhotos(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return postService.getAllPosts(page, size);
	}
	
	@GetMapping
	public PagedResponse<PostInstagramResponse> search(
			@RequestParam(name = "key", required = true ) String key,
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return postService.searchByCaption(key, page, size);
	}
	
}
