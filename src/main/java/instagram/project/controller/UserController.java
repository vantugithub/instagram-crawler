package instagram.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import instagram.project.request.ResetPasswordRequest;
import instagram.project.service.UserService;

@RestController
@RequestMapping("/api/user-management")
@CrossOrigin(origins = "*")
public class UserController {
	
	BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings({ "rawtypes"})
	@PutMapping(path = "/reset")
	public ResponseEntity resetPassword(
			@RequestBody ResetPasswordRequest resetPasswordRequest
			) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		boolean isPasswordMatched = bcryptEncoder.matches(
				resetPasswordRequest.getOldPassword(), userDetails.getPassword());
		if(isPasswordMatched) {
			userService.resetPassword(userDetails,resetPasswordRequest.getPassword());
		}else {
			return ResponseEntity.badRequest().body("Old password is not correct ");
		}
		
		return ResponseEntity.ok().body("Reseted successfully!");
	}
}
