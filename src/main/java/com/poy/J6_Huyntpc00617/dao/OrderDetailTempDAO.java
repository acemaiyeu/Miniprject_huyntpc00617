package com.poy.J6_Huyntpc00617.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Orderdetailstemp;

public interface OrderDetailTempDAO extends JpaRepository<Orderdetailstemp, Integer>{
 //	@Query("SELECT new Statictical(o.product.id, o.product.name, COUNT(o.quantity), o.price) FROM OrderDetail o GROUP BY o.product.id, o.product.name, o.price")
 	//List<Statictical> statictical();
	@Query("SELECT o FROM Orderdetailstemp o WHERE o.ordertemp.accounts.username = :username")
	List<Orderdetailstemp> findByUsername(String username);
 	@Query("SELECT o FROM Orderdetailstemp o WHERE o.ordertemp.accounts.username = :username and o.ordertemp.orderdate >= :fromdate and o.ordertemp.orderdate <= :todate")
 	List<Orderdetailstemp> findByUsernameandTime(String username, Date fromdate, Date todate);
 	@Query("SELECT o FROM Orderdetailstemp o WHERE o.ordertemp.orderdate >= :fdate and o.ordertemp.orderdate <= :tdate")
 	List<Orderdetailstemp> findByTime(Date fdate, Date tdate);
 	@Query("SELECT o FROM Orderdetailstemp o WHERE o.ordertemp.id = :id")
 	List<Orderdetailstemp> findByOrderID(Long id);  
}
