package com.springbootstudy.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springbootstudy.main.constants.SecurityConstant;
import com.springbootstudy.main.security.filter.MyAuthorizationFilter;
import com.springbootstudy.main.security.filter.MyUsernamePasswordAuhenticationFilter;
import com.springbootstudy.main.services.MyUserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService myUserServiceDetails;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserServiceDetails).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstant.LOGIN_URL).permitAll()
				.anyRequest().authenticated().and()
				.addFilter(new MyUsernamePasswordAuhenticationFilter(authenticationManager()))
				.addFilter(new MyAuthorizationFilter(authenticationManager()));
	}

}
