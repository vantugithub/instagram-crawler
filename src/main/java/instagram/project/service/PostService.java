package instagram.project.service;

import instagram.project.response.PagedResponse;
import instagram.project.response.PostInstagramResponse;

public interface PostService {
	public PagedResponse<PostInstagramResponse> getAllPosts(int page,int size);
	public PagedResponse<PostInstagramResponse> searchByCaption(String key, int page, int size);
}
