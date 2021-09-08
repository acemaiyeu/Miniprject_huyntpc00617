package com.poy.J6_Huyntpc00617;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poy.J6_Huyntpc00617.Service.AccountService;
import com.poy.J6_Huyntpc00617.Service.UserService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired AccountService accountservice;
	@Autowired UserService userService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
			auth.userDetailsService(userService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().cors().disable();
		http.authorizeRequests()
		.antMatchers("/order/**").authenticated()
		.antMatchers("/admin/**").hasAnyRole("PM","ADMIN")
		.antMatchers("/rest/authorities").hasRole("ADMIN").anyRequest().permitAll();
		
		http.formLogin()
		.loginPage("/auth/login/form")
		.loginProcessingUrl("/auth/login")
//		.defaultSuccessUrl("/auth/login/success", false)
		.defaultSuccessUrl("/home/index", false)
		.failureUrl("/auth/login/error");
		
		http.rememberMe()
		.tokenValiditySeconds(86400);
		
		http.exceptionHandling()
		.accessDeniedPage(null);
		
		http.logout()
		.logoutUrl("/auth/logoff")
//		.logoutSuccessUrl("/auth/logoff/success");
		.logoutSuccessUrl("/home/index");
		//Mạng xã hội
		http.oauth2Login()
		.loginPage("/auth/login/form")
//		.defaultSuccessUrl("/oauth2/login/success", true)
		.defaultSuccessUrl("/home/index", true)
		.failureUrl("/auth/login/error")
		.authorizationEndpoint()
		.baseUri("/oauth2/authorization");		
	}
	
	//Cơ chế mã hóa mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Cho phép truy xuất Rest API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
	
}

