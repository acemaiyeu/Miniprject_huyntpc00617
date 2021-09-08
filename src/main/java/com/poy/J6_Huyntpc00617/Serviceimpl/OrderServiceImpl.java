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
public class OrderServiceImpl implements OrderService{
@Autowired
OrderDAO ordao;
@Autowired
OrderDetailDAO ddao;
	@Override
	public Orders create(JsonNode orderData) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		Orders order = mapper.convertValue(orderData, Orders.class);
		ordao.save(order);
		System.out.println("Susscess");
		TypeReference<List<Orderdetails>> type = new TypeReference<List<Orderdetails>>() {};
		List<Orderdetails> details = mapper.convertValue(orderData.get("orderDetails"), type)
		.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
	}
	@Override
	public Orders findById(Long id) {
		return ordao.findById(id).get();
	}
	@Override
	public List<Orders> findByUsername(String username) {
		return ordao.findByUsername(username);
	}

}
