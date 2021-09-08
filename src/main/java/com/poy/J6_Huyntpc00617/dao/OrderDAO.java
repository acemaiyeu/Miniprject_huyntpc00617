package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Orders;

public interface OrderDAO extends JpaRepository<Orders, Long>{
	@Query("SELECT o FROM Orders o WHERE o.accounts.username = :username")
	List<Orders> findByUsername(String username);
}
