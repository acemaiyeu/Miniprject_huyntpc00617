package com.poy.J6_Huyntpc00617.Service;

import java.util.Date;
import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Orderdetailstemp;


public interface OrderDetailsTempService {

	List<Orderdetailstemp> findAll();

	List<Orderdetailstemp> findByUsernameAndTime(String username, Date fdate, Date tdate);

	List<Orderdetailstemp> findUsername(String username);

	List<Orderdetailstemp> findByUsernameAndTime(String username, String fromdates, String todates);

	List<Orderdetailstemp> findByTime(Date fdate, Date tdate);

	List<Orderdetailstemp> findByOrderId(Long id);

}
