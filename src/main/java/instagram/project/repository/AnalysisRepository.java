package instagram.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import instagram.project.entity.Analysis;
import instagram.project.entity.DateOfAnalysis;
import instagram.project.entity.Topic;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Integer>{
	
	public List<Analysis> findByDateOfAnalysisAndTopic(DateOfAnalysis dateOfAnalysis, Topic topic);
	
	public List<Analysis> findByDateOfAnalysisIdAndTopicId(int idDate, int idTopic);
}
