package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Accounts;
import com.poy.J6_Huyntpc00617.Service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountsRestController {
	@Autowired AccountService accountservice;
	
	@GetMapping
	public List<Accounts> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return accountservice.getAdministrators();
		}
		return accountservice.findAll();
	}
	
//	@GetMapping()
//	public List<Accounts> getAll(){
//		return accountservice.findAll();
//	}
	@PostMapping()
	public Accounts create(@RequestBody Accounts account) {
		return accountservice.create(account);
		};
	@PutMapping()
	public Accounts Update(@RequestBody Accounts account) {
		return accountservice.update(account);
	}
	@DeleteMapping("/delete/{username}")
	public void Delete(@PathVariable("username") String username) {
		 accountservice.delete(username);
	}
	@GetMapping("{username}")
	public Accounts GetOne(@PathVariable("username") String username) {
		 return accountservice.findById(username);
	}
	
	@PostMapping("/facebookorgooogle")
	public Accounts CreateAccountByFacebookOrGooogle(@RequestBody Accounts accounts){
		
		String username = accounts.getUsername();
		Accounts ac = accountservice.findById(username);
		if(ac == null) {
			 ac = accountservice.create(accounts);
			 System.out.println("facebookorgooogle"+accountservice.findById(username));
		}
		System.out.println("Ac: "+ac);
		return new Accounts();
	}
}
