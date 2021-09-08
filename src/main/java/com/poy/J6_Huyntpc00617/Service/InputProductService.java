package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Input_product;

public interface InputProductService {
	Input_product save(Input_product inputproduct);

	Input_product findById(Integer productidl);

	List<Input_product> getAll();

	Input_product getProductid(Integer id);

	void deleteByID(Integer input_id);
}
