package instagram.project.service;

import instagram.project.response.PagedResponse;
import instagram.project.response.UserResponse;

public interface UserService {
	void updateImageProfile(String urlImage,String username);
	public void save(long id);
	public void delete(long id);
	public Boolean existsById(long id);
	public PagedResponse<UserResponse> findAll(int page,int size);
}
