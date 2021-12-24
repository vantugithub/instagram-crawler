package instagram.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagram.project.entity.Analysis;
import instagram.project.entity.DateOfAnalysis;
import instagram.project.entity.Topic;
import instagram.project.repository.AnalysisRepository;
import instagram.project.repository.DateOfAnalysisRepository;
import instagram.project.repository.TopicRepository;
import instagram.project.response.AnalysisResponse;
import instagram.project.response.ListAnalysisResponse;
import instagram.project.service.AnalysisService;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService{
	
	@Autowired
	private AnalysisRepository analysisRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private DateOfAnalysisRepository dateOfAnalysisRepository;

	@Override
	public List<Analysis> findByDateOfAnalysisAndTopic(DateOfAnalysis dateOfAnalysis, Topic topic) {
		
		return analysisRepository.findByDateOfAnalysisAndTopic(dateOfAnalysis, topic);
	}

	@Override
	public List<Analysis> findByDateOfAnalysisIdAndTopicId(int idDate, int idTopic) {
		return analysisRepository.findByDateOfAnalysisIdAndTopicId(idDate, idTopic);
	}

	@Override
	public List<ListAnalysisResponse<AnalysisResponse>> fetchAnalysis(String startdate, String endDate, String nameTopic) {
		
		List<DateOfAnalysis> listDate = dateOfAnalysisRepository.findDateOfAnalysisByStartDateAndEndDate(startdate, endDate);
		Topic topic = topicRepository.findByNameTopic(nameTopic);
		List<ListAnalysisResponse<AnalysisResponse>> listRes = new ArrayList<ListAnalysisResponse<AnalysisResponse>>();
		
		for(DateOfAnalysis dte : listDate) {
			
			ListAnalysisResponse<AnalysisResponse> lisTemp = new ListAnalysisResponse<AnalysisResponse>();
			List<Analysis> lisAna = analysisRepository.findByDateOfAnalysisAndTopic(dte, topic);
			List<AnalysisResponse> anaRes = new ArrayList<AnalysisResponse>();
			for(Analysis analysis : lisAna) {
				anaRes.add(new AnalysisResponse(analysis.getNameHashtag(),analysis.getCount()));
			}
			lisTemp.setListAnalysis(anaRes);
			lisTemp.setDate(dte.getDate());
			listRes.add(lisTemp);
		}
		
		return listRes;
	}

	
	
}
