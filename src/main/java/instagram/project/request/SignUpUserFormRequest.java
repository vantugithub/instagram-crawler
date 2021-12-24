package instagram.project.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpUserFormRequest {
	@NotBlank
	@Size(min=2, max = 50)
	private String fullName;
	
	@NotBlank
    @Size(min=3, max = 50)
	private String username;
	
	@NotBlank
    @Size(min=3, max = 50)
	private String password;
	
	@NotBlank
    @Size(min=10, max = 50)
	private String email;
	
	

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public SignUpUserFormRequest() {
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
