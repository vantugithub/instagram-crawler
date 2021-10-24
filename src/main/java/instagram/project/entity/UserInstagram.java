package instagram.project.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "users_ins")
public class UserInstagram implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "username")
	private String username;
	
	
	@OneToMany(mappedBy = "userInstagrams",fetch = FetchType.EAGER)
	private List<PostInstagram> posts = new ArrayList<PostInstagram>();
	

	public UserInstagram() {
	}

	public UserInstagram(int id, String user, String username, List<PostInstagram> posts) {
		this.id = id;
		this.user = user;
		this.username = username;
		this.posts = posts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<PostInstagram> getPosts() {
		return posts;
	}

	public void setPosts(List<PostInstagram> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserInstagram [id=" + id + ", user=" + user + ", username=" + username + ", posts=" + posts + "]";
	}
	
}	
