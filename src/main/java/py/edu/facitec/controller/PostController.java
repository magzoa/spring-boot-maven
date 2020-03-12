package py.edu.facitec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;


@RestController
@RequestMapping("/posts")
public class PostController extends GenericController<Post, Long>{
	
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public PagingAndSortingRepository<Post, Long> getRepository() {
		// TODO Auto-generated method stub
		return postRepository;
	}
	
	
	@GetMapping("/autor/{autor}")
	public List<Post> buscarPorNome(@PathVariable("autor") String autor) {
		return postRepository.findByAutor(autor);
	}
	
	
	
	

}
