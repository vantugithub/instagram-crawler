package instagram.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import instagram.project.entity.PostInstagram;
import instagram.project.repository.PostInstagramRepository;
import instagram.project.response.PagedResponse;
import instagram.project.response.PostInstagramResponse;
import instagram.project.response.UserResponse;
import instagram.project.service.PostService;
import instagram.project.utils.AppConstants;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostInstagramRepository postInstagramRepository;

	@Override
	public PagedResponse<PostInstagramResponse> getAllPosts(int page,int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<PostInstagram> posts = postInstagramRepository.findAll(pageable);
		
		List<PostInstagramResponse> postResponses = new ArrayList<>(posts.getContent().size());
		for (PostInstagram post : posts.getContent()) {
			ObjectMapper Obj = new ObjectMapper();
			UserResponse userResponse = new UserResponse(post.getUserInstagrams().getUser(),post.getUserInstagrams().getUsername());
			String jsonStr = post.getUserInstagrams().getUser();
			try {
				jsonStr = Obj.writeValueAsString(userResponse);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			postResponses.add(new PostInstagramResponse(post.getId(),post.getIdUser(),post.getCodeCaption(),post.getCaption(),jsonStr));
		}
		
		return new PagedResponse<>(postResponses, posts.getNumber(), posts.getSize(), posts.getTotalElements(),
				posts.getTotalPages(), posts.isLast());
	}

	@Override
	public PagedResponse<PostInstagramResponse> findByCaptionContainingIgnoreCase(String key) {
		String page = AppConstants.DEFAULT_PAGE_NUMBER;
		String size = AppConstants.DEFAULT_PAGE_SIZE;
		Pageable pageable = PageRequest.of(Integer. valueOf(page), Integer. valueOf(size));
		Page<PostInstagram> posts = postInstagramRepository.findByCaptionContainingIgnoreCase(key, pageable);
		List<PostInstagramResponse> postResponses = new ArrayList<>(posts.getContent().size());
		for (PostInstagram post : posts.getContent()) {
			ObjectMapper Obj = new ObjectMapper();
			UserResponse userResponse = new UserResponse(post.getUserInstagrams().getUser(),post.getUserInstagrams().getUsername());
			String jsonStr = post.getUserInstagrams().getUser();
			try {
				jsonStr = Obj.writeValueAsString(userResponse);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			postResponses.add(new PostInstagramResponse(post.getId(),post.getIdUser(),post.getCodeCaption(),post.getCaption(),jsonStr));
		}
		
		return new PagedResponse<>(postResponses, posts.getNumber(), posts.getSize(), posts.getTotalElements(),
				posts.getTotalPages(), posts.isLast());
	}
	
}
