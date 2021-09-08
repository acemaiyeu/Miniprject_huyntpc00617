package com.poy.J6_Huyntpc00617.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poy.J6_Huyntpc00617.Bean.Orderdetails;
import com.poy.J6_Huyntpc00617.Bean.Orderdetailstemp;
import com.poy.J6_Huyntpc00617.Service.OrderDetailsService;
import com.poy.J6_Huyntpc00617.Service.OrderDetailsTempService;
import com.poy.J6_Huyntpc00617.Service.OrderService;

@CrossOrigin("*")
@RestController
public class OrderDetailsRestController {
	@Autowired
	OrderDetailsTempService ordservice;
	@Autowired
	OrderService oservice;
	
	@GetMapping("/rest/orderdetailstemp")
	public List<Orderdetailstemp> findAll() {
		System.out.println("GetAll");
		List<Orderdetailstemp> list = ordservice.findAll();
		for(Orderdetailstemp s : list) {
			System.out.println(s.getOrderdetailsid());
		}
		return list;
	}
	@GetMapping("/rest/orderdetailstemp/{username}/{fromdate}/{todate}")
	public List<Orderdetailstemp> getByUsernameAndTime(@PathVariable("username") String username, @PathVariable("fromdate") Date fromdate, @PathVariable("todate") Date todate) throws ParseException{
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        String fromdates = formatter.format(fromdate);
	        String todates = formatter.format(todate);
	        Date fdate = new SimpleDateFormat("yyyy-MM-dd").parse(fromdates);
	        Date tdate = new SimpleDateFormat("yyyy-MM-dd").parse(todates);
	        if(username.equals("undefined")) {
	        	return ordservice.findByTime(fdate, tdate);
	        }
		System.out.println("Username: "+username+" | fromdate: "+fromdates+" | todate: "+todates );
		return ordservice.findByUsernameAndTime(username, fdate, tdate);
	}
	@GetMapping("/rest/orderdetailstemp/order/{orderid}")
	public List<Orderdetailstemp> findByOrderId(@PathVariable("orderid") Long id){
		return ordservice.findByOrderId(id);
	}
	}
