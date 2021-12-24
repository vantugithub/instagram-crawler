package instagram.project.response;

public class TopicResponse {
	private int id;
	private String nameTopic;
	public TopicResponse() {
	}
	public TopicResponse(int id, String nameTopic) {
		this.id = id;
		this.nameTopic = nameTopic;
	}
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
	
}
