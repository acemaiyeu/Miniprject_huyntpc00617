package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poy.J6_Huyntpc00617.Bean.*;
import com.poy.J6_Huyntpc00617.dao.*;
import com.poy.J6_Huyntpc00617.Service.*;


@Service
public class OrderTempServiceImpl implements OrderTempService{
@Autowired
OrderTempDAO ordao;
@Autowired
OrderDetailTempDAO ddao;
	@Override
	public Orderstemp create(JsonNode orderData) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Susscess0");
		Orderstemp order = mapper.convertValue(orderData, Orderstemp.class);
		System.out.println("Susscess1");
		ordao.save(order);
		System.out.println("Susscess");
		TypeReference<List<Orderdetailstemp>> type = new TypeReference<List<Orderdetailstemp>>() {};
		System.out.println("Susscess2");
		List<Orderdetailstemp> details = mapper.convertValue(orderData.get("listorderdetailstemp"), type)
		.stream().peek(d -> d.setOrdertemp(order)).collect(Collectors.toList());
		System.out.println("Susscess3");
		for(Orderdetailstemp s: details) {
			System.out.println(s);
		}
		ddao.saveAll(details);
		System.out.println("Susscess4");
		return order;
	}
	@Override
	public Orderstemp findById(Long id) {
		return ordao.findById(id).get();
	}
	@Override
	public List<Orderstemp> findByUsername(String username) {
		return ordao.findByUsername(username);
	}

}
