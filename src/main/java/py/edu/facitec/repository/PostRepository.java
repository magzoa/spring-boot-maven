package py.edu.facitec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import py.edu.facitec.model.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	public List<Post> findByAutor(String autor);
	public List<Post> findByAutorContaining(String autor);
	
	@Query("select a from Post a")
	public List<Post> metodoComJPQL();
	
	@Query(value = "select * from post", nativeQuery = true)
	public List<Post> metodoComSQL();
}
