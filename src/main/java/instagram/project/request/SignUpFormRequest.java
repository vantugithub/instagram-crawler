package instagram.project.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpFormRequest {
    
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
	

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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

	private Set<String> role;
	
	public Set<String> getRole() {
    	return this.role;
    }
    
    public void setRole(Set<String> role) {
    	this.role = role;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
