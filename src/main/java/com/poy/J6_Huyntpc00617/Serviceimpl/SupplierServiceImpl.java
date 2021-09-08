package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Supplier;
import com.poy.J6_Huyntpc00617.Service.SupplierService;
import com.poy.J6_Huyntpc00617.dao.SupplierDAO;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired SupplierDAO Supplierdao;
	
	@Override
	public List<Supplier> getAll() {
		// TODO Auto-generated method stub
		return Supplierdao.findAll();
	}

	@Override
	public Supplier findByID(String supplierid) {
		// TODO Auto-generated method stub
		return Supplierdao.getById(supplierid);
	}

}
