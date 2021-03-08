package com.cts.authorization.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
	
		auth.jdbcAuthentication()
		.withUser("utsav")
		.password(passwordEncoder().encode("pwd"))
		.roles("ADMIN")
		
		.and()
		
		.withUser("abc")
		.password(passwordEncoder().encode("abc123"))
		.roles("USER");		
		
	}
	
	
	
       @Bean
	 public PasswordEncoder passwordEncoder() {   
    	   return new BCryptPasswordEncoder();
    	 	   
       }
	  
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		
		
		httpSecurity.csrf().disable().httpBasic()	
		.and()		
		.authorizeRequests()		
		//.antMatchers("/employees/dummy").hasRole("USER");
		.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
		.antMatchers("/home").hasAnyRole("USER", "ADMIN")
		.antMatchers("/").hasAnyRole("USER", "ADMIN")
		.antMatchers("/admin").hasAnyRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER")
		
		.anyRequest().authenticated()	
		.and()	
		.addFilter(new JwtAuthorizationFilter(authenticationManager())); 
		
	}

}
