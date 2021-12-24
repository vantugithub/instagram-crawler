package instagram.project.service;

import java.util.List;

import instagram.project.entity.DateOfAnalysis;

public interface DateOfAnalysisService {
	public List<DateOfAnalysis> findDateOfAnalysisByStartDateAndEndDate(String startDate, String endDate);
	public List<DateOfAnalysis> findAll();
}
