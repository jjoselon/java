package com.mifuturoempleo.demo;

import com.mifuturoempleo.beans.BeanOne;
import com.mifuturoempleo.beans.BeanTwo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // to enable Spring Security’s
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * Defines which URL paths should be secured and which should not. 
	 * Specifically, the /security/home and /security/aboutus paths are configured to not require any authentication.
	 * All other paths must be authenticated.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/security/home", "/security/aboutus").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin().defaultSuccessUrl("/security/private-area", true) // https://stackoverflow.com/questions/36243352/how-to-set-redirection-after-successful-login
				.loginPage("/security/login") // login page path
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	/**
	 * Sets up an in-memory user store with a single user. 
	 * That user is given a user name of user, a password of password, and a role of USER.
	*/
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

	@Bean(initMethod = "init")
	public BeanOne beanOne() {
		return new BeanOne();
	}

	@Bean(destroyMethod = "cleanup")
	public BeanTwo beanTwo() {
		return new BeanTwo();
	}

}