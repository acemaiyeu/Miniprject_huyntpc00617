package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Orders;
import com.poy.J6_Huyntpc00617.Bean.Orderstemp;

public interface OrderTempDAO extends JpaRepository<Orderstemp, Long>{
	@Query("SELECT o FROM Orderstemp o WHERE o.accounts.username = :username")
	List<Orderstemp> findByUsername(String username);
}
