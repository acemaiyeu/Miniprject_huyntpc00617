package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Color;

public interface ColorDAO extends JpaRepository<Color, Integer>{
	@Query("select c from Color c where c.product.productidl = :productid")
	List<Color> getColorName(Integer productid);
	@Query("select c from Color c where c.product.productidl = :productid and c.colorsdetails.colorid = :tim")
	Color findByProductColordetails(Integer productid, String tim);
	@Query("select c from Color c where c.product.productidl = :id")
	List<Color> getProductid(Integer id);
}

