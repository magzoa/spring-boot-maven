package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comentarios")

public class ComentarioController {
	
	@Autowired
	private ComentarioRepository repository;
	
	
	@GetMapping
	public List<Comentario> getComentarios(){
		
	return	repository.findAll();
		
	}
	
	@PostMapping
	public Comentario save(@RequestBody Comentario comentario) {
		
	return	repository.save(comentario);
	}
	
	
	
	@PutMapping
	public Comentario update(@RequestBody Comentario comentario) {
		
		return repository.save(comentario);
	}
	
	@GetMapping("/{id}")
	public Optional<Comentario> getComentarioForId(@PathVariable Long id){
		
		return repository.findById(id);
		
		
	}
	
	@DeleteMapping
	public void deleteComentario(@RequestBody Comentario comentario){
		
		 repository.delete(comentario);
		
	}
	

}
