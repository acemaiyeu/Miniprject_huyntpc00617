package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poy.J6_Huyntpc00617.Bean.Orders;
import com.poy.J6_Huyntpc00617.Bean.Orderstemp;

public interface OrderTempService {
	Orderstemp create(JsonNode orderData);

	Orderstemp findById(Long id);

	List<Orderstemp> findByUsername(String username);

}
