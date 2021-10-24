package instagram.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity(name = "posts_ins")
public class PostInstagram implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "iduser")
	private int idUser;
	
	@Column(name = "codecaption")
	private String codeCaption;
	
	@Column(name = "caption")
	@Type(type = "text")
	private String caption;
	
	@ManyToOne
	private UserInstagram userInstagrams;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCodeCaption() {
		return codeCaption;
	}

	public void setCodeCaption(String codeCaption) {
		this.codeCaption = codeCaption;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public UserInstagram getUserInstagrams() {
		return userInstagrams;
	}

	public void setUserInstagrams(UserInstagram userInstagrams) {
		this.userInstagrams = userInstagrams;
	}

	public PostInstagram(int id, int idUser, String codeCaption, String caption, UserInstagram userInstagrams) {
		this.id = id;
		this.idUser = idUser;
		this.codeCaption = codeCaption;
		this.caption = caption;
		this.userInstagrams = userInstagrams;
	}

	public PostInstagram() {
	}

	@Override
	public String toString() {
		return "PostInstagram [idUser=" + idUser + ", caption=" + caption + "]";
	}

	
	
	
}
