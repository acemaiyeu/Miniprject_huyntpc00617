package com.poy.J6_Huyntpc00617.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Orderdetails;

public interface OrderDetailDAO extends JpaRepository<Orderdetails, Integer>{
 //	@Query("SELECT new Statictical(o.product.id, o.product.name, COUNT(o.quantity), o.price) FROM OrderDetail o GROUP BY o.product.id, o.product.name, o.price")
 	//List<Statictical> statictical();
	@Query("SELECT o FROM Orderdetails o WHERE o.order.accounts.username = :username")
	List<Orderdetails> findByUsername(String username);
 	@Query("SELECT o FROM Orderdetails o WHERE o.order.accounts.username = :username and o.order.Orderdate >= :fromdate and o.order.Orderdate <= :todate")
 	List<Orderdetails> findByUsernameandTime(String username, Date fromdate, Date todate);
 	@Query("SELECT o FROM Orderdetails o WHERE o.order.Orderdate >= :fdate and o.order.Orderdate <= :tdate")
 	List<Orderdetails> findByTime(Date fdate, Date tdate);
 	@Query("SELECT o FROM Orderdetails o WHERE o.order.id = :id")
 	List<Orderdetails> findByOrderID(Long id);  
}
 