package instagram.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import instagram.project.entity.DateOfAnalysis;

@Repository
public interface DateOfAnalysisRepository extends JpaRepository<DateOfAnalysis, Integer>{
	
	@Query(value = "select * from date_of_analysis group by date_of_analysis.id having date >= ?1 and date <= ?2" ,
			nativeQuery = true)
	public List<DateOfAnalysis> findDateOfAnalysisByStartDateAndEndDate(String startDate, String endDate);
}
