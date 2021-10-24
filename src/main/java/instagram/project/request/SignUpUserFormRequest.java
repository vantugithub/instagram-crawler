package instagram.project.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpUserFormRequest {
	@NotBlank
	@Size(min=2, max = 50)
	private String firstName;
	
	@NotBlank
	@Size(min=3, max = 50)
	private String lastName;
	
	@NotBlank
    @Size(min=3, max = 50)
	private String username;
	
	@NotBlank
    @Size(min=3, max = 50)
	private String password;
	
	@NotBlank
    @Size(min=10, max = 50)
	private String email;
	
	@NotBlank
    @Size(min=3, max = 100)
	private String address;

	public SignUpUserFormRequest(@NotBlank @Size(min = 2, max = 50) String firstName,
			@NotBlank @Size(min = 3, max = 50) String lastName, @NotBlank @Size(min = 3, max = 50) String username,
			@NotBlank @Size(min = 3, max = 50) String password, @NotBlank @Size(min = 10, max = 50) String email,
			@NotBlank @Size(min = 3, max = 100) String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public SignUpUserFormRequest() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
