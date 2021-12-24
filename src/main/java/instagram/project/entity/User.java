package instagram.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {

	private static final long serialVersionUID = -6109789394548885438L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private int active;
	

	public int isActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public Long getId() {
		return id;
	}


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

	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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



	public void setId(Long id) {
		this.id = id;
	}


	public User(Long id, String fullName, String username, String password, String email, int active,
			Set<Role> roles) {
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}

	public User(String fullName, String username, String password, String email, int active,
			Set<Role> roles) {
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}
	

	
	
}
