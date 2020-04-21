package py.edu.facitec;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import py.edu.facitec.filter.JWTFilter;


@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CorsFilter corsFilter;
	
	@Override
  	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
		
	    http
		.csrf().disable()
	 	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	
		.and()
		    .exceptionHandling()
		    .authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)) 	
		.and()
		   .addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		   .antMatchers(HttpMethod.GET,"/").permitAll()
		   .antMatchers(HttpMethod.GET,"/archivo/**").permitAll()
		   .anyRequest().authenticated()
	    .and()
           .formLogin().disable();
	}
	
}
