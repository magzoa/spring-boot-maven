package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	
	@RequestMapping("/")
	public String index() {
		
		
		System.out.println("Cargando página de inicio");
	    return "index";
	}
}
