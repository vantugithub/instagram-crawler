package instagram.project.response;

public class JwtTokenResponse {

	private String token;
    private String username;
    private String roleName;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public JwtTokenResponse(String token, String username, String roleName) {
		this.token = token;
		this.username = username;
		this.roleName = roleName;
	}
	
    
    
  
}