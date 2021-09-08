package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Category;
import com.poy.J6_Huyntpc00617.Bean.Product;

public interface CategoryDAO extends JpaRepository<Category, String>{
	@Query("Select p FROM Product p where p.category.categoryid = :cid")
	List<Product> findByCategory(String cid);
}
