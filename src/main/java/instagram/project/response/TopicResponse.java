package instagram.project.response;

public class TopicResponse {
	private int id;
	private String nameTopic;
	private int active;
	
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
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public TopicResponse(int id, String nameTopic, int active) {
		this.id = id;
		this.nameTopic = nameTopic;
		this.active = active;
	}
	
	
}
