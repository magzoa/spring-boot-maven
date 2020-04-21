package py.edu.facitec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290In0.aunKhMIE3GSK5Oy3cZ19IJbh-TwlbbrbgcScxjJBnNTxcu4zmHL0wo3GzQYlcjdMdXg0549maFxQ7u1PDyOrFA
@RestController
@RequestMapping(path="/auth")
public class AuthController {

	@GetMapping("/login/usuario/{usuario}/pass/{pass}")
	public String login(@PathVariable("usuario") String usuario, @PathVariable("pass") String pass) {
		if (usuario.equals("root") && pass.equals("admin")) {
			return Jwts.builder()
					.setSubject("root")
	                .signWith(SignatureAlgorithm.HS512, "SU_CLAVE_SECRETA")
	                .compact();
		} else {
			return null;
		}
	}
	
}
