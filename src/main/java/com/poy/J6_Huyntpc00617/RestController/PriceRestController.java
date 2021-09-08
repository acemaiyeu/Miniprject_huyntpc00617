package com.poy.J6_Huyntpc00617.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Price;
import com.poy.J6_Huyntpc00617.Service.PriceService;

@RestController
public class PriceRestController {
	@Autowired PriceService priceservice;
	@PostMapping("/rest/price")
	public void create(@RequestBody Price price) {
		System.out.println(price);
//		return priceservice.save(price);
	}
}
