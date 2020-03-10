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

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/suscritos")

public class SuscritoController {
	
	@Autowired
	private SuscritoRepository repository;
	
	
	@GetMapping
	public List<Suscrito> getSuscritos(){
		
	return	repository.findAll();
		
	}
	
	@PostMapping
	public Suscrito save(@RequestBody Suscrito suscrito) {
		
	return	repository.save(suscrito);
	}
	
	
	
	@PutMapping
	public Suscrito update(@RequestBody Suscrito suscrito) {
		
		return repository.save(suscrito);
	}
	
	@GetMapping("/{id}")
	public Optional<Suscrito> getSuscritoForId(@PathVariable Long id){
		
		return repository.findById(id);
		
		
	}
	
	@DeleteMapping
	public void deleteSuscrito(@RequestBody Suscrito suscrito){
		
		 repository.delete(suscrito);
		
	}
	

}
