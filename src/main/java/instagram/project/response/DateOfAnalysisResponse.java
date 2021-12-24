package instagram.project.response;

import java.util.List;

public class DateOfAnalysisResponse<T> {
	private List<T> listDate;

	public DateOfAnalysisResponse() {
	}

	public DateOfAnalysisResponse(List<T> listDate) {
		this.listDate = listDate;
	}

	public List<T> getListDate() {
		return listDate;
	}

	public void setListDate(List<T> listDate) {
		this.listDate = listDate;
	}
	
}
