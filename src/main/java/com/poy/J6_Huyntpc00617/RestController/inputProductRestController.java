package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Input_product;
import com.poy.J6_Huyntpc00617.Service.InputProductService;

@RestController
public class inputProductRestController {
	@Autowired InputProductService inpservice;
	
	@PostMapping("/rest/inputproduct")
	public Input_product create(@RequestBody Input_product pro) {
		return inpservice.save(pro);
	}
	@GetMapping("/rest/inputproduct")
	public List<Input_product> getAll(){
		List<Input_product> list = inpservice.getAll();
		for(Input_product i : list) {
			//System.out.println("SupplierId: "+i.getSupplier().getSupplierid()+"\n");
		}
		return  list;
	}
}
