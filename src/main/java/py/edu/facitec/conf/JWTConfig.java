

package py.edu.facitec.conf;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import py.edu.facitec.filter.TokenFilter;
@Configuration
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
		   .addFilterAfter(new TokenFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		 .anyRequest().authenticated()
		   .and()
   		.formLogin().disable();
	    
	  // http.addFilterAfter(new TokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //http.headers().frameOptions().disable();
	}
	

	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers(HttpMethod.GET,"/");
		web.ignoring().antMatchers(HttpMethod.GET,"/form");
		web.ignoring().antMatchers("/lib/**");
		web.ignoring().antMatchers("/**/**.ico**");
		web.ignoring().antMatchers("/autenticar");
	}
	
//	.antMatchers("/*.js").permitAll()
}
