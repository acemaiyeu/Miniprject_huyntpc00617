package com.poy.J6_Huyntpc00617.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poy.J6_Huyntpc00617.Bean.*;

public interface PriceDAO extends JpaRepository<Price, Integer>{
	@Query(value = "SELECT * FROM PRICE P JOIN Product pd on pd.productid = p.productid join Input_product i on i.productid = pd.productid where p.productid = ? order by date_output desc LIMIT 1;", nativeQuery = true)
	Price GetOnePrice(Integer productid);
	@Query("select p from Price p where p.product.productidl = :productid and p.date_output = :date")
	Price getByProductIdAndNewDate(Integer productid, Date date);
	@Query("select p from Price p where p.product.productidl = :id")
	List<Price> getByProductID(Integer id);
	@Query("delete from Price p where p.product.productidl = :id")
	void deleteByProductId(Integer id);
}
