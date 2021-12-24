package instagram.project.response;

import java.util.List;

public class ListAnalysisResponse<T> {
	private List<T> listAnalysis;
	private String date;
	public List<T> getListAnalysis() {
		return listAnalysis;
	}
	public void setListAnalysis(List<T> listAnalysis) {
		this.listAnalysis = listAnalysis;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ListAnalysisResponse() {
	}
	public ListAnalysisResponse(List<T> listAnalysis, String date) {
		this.listAnalysis = listAnalysis;
		this.date = date;
	}
	
	
}
