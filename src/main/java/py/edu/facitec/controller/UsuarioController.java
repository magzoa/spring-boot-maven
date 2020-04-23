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

import py.edu.facitec.model.Usuario;
import py.edu.facitec.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		
	return	repository.findAll();
		
	}
	
	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		
		System.out.println("Usuario registrado"+usuario);
		
		
	return	repository.save(usuario);
	}
	
	
	
	@PutMapping
	public Usuario update(@RequestBody Usuario usuario) {
		
		return repository.save(usuario);
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> getUsuarioForId(@PathVariable Long id){
		
		return repository.findById(id);
		
		
	}
	
	@DeleteMapping
	public void deleteUsuario(@RequestBody Usuario usuario){
		
		 repository.delete(usuario);
		
	}
	

}
