package instagram.project.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private String nameTopic;
	
	@Column
	private int active;
	
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Analysis> getAnalysises() {
		return analysises;
	}

	public void setAnalysises(Set<Analysis> analysises) {
		this.analysises = analysises;
	}

	@OneToMany(mappedBy = "topics",fetch = FetchType.LAZY)
	private Set<PostInstagram> posts = new HashSet<PostInstagram>();
	
	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
	private Set<Analysis> analysises = new HashSet<Analysis>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameTopic() {
		return nameTopic;
	}

	public void setNameTopic(String nameTopic) {
		this.nameTopic = nameTopic;
	}

	public Set<PostInstagram> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostInstagram> posts) {
		this.posts = posts;
	}

	public Topic() {
	}

	public Topic(int id, String nameTopic, Set<PostInstagram> posts, Set<Analysis> analysises) {
		this.id = id;
		this.nameTopic = nameTopic;
		this.posts = posts;
		this.analysises = analysises;
	}

	public Topic(int id, String nameTopic, int active, Set<PostInstagram> posts, Set<Analysis> analysises) {
		this.id = id;
		this.nameTopic = nameTopic;
		this.active = active;
		this.posts = posts;
		this.analysises = analysises;
	}

	public Topic(String nameTopic) {
		this.nameTopic = nameTopic;
	}
	
	
}
