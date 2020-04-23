package py.edu.facitec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import py.edu.facitec.filter.TokenFilter;


@SpringBootApplication
public class SpringBootMavenApplication  {

//	Autenticación de seguridad 21042020
/*@Bean
	public FilterRegistrationBean<TokenFilter> filtroJwt(){
		FilterRegistrationBean<TokenFilter> frb = new FilterRegistrationBean<TokenFilter>();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
	}*/
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMavenApplication.class, args);
	}
	
	
	

}
