package instagram.project.response;

public class UserResponse {
	private String fullName;
	private String userName;
	private String email;
	private int active;
	private String lastDateUpdated;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getLastDateUpdated() {
		return lastDateUpdated;
	}
	public void setLastDateUpdated(String lastDateUpdated) {
		this.lastDateUpdated = lastDateUpdated;
	}
	public UserResponse(String fullName, String userName, String email, int active, String lastDateUpdated) {
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.active = active;
		this.lastDateUpdated = lastDateUpdated;
	}
	
	
}
