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
public class DateOfAnalysis implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column
	private String date;
	
	@OneToMany(mappedBy = "dateOfAnalysis",fetch = FetchType.EAGER)
	private Set<Analysis> Analysises = new HashSet<Analysis>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public DateOfAnalysis() {
	}

	public DateOfAnalysis(int id, String date) {
		this.id = id;
		this.date = date;
	}
	
	
}
