package instagram.project.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Analysis implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private String nameHashtag;
	
	@Column
	private String count;
	
	@ManyToOne
	private Topic topic;
	
	@ManyToOne
	private DateOfAnalysis dateOfAnalysis;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameHashtag() {
		return nameHashtag;
	}

	public void setNameHashtag(String nameHashtag) {
		this.nameHashtag = nameHashtag;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public DateOfAnalysis getDateOfAnalysis() {
		return dateOfAnalysis;
	}

	public void setDateOfAnalysis(DateOfAnalysis dateOfAnalysis) {
		this.dateOfAnalysis = dateOfAnalysis;
	}

	public Analysis(int id, String nameHashtag, String count, Topic topic, DateOfAnalysis dateOfAnalysis) {
		this.id = id;
		this.nameHashtag = nameHashtag;
		this.count = count;
		this.topic = topic;
		this.dateOfAnalysis = dateOfAnalysis;
	}

	public Analysis() {
	}

	@Override
	public String toString() {
		return "Analysis [id=" + id + ", nameHashtag=" + nameHashtag + ", count=" + count + ", topic=" + topic
				+ ", dateOfAnalysis=" + dateOfAnalysis + "]";
	}
	
	
}
