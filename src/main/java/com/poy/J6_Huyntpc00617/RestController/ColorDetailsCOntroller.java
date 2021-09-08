package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.ColorsDetails;
import com.poy.J6_Huyntpc00617.Service.ColorsDetailsService;

@RestController
@RequestMapping("/rest/colorsdetails")
public class ColorDetailsCOntroller {
	@Autowired ColorsDetailsService cdservice;
	@GetMapping()
	public List<ColorsDetails> getAll(){
		return cdservice.getAll();
	}
}
