package com.poy.J6_Huyntpc00617.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Descriptions;
import com.poy.J6_Huyntpc00617.Service.DescriptionsService;

@RestController
@RequestMapping("/rest/descriptions")
public class DescriptionRestController {
	@Autowired DescriptionsService deservice;
	@GetMapping
	public List<Descriptions> getAll() {
		
		return deservice.getAll();
	}
}
