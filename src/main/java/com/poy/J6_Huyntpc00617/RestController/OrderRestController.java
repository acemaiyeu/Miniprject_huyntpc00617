package com.poy.J6_Huyntpc00617.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poy.J6_Huyntpc00617.Bean.Orders;
import com.poy.J6_Huyntpc00617.Service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderRestController {
	@Autowired OrderService orderservice;
	
	@PostMapping("/rest/orders")
	public Orders create(@RequestBody JsonNode orderData) {
		return orderservice.create(orderData);
	}
}
