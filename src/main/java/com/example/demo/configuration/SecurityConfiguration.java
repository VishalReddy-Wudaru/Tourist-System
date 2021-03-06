package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
		.and().authorizeRequests().antMatchers("/VAADIN/**","/PUSH/**","/UIDL/**","/login","/signup","/login/**","/logout","/vaadinServlet/**").permitAll()
			.antMatchers("/ui","/ui/**").fullyAuthenticated();
		
	}
	@Bean
	public DaoAuthenticationProvider createDaoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService);
		
		return provider;
		
	}
	
}

