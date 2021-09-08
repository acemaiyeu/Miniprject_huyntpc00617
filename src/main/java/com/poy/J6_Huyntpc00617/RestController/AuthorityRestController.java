package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.*;
import com.poy.J6_Huyntpc00617.Service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
@Autowired AuthorityService auService;
	
	@GetMapping()
	public List<Auth> getAll(@RequestParam("admin") Optional<Boolean> admin){
		System.out.println("Admin: -------------------------------");
		if(admin.orElse(false)) {
			return auService.findAuthoritiesOfAdministrators();
		}
		return auService.findAll();
	}
	@PostMapping()
	public Auth create(@RequestBody Auth authority) {
		System.out.println(authority);
;		return auService.save(authority);
	}
	@DeleteMapping("{id}")
	public void Delete(@PathVariable("id") Integer id) {
		auService.Delete(id);
	}
}
