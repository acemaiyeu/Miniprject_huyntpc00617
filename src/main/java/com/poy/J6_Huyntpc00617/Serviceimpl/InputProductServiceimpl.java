package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Input_product;
import com.poy.J6_Huyntpc00617.Service.InputProductService;
import com.poy.J6_Huyntpc00617.dao.InputProductDAO;

@Service
public class InputProductServiceimpl implements InputProductService{
@Autowired InputProductDAO inpdao;
	
	@Override
	public Input_product save(Input_product inputproduct) {
		// TODO Auto-generated method stub
		return inpdao.save(inputproduct);
	}

	@Override
	public Input_product findById(Integer productidl) {
		// TODO Auto-generated method stub
		return inpdao.findByProductId(productidl);
	}

	@Override
	public List<Input_product> getAll() {
		// TODO Auto-generated method stub
		return inpdao.findAll();
	}

	@Override
	public Input_product getProductid(Integer id) {
		// TODO Auto-generated method stub
		return inpdao.getProductid(id);
	}

	@Override
	public void deleteByID(Integer input_id) {
		inpdao.deleteById(input_id);
	}

}
