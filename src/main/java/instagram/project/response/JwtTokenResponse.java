package instagram.project.response;

public class JwtTokenResponse {

	private String token;
    private String username;
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
	public JwtTokenResponse(String token,String username) {
		super();
		this.token = token;
		this.username = username;
	}
    
    
  
}