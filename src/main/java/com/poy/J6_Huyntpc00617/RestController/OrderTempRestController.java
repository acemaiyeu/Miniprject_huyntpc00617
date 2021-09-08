package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poy.J6_Huyntpc00617.Bean.Orderstemp;

import com.poy.J6_Huyntpc00617.Service.OrderTempService;

@CrossOrigin("*")
@RestController
public class OrderTempRestController {
	@Autowired OrderTempService orderservice;
	
	@PostMapping("/rest/orderstemp")
	public Orderstemp create(@RequestBody JsonNode orderData) {
		return orderservice.create(orderData);
	}

}
