package instagram.project.service;

import org.springframework.security.core.userdetails.UserDetails;

import instagram.project.request.ResetPasswordRequest;
import instagram.project.response.PagedResponse;
import instagram.project.response.UserResponse;

public interface UserService {
	void updateImageProfile(String urlImage,String username);
	public void save(long id);
	public void delete(long id);
	public Boolean existsById(long id);
	public PagedResponse<UserResponse> findAll(int page,int size);
	public void resetPassword(UserDetails userDetails,String newPassword);
	public void resetPasswordAdmin(ResetPasswordRequest resetPasswordRequest);
}
