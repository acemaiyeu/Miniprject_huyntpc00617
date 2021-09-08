package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poy.J6_Huyntpc00617.Bean.Orders;

public interface OrderService {
	Orders create(JsonNode orderData);

	Orders findById(Long id);

	List<Orders> findByUsername(String username);

}
