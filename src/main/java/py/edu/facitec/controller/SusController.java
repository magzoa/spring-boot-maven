package py.edu.facitec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

@Controller
public class SusController {
	
	@Autowired
	private SuscritoRepository suscritoRepository;
	
	
	@RequestMapping(value = "/acceder_pagina",method = RequestMethod.GET)
	public String formulario() {
		
		System.out.println("Ingreso a formulario");
		//modelAnd.setViewName("form Suscrito");
		
		
		return "suscrito/form";
		
	}
	
	
	
	@RequestMapping(value = "/registrar_suscrito",method = RequestMethod.GET)
	public ModelAndView registrar(Suscrito suscrito) {
		
		
		suscritoRepository.save(suscrito);
		
		
		ModelAndView modelAnd=new ModelAndView("redirect:acceder_pagina");
		
		System.out.println("Ingreso a registrar"+suscrito.toString());
		//modelAnd.setViewName("form Suscrito");
		
		
		return modelAnd;
		
	}
	
	


}
