package py.edu.facitec.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;

@RestController
public class FormularioController {
	
	@Autowired
	private PostRepository postRepository;
	
	
	@RequestMapping(value = "/formulario",method = RequestMethod.GET)
	public ModelAndView formulario() {
		
		
		ModelAndView modelAnd=new ModelAndView("form");
		System.out.println("Ingreso a formulario");
		//modelAnd.setViewName("form Suscrito");
		
		
		return modelAnd;
		
	}
	
	
	
	@RequestMapping(value = "/registrar",method = RequestMethod.GET)
	public ModelAndView registrar(Post post) {
		
		
		post.setFecha(LocalDate.now());
		
		postRepository.save(post);
		
		
		ModelAndView modelAnd=new ModelAndView("redirect:formulario");
		
		System.out.println("Ingreso a registrar"+post.toString());
		//modelAnd.setViewName("form Suscrito");
		
		
		return modelAnd;
		
	}
	
	
	@GetMapping(value = "/listar")
	public Iterable<Post> listar() {

		
		Iterable<Post> postList=postRepository.findAll();
		
		System.out.println("Listado de documentos");
		
		return postList;
		
	}

}
