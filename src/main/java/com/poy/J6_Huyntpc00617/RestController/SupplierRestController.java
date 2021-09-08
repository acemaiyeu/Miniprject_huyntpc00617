package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Supplier;
import com.poy.J6_Huyntpc00617.Service.SupplierService;

@RestController
@RequestMapping("/rest/supplier")
public class SupplierRestController {
	@Autowired SupplierService sservice;
@GetMapping()
public List<Supplier> getAll(){
	return sservice.getAll();
}
}
