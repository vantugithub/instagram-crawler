package instagram.project.response;

public class AnalysisResponse {
	private String nameHashtag;
	private String count;
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
	public AnalysisResponse() {
	}
	public AnalysisResponse(String nameHashtag, String count) {
		this.nameHashtag = nameHashtag;
		this.count = count;
	}
	
	
	
}
