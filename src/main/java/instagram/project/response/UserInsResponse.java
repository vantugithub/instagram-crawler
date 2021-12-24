package instagram.project.response;

public class UserInsResponse {
	private String user;
	
	private String username;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserInsResponse(String user, String username) {
		this.user = user;
		this.username = username;
	}

	public UserInsResponse() {
	}

	@Override
	public String toString() {
		return "UserResponse [user=" + user + ", username=" + username + "]";
	}
	
	
}
