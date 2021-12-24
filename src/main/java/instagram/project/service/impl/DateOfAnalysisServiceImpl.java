package instagram.project.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import instagram.project.entity.DateOfAnalysis;
import instagram.project.repository.DateOfAnalysisRepository;
import instagram.project.service.DateOfAnalysisService;

@Service
@Transactional
public class DateOfAnalysisServiceImpl implements DateOfAnalysisService{

	
	@Autowired
	private DateOfAnalysisRepository analysisRepository;
	
	@Override
	public List<DateOfAnalysis> findDateOfAnalysisByStartDateAndEndDate(String startDate, String endDate) {
		
		return analysisRepository.findDateOfAnalysisByStartDateAndEndDate(startDate, endDate);
	}

	@Override
	public List<DateOfAnalysis> findAll() {
		// TODO Auto-generated method stub
		return analysisRepository.findAll();
	}

}
