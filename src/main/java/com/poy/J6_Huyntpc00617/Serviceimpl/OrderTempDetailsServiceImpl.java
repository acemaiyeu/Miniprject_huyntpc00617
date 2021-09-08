package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poy.J6_Huyntpc00617.Bean.Orderdetails;
import com.poy.J6_Huyntpc00617.Bean.Orderdetailstemp;
import com.poy.J6_Huyntpc00617.dao.OrderDetailDAO;
import com.poy.J6_Huyntpc00617.dao.OrderDetailTempDAO;
import com.poy.J6_Huyntpc00617.Service.OrderDetailsService;
import com.poy.J6_Huyntpc00617.Service.OrderDetailsTempService;
@Service
public class OrderTempDetailsServiceImpl implements OrderDetailsTempService{
	@Autowired 
	OrderDetailTempDAO oddao;
	
	@Override
	public List<Orderdetailstemp> findAll() {
		// TODO Auto-generated method stub
		return oddao.findAll();
	}

	@Override
	public List<Orderdetailstemp> findByUsernameAndTime(String username, Date fdate, Date tdate) {
		// TODO Auto-generated method stub
		return oddao.findByUsernameandTime(username, fdate, tdate);
	}

	@Override
	public List<Orderdetailstemp> findUsername(String username) {
		// TODO Auto-generated method stub
		return oddao.findByUsername(username);
	}

	@Override
	public List<Orderdetailstemp> findByUsernameAndTime(String username, String fromdates, String todates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orderdetailstemp> findByTime(Date fdate, Date tdate) {
		// TODO Auto-generated method stub
		return oddao.findByTime(fdate, tdate);
	}

	@Override
	public List<Orderdetailstemp> findByOrderId(Long id) {
		// TODO Auto-generated method stub
		return oddao.findByOrderID(id);
	}

	

}
