package instagram.project.service;

import java.util.List;

import instagram.project.entity.Analysis;
import instagram.project.entity.DateOfAnalysis;
import instagram.project.entity.Topic;
import instagram.project.response.AnalysisResponse;
import instagram.project.response.ListAnalysisResponse;

public interface AnalysisService {
public List<Analysis> findByDateOfAnalysisAndTopic(DateOfAnalysis dateOfAnalysis, Topic topic);
	
	public List<Analysis> findByDateOfAnalysisIdAndTopicId(int idDate, int idTopic);
	public List<ListAnalysisResponse<AnalysisResponse>> fetchAnalysis(String startdate, String endDate, String nameTopic);
}
