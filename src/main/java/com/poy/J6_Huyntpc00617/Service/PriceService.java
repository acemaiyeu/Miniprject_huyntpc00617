package com.poy.J6_Huyntpc00617.Service;

import java.util.Date;
import java.util.List;

import com.poy.J6_Huyntpc00617.Bean.Price;
import com.poy.J6_Huyntpc00617.Bean.Product;

public interface PriceService {
	Price GetOneOutput(Integer productid);

	Double priceProduct(Integer id);

	Price save(Price price);

	List<Price> getAll();

	Price ProductIDAndNewDate(Integer productid, Date date);

	List<Price> getProductId(Integer id);

	void deleteByProductID(Integer id);

	void deleteByID(Integer priceid);
}
