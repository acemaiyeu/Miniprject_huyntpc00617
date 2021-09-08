package com.poy.J6_Huyntpc00617.Service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Accounts;
import com.poy.J6_Huyntpc00617.dao.AccountDAO;
import com.poy.J6_Huyntpc00617.dao.AuthDAO;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	AccountDAO acdao;
	@Autowired
	AuthDAO authdao;
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Accounts account = acdao.findById(username).get();
			//Taoj userDetails tu account
			String password = account.getPassword();
//			System.out.println("1: "+list.size());
			String[] roles = authdao.findAll().stream().map(au -> au.getRole().getId()).collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username).password(pe.encode(password)).roles(roles).build();
		} catch (Exception e) {
			System.out.println("Errorr");
			e.printStackTrace();
			throw new UsernameNotFoundException(username + "notfound");
		}
		
	}

	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
		//String fullname = oauth2.getPrincipal().getAttribute("name");
		String email =  oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());
		UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("USER").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
}
