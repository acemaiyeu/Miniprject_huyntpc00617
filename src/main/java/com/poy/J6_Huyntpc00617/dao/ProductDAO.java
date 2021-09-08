package com.poy.J6_Huyntpc00617.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.Product;
import com.poy.J6_Huyntpc00617.Bean.ReportProduct;


public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("Select p FROM Product p where p.productidl = :id")
	Product findByIdProduct(Integer id);
	@Query(value = "select new ReportProduct(p.productid, p.productname, p.createdate, p.updateedate, c.categoryname, p.status,  p.imagename1, p.imagename2, p.imagename3, inp.quantity, p.price, inp.unitproduct, s.supplierid) from Product p join Price price on p.productid = price.productid join Input_product inp on inp.productid = p.productid join Category c on c.categoryid = p .categoryid join Supplier s on s.supplierid = inp.supplierid", nativeQuery = true)
	List<ReportProduct> Report();
	@Query(value="select * from Product p order by p.productid desc LIMIT 1", nativeQuery = true)
	Product getProductLast();
}
