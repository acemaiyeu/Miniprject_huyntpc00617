package com.poy.J6_Huyntpc00617.Service;

import java.util.Date;
import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Orderdetails;


public interface OrderDetailsService {

	List<Orderdetails> findAll();

	List<Orderdetails> findByUsernameAndTime(String username, Date fdate, Date tdate);

	List<Orderdetails> findUsername(String username);

	List<Orderdetails> findByUsernameAndTime(String username, String fromdates, String todates);

	List<Orderdetails> findByTime(Date fdate, Date tdate);

	List<Orderdetails> findByOrderId(Long id);

}
