package com.poy.J6_Huyntpc00617.Service;

import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Bean.ReportProduct;

public interface ProductService {
	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

	Product create(Product product);

	void delete(Integer id);

	Product update(Product product);
	
	List<ReportProduct> findAllReport();

	Product getProductLast();
}
