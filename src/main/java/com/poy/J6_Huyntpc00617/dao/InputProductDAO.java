package com.poy.J6_Huyntpc00617.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Input_product;

public interface InputProductDAO extends JpaRepository<Input_product, Integer>{
	@Query("select i from Input_product i where i.product.productidl = :productidl")
	Input_product findByProductId(Integer productidl);
	@Query("select i from Input_product i where i.product.productidl = :id")
	Input_product getProductid(Integer id);

}
