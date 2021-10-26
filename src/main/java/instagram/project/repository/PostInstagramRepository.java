package instagram.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import instagram.project.entity.PostInstagram;

@Repository
public interface PostInstagramRepository extends JpaRepository<PostInstagram, Integer>{
	
//	String sql="SELECT products.Id,products.Name,products.Price,products.Image,MATCH (Name) "
//			+ "AGAINST (?) as score FROM products WHERE MATCH(Name) "
//			+ "AGAINST (? IN NATURAL LANGUAGE MODE) > 0.68 AND products.Status = 1 ORDER BY score DESC";
	
	@Query(value = "SELECT * FROM posts_ins WHERE "
			+ "MATCH(caption)"
			+ "AGAINST (?1)" ,nativeQuery = true)
	public Page<PostInstagram> search(String keyword,Pageable pageable);
	
	
	public Page<PostInstagram> findByCaptionContainingIgnoreCase(String keyword,Pageable pageable);
	

}
